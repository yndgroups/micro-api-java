package ynd.common.entity;

import ynd.core.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("sys_enum")
@ApiModel(value="EnumEntity对象", description="")
public class EnumEntity extends BaseEntity {

    @ApiModelProperty(value = "枚举id")
    @TableId(value = "enum_id", type = IdType.ASSIGN_UUID)
    private Long enumId;

    @ApiModelProperty(value = "枚举父id")
    @TableField("parent_id")
    private String parentId;

    @ApiModelProperty(value = "枚举名称")
    @TableField("en_name")
    private String enName;

    @ApiModelProperty(value = "枚举值")
    @TableField("en_val")
    private String enVal;

}
