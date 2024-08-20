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
 * 站点使用协议及声明表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_website_stated")
@ApiModel(value="WebsiteStatedEntity对象", description="站点使用协议及声明表")
public class WebsiteStatedEntity extends BaseEntity {

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

}
