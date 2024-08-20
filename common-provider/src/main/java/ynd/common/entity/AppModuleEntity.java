package ynd.common.entity;

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
 * 应用模块
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_app_module")
@ApiModel(value = "应用模块", description = "应用模块Model")
public class AppModuleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "模块id")
    @TableId(value = "md_id", type = IdType.ASSIGN_UUID)
    private Long mdId;

    @ApiModelProperty(value = "模块名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "主机地址")
    @TableField("host")
    private String host;

    @ApiModelProperty(value = "路由前缀匹配")
    @TableField("match_path")
    private String matchPath;

    @ApiModelProperty(value = "js静态资源地址")
    @TableField("js_path")
    private String jsPath;

    @ApiModelProperty(value = "css静态资源地址")
    @TableField("css_path")
    private String cssPath;

    @ApiModelProperty(value = "删除状态(1||true:正常，0||false:删除）")
    @TableField("del_status")
    private Boolean delStatus;

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
