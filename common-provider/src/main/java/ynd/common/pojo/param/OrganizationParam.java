package ynd.common.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 企业或组织信息表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value="组织搜索条件", description="企业或组织信息表")
public class OrganizationParam {

    @ApiModelProperty(value = "登录账号")
    private String account;

    @ApiModelProperty(value = "来源 1 后台管理员添加 2 自己注册")
    private String entsource;

    @ApiModelProperty(value = "企业名称")
    private String name;

    @ApiModelProperty(value = "企业logo")
    private String logoPurl;

    @ApiModelProperty(value = "统一社会信用代码")
    private String creditCode;

    @ApiModelProperty(value = "注册地址")
    private String regaddress;

    @ApiModelProperty(value = "企业注册号")
    private String entRegno;

    @ApiModelProperty(value = "企业营业执照地址")
    private String licensePhotoUrl;

    @ApiModelProperty(value = "法人")
    private String legalPerson;

    @ApiModelProperty(value = "联系人")
    private String contactsPerson;

    @ApiModelProperty(value = "联系电话")
    private String contactsNumber;

    @ApiModelProperty(value = "联系邮箱")
    private String contactsEmail;

    @ApiModelProperty(value = "公司规模")
    private String scaleEnt;

}
