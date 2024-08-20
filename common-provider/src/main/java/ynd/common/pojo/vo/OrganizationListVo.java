package ynd.common.pojo.vo;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="组织列表", description="组织管理")
public class OrganizationListVo {

    @ApiModelProperty(value = "主键ID")
    private String orgId;

    @ApiModelProperty(value = "关联用户ID")
    private String userId;

    @ApiModelProperty(value = "登录账号")
    private String account;

    @ApiModelProperty(value = "来源 1 后台管理员添加 2 自己注册")
    private String entsource;

    @ApiModelProperty(value = "来源为1时的添加的用户id")
    private String adduid;

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

    @ApiModelProperty(value = "企业营业时间")
    private String dbtime;

    @ApiModelProperty(value = "法人")
    private String legalPerson;

    @ApiModelProperty(value = "法人介绍地址")
    private String legalPersonUrl;

    @ApiModelProperty(value = "法人身份证正面地址")
    private String legalPersonCardNurl;

    @ApiModelProperty(value = "法人身份证反面地址")
    private String legalPersonCardPurl;

    @ApiModelProperty(value = "联系人")
    private String contactsPerson;

    @ApiModelProperty(value = "联系电话")
    private String contactsNumber;

    @ApiModelProperty(value = "联系邮箱")
    private String contactsEmail;

    @ApiModelProperty(value = "公司规模")
    private String scaleEnt;

    @ApiModelProperty(value = "人员规模最小人数，-1 为以下")
    private Integer scalePersonMin;

    @ApiModelProperty(value = "人工规模最大人数，-1 为以上")
    private Integer scalePersonMax;

    @ApiModelProperty(value = "企业性质 多个使用-分割")
    private String natures;

    @ApiModelProperty(value = "企业浏览量")
    private Long enterpriseVisit;

    @ApiModelProperty(value = "行业类别id，多个使用-分割")
    private String indtypeIds;

    @ApiModelProperty(value = "行业类别名称，多个使用-分割")
    private String indtypeNames;

    @ApiModelProperty(value = "公司福利 使用-分割")
    private String welfare;

    @ApiModelProperty(value = "公司特点 使用-分割")
    private String characteristic;

    @ApiModelProperty(value = "描述")
    private String descript;

    @ApiModelProperty(value = "岗位数量")
    private Long jobnum;

    @ApiModelProperty(value = "企业状态 0 待审核 1 审核失败 2 审核成功 3 再次提交")
    private Long auditState;

    @ApiModelProperty(value = "联系邮箱")
    private String email;

    @ApiModelProperty(value = "省代码")
    private String areaCode;

    @ApiModelProperty(value = "省名称")
    private String areaName;

    @ApiModelProperty(value = "地质详情 比如多少栋楼多少号")
    private String eaddrDetail;

    @ApiModelProperty(value = "公司经度")
    private BigDecimal entLng;

    @ApiModelProperty(value = "公司纬度")
    private BigDecimal entLat;

    @ApiModelProperty(value = "审核消息")
    private String auditmsg;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createtime;

    @ApiModelProperty(value = "上一次更新时间")
    private LocalDateTime updatetime;

    @ApiModelProperty(value = "是否删除： 1没有删除 2 删除")
    private Integer isdelete;

    @ApiModelProperty(value = "是否为推荐企业或组织 1是 2不是 ")
    private Integer isrecom;

    @ApiModelProperty(value = "推荐企业显示排序")
    private Integer recomSort;

    @ApiModelProperty(value = "是否为行业巨头或组织 1是 2不是")
    private Integer ismagnate;

    @ApiModelProperty(value = "行业巨头显示排序")
    private Integer magnateSort;

    @ApiModelProperty(value = "是否为热门企业 1 是 0不是")
    private Integer ishotEnt;

    @ApiModelProperty(value = "热门企业或组织显示排序")
    private Integer hotEntSort;

    @ApiModelProperty(value = "删除状态（1：正常，2：删除）")
    private Integer delStatus;

}
