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
 * 信息分类表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_category")
@ApiModel(value = "信息分类表", description = "信息分类表Model")
public class CategoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类型id的父id(默认：1是新闻，2：视频，3：图片)")
    @TableId(value = "category_id", type = IdType.ASSIGN_UUID)
    private Long categoryId;

    @ApiModelProperty(value = "类型id的父id(默认：1是新闻，2：视频，3：图片)")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "应用id")
    @TableField("app_id")
    private Long appId;

    @ApiModelProperty(value = "新闻类型名称(栏目名称不能重复)")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "类型标识")
    @TableField("mark")
    private String mark;

    @ApiModelProperty(value = "排序")
    @TableField("sort_by")
    private Integer sortBy;

    @ApiModelProperty(value = "分类描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "逻辑删除状态（1：未删除、2：已经删除）")
    @TableField("del_status")
    private Integer delStatus;

    @ApiModelProperty(value = "更新者")
    @TableField("update_by")
    private Long updateBy;

    @ApiModelProperty(value = "创建者")
    @TableField("create_by")
    private Long createBy;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private Date updateTime;


}
