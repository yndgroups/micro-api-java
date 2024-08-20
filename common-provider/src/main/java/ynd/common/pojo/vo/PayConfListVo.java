package ynd.common.pojo.vo;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 *  第三方配置列表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value="配置列表", description="配置管理")
public class PayConfListVo {

    @ApiModelProperty(value = "配置id")
    private String confId;

    @ApiModelProperty(value = "应用名称")
    private String appName;

    @ApiModelProperty(value = "应用appId(微信或支付宝appId)")
    private String appId;

    @ApiModelProperty(value = "秘钥")
    private String appSecret;

    @ApiModelProperty(value = "商户号")
    private String mchId;

    @ApiModelProperty(value = "app秘钥")
    private String paterNerKey;

    @ApiModelProperty(value = "账号绑定的邮箱")
    private String email;

    @ApiModelProperty(value = "账号绑定的手机号")
    private String phone;

    @ApiModelProperty(value = "异步回调地址")
    private String notifyUrl;

    @ApiModelProperty(value = "同步回调地址")
    private String returnUrl;

    @ApiModelProperty(value = "公众号用于调用微信JS接口的临时票据")
    private String jsApiTicket;

    @ApiModelProperty(value = "Token可以由开发者任意填写，用作生成签名（该Token会配置在服务器中和接口URL中包含的Token进行比对，从而验证安全性）。")
    private String token;

    @ApiModelProperty(value = "默认支付金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "消息格式化（比如：JSON）")
    private String msgDataFormat;

    @ApiModelProperty(value = "EncodingAESKey由开发者手动填写或随机生成，将用作消息体加解密密钥。（43位）")
    private String aesKey;

    @ApiModelProperty(value = "时间戳")
    private String timestamp;

    @ApiModelProperty(value = "删除状态(1：未删除，2：已删除，默认是1)")
    private Integer delStatus;

}
