package ynd.common.entity;

import java.math.BigDecimal;

import ynd.core.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_pay_conf")
@ApiModel(value="第三方接入配置实体", description="第三方接入配置")
public class PayConfEntity extends BaseEntity {

    @ApiModelProperty(value = "配置id")
    @TableId(value = "conf_id")
    private Long confId;

    @ApiModelProperty(value = "应用名称")
    @TableField("app_name")
    private String appName;

    @ApiModelProperty(value = "应用appId(微信或支付宝appId)")
    @TableField("app_id")
    private String appId;

    @ApiModelProperty(value = "账号绑定的邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "账号绑定的手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "秘钥")
    @TableField("app_secret")
    private String appSecret;

    @ApiModelProperty(value = "商户号")
    @TableField("mch_id")
    private String mchId;

    @ApiModelProperty(value = "api秘钥")
    @TableField("pater_ner_key")
    private String paterNerKey;

    @ApiModelProperty(value = "异步回调地址")
    @TableField("notify_url")
    private String notifyUrl;

    @ApiModelProperty(value = "同步回调地址")
    @TableField("return_url")
    private String returnUrl;

    @ApiModelProperty(value = "公众号用于调用微信JS接口的临时票据")
    @TableField("js_api_ticket")
    private String jsApiTicket;

    @ApiModelProperty(value = "Token可以由开发者任意填写，用作生成签名（该Token会配置在服务器中和接口URL中包含的Token进行比对，从而验证安全性）。")
    @TableField("token")
    private String token;

    @ApiModelProperty(value = "默认支付金额")
    @TableField("amount")
    private BigDecimal amount;

    @ApiModelProperty(value = "消息格式化（比如：JSON）")
    @TableField("msg_data_format")
    private String msgDataFormat;

    @ApiModelProperty(value = "EncodingAESKey由开发者手动填写或随机生成，将用作消息体加解密密钥。（43位）")
    @TableField("aes_key")
    private String aesKey;

    @ApiModelProperty(value = "时间戳")
    @TableField("timestamp")
    private String timestamp;

}
