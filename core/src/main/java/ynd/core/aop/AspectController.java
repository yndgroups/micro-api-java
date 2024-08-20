package ynd.core.aop;

import ynd.core.annotation.AuthPermissions;
import ynd.core.constant.BaseConstant;
import ynd.core.exception.CustomException;
import ynd.core.model.TokenParseUserAuth;
import ynd.core.service.RedisUserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Before: 前置通知, 在方法执行之前执行
 * @After: 后置通知, 在方法执行之后执行 。
 * @AfterRunning: 返回通知, 在方法返回结果之后执行
 * @AfterThrowing: 异常通知, 在方法抛出异常之后
 * @Around: 环绕通知, 围绕着方法执行
 */
@Component
@Aspect
public class AspectController {

    @Autowired
    private RedisUserService redisUserService;

    @Pointcut("@annotation(ynd.core.annotation.AuthPermissions)")
    public void controllerPointcut() {
    }

    //后置通知（可不写），其他通知省略
    //@After("aspectController()")
    //public void after(){
        //System.out.println("after++++++++++++++++++++++++++++++");
        //System.out.println("after++++++++++++++++++++++++++++++");
        //System.out.println("after++++++++++++++++++++++++++++++");
        //System.out.println("after++++++++++++++++++++++++++++++");
        //System.out.println("after++++++++++++++++++++++++++++++");
        //System.out.println("after++++++++++++++++++++++++++++++");
        //System.out.println("after++++++++++++++++++++++++++++++");
        //System.out.println("after++++++++++++++++++++++++++++++");
        //System.out.println("after++++++++++++++++++++++++++++++");
        //System.out.println("after++++++++++++++++++++++++++++++");
        //System.out.println("after++++++++++++++++++++++++++++++");
        //System.out.println("after++++++++++++++++++++++++++++++");
    //}

    @Before("controllerPointcut()")
    public void controllerBefore(JoinPoint joinPoint) throws Exception {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();//获取执行方法名
        AuthPermissions authPermissions = method.getAnnotation(AuthPermissions.class);
        // System.out.println(redisUserService.getAuthUser("0caa3404f0284990ada8c866f4e637521575644566513"));
        TokenParseUserAuth authUser = redisUserService.getAuthUser();
        // 超级管理员不做任何权限拦截
        if (!Objects.equals(authUser.getUserId(), BaseConstant.administrator)) {
            String powerSign = redisUserService.getPowerSign();
            if (null != authPermissions) {
                String value = authPermissions.value();
                //获取注解参数  System.out.println("获取注解参数值 >> authPermissions -> value= " + value);
                if (powerSign.indexOf(value) == -1) {
                    throw new CustomException(0, "您没有操作权限");
                }
            }
        }
        //获取方法传递的参数
        Object[] args = joinPoint.getArgs();
        if (null != args) {
            for (Object o : args) {
                System.out.println("方法传递的参数: " + o.toString());
            }
        }
        // System.out.println(">>>>>>>>>>>>>>>>>>>>>> controllerBefore 方法，执行接口【" + methodName + "】之前触发 >>>>>>>>>>>>>>>>>>>>>>");
    }

    @AfterReturning("controllerPointcut()")
    public void controllerAfterReturning(JoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Method method = signature.getMethod();
        //获取执行方法名
        String methodName = method.getName();
        // System.out.println("==============MyAfterCut方法，执行完接口【" + methodName + "】之后触发=============");
    }


    /*@Around("aspectController()")
    public Object doLogAround(ProceedingJoinPoint joinPoint) throws Throwable{

        //目的：获取切入点方法上自定义RequiredLog注解中operation属性值

        //1.1获取目标对象对应的字节码对象
        Class<?> targetCls=joinPoint.getTarget().getClass();


        //1.2获取目标方法对象

        //1.2.1 获取方法签名信息从而获取方法名和参数类型
        Signature signature=joinPoint.getSignature();


        //1.2.1.1将方法签名强转成MethodSignature类型，方便调用
        MethodSignature ms= (MethodSignature)signature;

        //1.2.2通过字节码对象以及方法签名获取目标方法对象
        Method targetMethod=targetCls.getDeclaredMethod(ms.getName(),ms.getParameterTypes());


        //1.3获取目标方法对象上注解中的属性值

        //1.2.3 获取方法上的自定义requiredLog注解
        // RequiredLog requiredLog=targetMethod.getAnnotation(RequiredLog.class);

        //1.2.4 获取自定义注解中operation属性的值
        // String operation=requiredLog.operation();

        return null;
    }*/
}
