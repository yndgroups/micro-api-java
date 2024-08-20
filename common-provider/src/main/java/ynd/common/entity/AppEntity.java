package ynd.common.entity;

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
 * 应用表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_app")
@ApiModel(value="AppEntity对象", description="应用表")
public class AppEntity extends BaseEntity {

    @ApiModelProperty(value = "应用主键id")
    @TableId(value = "app_id")
    private Long appId;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty(value = "模块组id")
    @TableField("md_id")
    private String mdId;

    @ApiModelProperty(value = "介绍")
    @TableField("introduce")
    private String introduce;

    @ApiModelProperty(value = "排序")
    @TableField("sort_by")
    private Integer sortBy;

    @ApiModelProperty(value = "启用状态（1:启用 2：已禁用）")
    @TableField("enable_status")
    private Integer enableStatus;

}
