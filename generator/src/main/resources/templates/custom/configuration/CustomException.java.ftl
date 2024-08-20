package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration;

/**
 * description 自定义异常
 *@return
 *@param
 *@author yangdaqiong
 *@date 2019/10/6
 **/
public class CustomException extends RuntimeException{

    private Integer code;
    private String message;

    /**
     * @Description  Ajax请求异常
     * @param
     * @return
     * @author yangdaqiong
     * @date 2019-07-17 14:01
     */
    public CustomException(ResponseEnum responseEnum){
        this.message = responseEnum.getMsg();
        this.code = responseEnum.getCode();
    }

    /**
     * @Description  Ajax请求异常
     * @param
     * @return
     * @author yangdaqiong
     * @date 2019-07-17 14:01
     */
    public CustomException(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}