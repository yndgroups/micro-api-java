package ynd.cms.modular.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 站点使用协议及声明表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_website_stated")
@ApiModel(value = "站点使用协议及声明表", description = "站点使用协议及声明表Model")
public class WebsiteStatedEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "声明主键id")
    @TableId(value = "state_id", type = IdType.ASSIGN_UUID)
    private Long stateId;

    @ApiModelProperty(value = "属于某个应用的声明（关联appId）")
    @TableField("app_id")
    private Long appId;

    @ApiModelProperty(value = "类型（1：网站声明永远只有一条， 2：其他相关内容比如操作手册）")
    @TableField("state_type")
    private Integer stateType;

    @ApiModelProperty(value = "声明标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "声明内容")
    @TableField("cms")
    private String content;

    @ApiModelProperty(value = "删除状态（0：未删除 1：已删除, 默认为：0）")
    @TableField("del_status")
    private Integer delStatus;

    @ApiModelProperty(value = "创建者")
    @TableField("create_by")
    private Long createBy;

    @ApiModelProperty(value = "更新者")
    @TableField("update_by")
    private Long updateBy;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private Date updateTime;


}
