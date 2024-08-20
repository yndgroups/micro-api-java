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
 * 上传资源分类表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_dict")
@ApiModel(value="字典实体", description="字典管理")
public class DictEntity extends BaseEntity {

    @ApiModelProperty(value = "字典id")
    @TableId(value = "dict_id")
    private Long dictId;

    @ApiModelProperty(value = "父id")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "字典解释/说明")
    @TableField("explain")
    private String explain;

    @ApiModelProperty(value = "排序")
    @TableField("sort_by")
    private Integer sortBy;

}
