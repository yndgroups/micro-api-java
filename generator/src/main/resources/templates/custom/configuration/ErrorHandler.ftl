package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration;

import ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.vo.BackVO;
import ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.utils.ValidateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * description 全局错误处理
 *@return
 *@param
 *@author yangdaqiong
 *@date 2019/10/6 20:05
 **/
@ControllerAdvice
@ResponseBody
public class ErrorHandler {

    /**
     * 处理错误的请求参数
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BackVO handleValidationExceptions(MethodArgumentNotValidException ex) {
        Logger.e("【字段验证异常：错误信息为】：{}", ex.getMessage());
        Map<String, String> errors = new HashMap<>(0);
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new BackVO(errors, ResponseEnum.PARAMS_NO_PASS);
    }


    /**
     * 处理错误的请求参数
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public BackVO handleConstraintViolationException(ConstraintViolationException e) {
        Logger.e("【字段验证异常：错误信息为】：{}", e.getMessage());
        return new BackVO(e.getMessage(), ResponseEnum.PARAMS_NO_PASS);
    }

    /**
     * 全局异常捕捉处理
     * @param : request
     * @param : e
     * @return Object
     */
    @ExceptionHandler(value = Exception.class)
    public BackVO defaultExceptionHandler(Exception e) {
        // 打印异常 开发环境打印，生产环境关闭
        Logger.e("【全局异常：错误信息为】：{}", e.getMessage());
        String redisPort = "6379";
        String pool = "pool";
        String redisName = "Redis";
        if (ValidateUtil.isNotEmpty(e.getMessage())){
            if (e.getMessage().indexOf(redisPort) != -1 && e.getMessage().indexOf(pool) != -1  && e.getMessage().indexOf(redisName) != -1) {
                return new BackVO("redis连接失败", ResponseEnum.REQ_FAIL);
            }
        }
        return new BackVO(e.getMessage(), ResponseEnum.REQ_FAIL);
    }

    /**
     * description 自定义拦截器
     * @param  e
     * @return BackVO
     * @author yangdaqiong
     * @date 2019-06-30 12:17
     */
    @ExceptionHandler(value = CustomException.class)
    public BackVO customExceptionHandler(CustomException e) {
        // 打印异常 开发环境打印，生产环境关闭
        Logger.e("【自定义异常：错误信息为】：{}", e.getMessage());
        return new BackVO(e);
    }

    /**
     * description 判断是否是ajax请求
     * @param httpRequest
     * @return boolean
     * @author yangdaqiong
     * @date 2019-07-17 14:44
     */
    public static boolean isAjax(HttpServletRequest httpRequest) {
        String xRequestedWith = httpRequest.getHeader("X-Requested-With");
        return (xRequestedWith != null && "XMLHttpRequest".equals(xRequestedWith));
    }
}
