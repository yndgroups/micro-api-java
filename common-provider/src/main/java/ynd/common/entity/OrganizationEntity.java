package ynd.common.entity;

import java.math.BigDecimal;

import ynd.core.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_organization")
@ApiModel(value="OrganizationEntity对象", description="企业或组织信息表")
public class OrganizationEntity extends BaseEntity {

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "org_id", type = IdType.ASSIGN_UUID)
    private Long orgId;

    @ApiModelProperty(value = "关联用户ID")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "登录账号")
    @TableField("account")
    private String account;

    @ApiModelProperty(value = "来源 1 后台管理员添加 2 自己注册")
    @TableField("entsource")
    private String entsource;

    @ApiModelProperty(value = "来源为1时的添加的用户id")
    @TableField("adduid")
    private String adduid;

    @ApiModelProperty(value = "企业名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "企业logo")
    @TableField("logo_purl")
    private String logoPurl;

    @ApiModelProperty(value = "统一社会信用代码")
    @TableField("credit_code")
    private String creditCode;

    @ApiModelProperty(value = "注册地址")
    @TableField("regaddress")
    private String regaddress;

    @ApiModelProperty(value = "企业注册号")
    @TableField("ent_regno")
    private String entRegno;

    @ApiModelProperty(value = "企业营业执照地址")
    @TableField("license_photo_url")
    private String licensePhotoUrl;

    @ApiModelProperty(value = "企业营业时间")
    @TableField("dbtime")
    private String dbtime;

    @ApiModelProperty(value = "法人")
    @TableField("legal_person")
    private String legalPerson;

    @ApiModelProperty(value = "法人介绍地址")
    @TableField("legal_person_url")
    private String legalPersonUrl;

    @ApiModelProperty(value = "法人身份证正面地址")
    @TableField("legal_person_card_nurl")
    private String legalPersonCardNurl;

    @ApiModelProperty(value = "法人身份证反面地址")
    @TableField("legal_person_card_purl")
    private String legalPersonCardPurl;

    @ApiModelProperty(value = "联系人")
    @TableField("contacts_person")
    private String contactsPerson;

    @ApiModelProperty(value = "联系电话")
    @TableField("contacts_number")
    private String contactsNumber;

    @ApiModelProperty(value = "联系邮箱")
    @TableField("contacts_email")
    private String contactsEmail;

    @ApiModelProperty(value = "公司规模")
    @TableField("scale_ent")
    private String scaleEnt;

    @ApiModelProperty(value = "人员规模最小人数，-1 为以下")
    @TableField("scale_person_min")
    private Integer scalePersonMin;

    @ApiModelProperty(value = "人工规模最大人数，-1 为以上")
    @TableField("scale_person_max")
    private Integer scalePersonMax;

    @ApiModelProperty(value = "企业性质 多个使用-分割")
    @TableField("natures")
    private String natures;

    @ApiModelProperty(value = "企业浏览量")
    @TableField("enterprise_visit")
    private Long enterpriseVisit;

    @ApiModelProperty(value = "行业类别id，多个使用-分割")
    @TableField("indtype_ids")
    private String indtypeIds;

    @ApiModelProperty(value = "行业类别名称，多个使用-分割")
    @TableField("indtype_names")
    private String indtypeNames;

    @ApiModelProperty(value = "公司福利 使用-分割")
    @TableField("welfare")
    private String welfare;

    @ApiModelProperty(value = "公司特点 使用-分割")
    @TableField("characteristic")
    private String characteristic;

    @ApiModelProperty(value = "描述")
    @TableField("descript")
    private String descript;

    @ApiModelProperty(value = "岗位数量")
    @TableField("jobnum")
    private Long jobnum;

    @ApiModelProperty(value = "企业状态 0 待审核 1 审核失败 2 审核成功 3 再次提交")
    @TableField("audit_state")
    private Long auditState;

    @ApiModelProperty(value = "联系邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "省代码")
    @TableField("area_code")
    private String areaCode;

    @ApiModelProperty(value = "省名称")
    @TableField("area_name")
    private String areaName;

    @ApiModelProperty(value = "地质详情 比如多少栋楼多少号")
    @TableField("eaddr_detail")
    private String eaddrDetail;

    @ApiModelProperty(value = "公司经度")
    @TableField("ent_lng")
    private BigDecimal entLng;

    @ApiModelProperty(value = "公司纬度")
    @TableField("ent_lat")
    private BigDecimal entLat;

    @ApiModelProperty(value = "审核消息")
    @TableField("auditmsg")
    private String auditmsg;

    @ApiModelProperty(value = "创建时间")
    @TableField("createtime")
    private LocalDateTime createtime;

    @ApiModelProperty(value = "上一次更新时间")
    @TableField("updatetime")
    private LocalDateTime updatetime;

    @ApiModelProperty(value = "是否删除： 1没有删除 2 删除")
    @TableField("isdelete")
    private Integer isdelete;

    @ApiModelProperty(value = "是否为推荐企业或组织 1是 2不是 ")
    @TableField("isrecom")
    private Integer isrecom;

    @ApiModelProperty(value = "推荐企业显示排序")
    @TableField("recom_sort")
    private Integer recomSort;

    @ApiModelProperty(value = "是否为行业巨头或组织 1是 2不是")
    @TableField("ismagnate")
    private Integer ismagnate;

    @ApiModelProperty(value = "行业巨头显示排序")
    @TableField("magnate_sort")
    private Integer magnateSort;

    @ApiModelProperty(value = "是否为热门企业 1 是 0不是")
    @TableField("ishot_ent")
    private Integer ishotEnt;

    @ApiModelProperty(value = "热门企业或组织显示排序")
    @TableField("hot_ent_sort")
    private Integer hotEntSort;

}
