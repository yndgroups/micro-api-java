package ynd.common.entity;

import ynd.core.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 友情链接表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_friendly_links")
@ApiModel(value="FriendlyLinksEntity对象", description="友情链接表")
public class FriendlyLinksEntity extends BaseEntity {

    @ApiModelProperty(value = "链接主键id")
    @TableId(value = "link_id", type = IdType.ASSIGN_UUID)
    private String linkId;

    @ApiModelProperty(value = "网站名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "网站连接地址")
    @TableField("link_url")
    private String linkUrl;

    @ApiModelProperty(value = "显示类型 ( 1:显示文字  2:显示logo )")
    @TableField("show_type")
    private Integer showType;

    @ApiModelProperty(value = "排序")
    @TableField("sort_by")
    private Integer sortBy;

    @ApiModelProperty(value = "网站Logo")
    @TableField("logo")
    private String logo;

    @ApiModelProperty(value = "网站描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "站长Email")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "状态 ( 1:审核通过, 2:审核未通过, 3:待审核 )")
    @TableField("audit_status")
    private Integer auditStatus;

    @ApiModelProperty(value = "链接生效时间")
    @TableField("start_time")
    private LocalDate startTime;

    @ApiModelProperty(value = "链接结束时间")
    @TableField("end_time")
    private LocalDate endTime;

}
