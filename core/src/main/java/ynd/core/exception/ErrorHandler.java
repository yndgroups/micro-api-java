package ynd.core.exception;


import ynd.core.logs.Logger;
import ynd.core.emums.ResponseEnum;
import ynd.core.result.BackResult;
import ynd.core.utils.ValidateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * description 全局错误处理
 *
 * @author yangdaqiong
 * @date 2019-10-06 20:05
 **/
@ControllerAdvice
@ResponseBody
public class ErrorHandler {

    /**
     * description 处理错误的请求参数
     *
     * @param exception 异常信息
     * @return BackVO 返回异常结果
     * @author yangdaqiong
     * @date 2020-08-13 14:25
     **/
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BackResult handleValidationExceptions(MethodArgumentNotValidException exception) {
        Logger.e("handleValidationExceptions：info：>>>> field validation, ", exception.getMessage());
        Map<String, String> errors = new HashMap<>(0);
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new BackResult<Object>(errors, ResponseEnum.PARAMS_NO_PASS);
    }


    /**
     * description 处理错误的请求参数
     *
     * @param exception 异常信息
     * @return BackVO 返回异常结果
     * @author yangdaqiong
     * @date 2020-08-13 14:27
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public BackResult handleConstraintViolationException(ConstraintViolationException exception) {
        Logger.e("handleConstraintViolationException：info：>>>> field validation, ", exception.getMessage());
        return new BackResult<Object>(exception.getMessage(), ResponseEnum.PARAMS_NO_PASS);
    }

    /**
     * description 默认全局异常捕捉处理
     *
     * @param exception
     * @return 返回异常结果
     * @author yangdaqiong
     * @date 2020-08-13 14:28
     */
    @ExceptionHandler(value = Exception.class)
    public BackResult defaultExceptionHandler(Exception exception) {
        // 打印异常 开发环境打印，生产环境关闭
        Logger.e("defaultExceptionHandler：info：>>>>", exception.getMessage());
        if (ValidateUtil.isNotEmpty(exception.getMessage())) {
            if (exception.getMessage().indexOf("6379") != -1 || exception.getMessage().indexOf("pool") != -1 || exception.getMessage().indexOf("Redis") != -1) {
                return new BackResult<Object>("Redis link fail", ResponseEnum.REDIS_LINK_FAIL);
            } else if (exception.getMessage().indexOf("ClientException") != -1) {
                return new BackResult<Object>("microservice call exception", ResponseEnum.MICROSERVICES_LINK_FAIL);
            } else if (exception.getMessage().indexOf("Connection refused") != -1) {
                return new BackResult<Object>("microservice Connection refused", ResponseEnum.MICROSERVICES_CONNECTION_REFUSED);
            } else if (exception.getMessage().indexOf("Read timed out") != -1) {
                return new BackResult<Object>("microservice request timeout", ResponseEnum.MICROSERVICES_READ_TIMED_OUT);
            }
        }
        return new BackResult<Object>(exception.getMessage(), ResponseEnum.REQ_FAIL);
    }

    /**
     * description 自定义拦截器
     *
     * @param e
     * @return BackVO
     * @author yangdaqiong
     * @date 2019-06-30 12:17
     */
    @ExceptionHandler(value = CustomException.class)
    public BackResult customExceptionHandler(CustomException e) {
        // 打印异常 开发环境打印，生产环境关闭
        Logger.e("customExceptionHandler：info：>>>>", e.getMessage());
        return new BackResult(e);
    }
}
