package ynd.core.exception;

import ynd.core.emums.ResponseEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description 自定义异常
 *
 * @author Yang Daqiong
 * @date 2019-10-06 22:38
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class CustomException extends RuntimeException{

    private Integer code;

    private String message;

    public CustomException() {
        
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CustomException(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }
}
