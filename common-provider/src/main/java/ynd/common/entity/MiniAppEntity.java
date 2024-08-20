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
 * 微应用
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_mini_app")
@ApiModel(value="MiniAppEntity对象", description="微应用")
public class MiniAppEntity extends BaseEntity {

    @ApiModelProperty(value = "小程序id")
    @TableId(value = "app_id", type = IdType.ASSIGN_UUID)
    private Long appId;

    @ApiModelProperty(value = "小程序发布的服务器地址")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "小程序名称")
    @TableField("titie")
    private String titie;

    @ApiModelProperty(value = "小程序介绍")
    @TableField("describle")
    private String describle;

}
