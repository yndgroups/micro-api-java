package ynd.common.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

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
@ApiModel(value="应用模块列表", description="应用模块管理")
public class AppModuleListVo {

    @ApiModelProperty(value = "模块id")
    private Long mdId;

    @ApiModelProperty(value = "模块名称")
    private String name;

    @ApiModelProperty(value = "主机地址")
    private String host;

    @ApiModelProperty(value = "路由前缀匹配")
    private String matchPath;

    @ApiModelProperty(value = "js静态资源地址")
    private String jsPath;

    @ApiModelProperty(value = "css静态资源地址")
    private String cssPath;

    @ApiModelProperty(value = "删除状态(1||true:正常，0||false:删除）")
    private Boolean delStatus;

    @ApiModelProperty(value = "创建者")
    private Long createBy;

    @ApiModelProperty(value = "更新者")
    private Long updateBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
