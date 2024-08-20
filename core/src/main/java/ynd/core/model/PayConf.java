package ynd.core.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
public class PayConf {

    private Long confId;

    private String appName;

    private String appId;

    private Long fromAppId;

    private String appSecret;

    private String mchId;

    private String paterNerKey;

    private String notifyUrl;

    private String returnUrl;

    private String jsApiTicket;

    private String token;

    private BigDecimal amount;

    private String msgDataFormat;

    private String aesKey;

    private String timestamp;

    private Integer delStatus;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

}
