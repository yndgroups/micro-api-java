package ynd.common.pojo.param;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
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
@Accessors(chain = true)
@ApiModel(value="友情搜索条件", description="友情链接表")
public class FriendlyLinksParam {

    @ApiModelProperty(value = "网站名称")
    private String name;

    @ApiModelProperty(value = "网站连接地址")
    private String linkUrl;

    @ApiModelProperty(value = "显示类型 ( 1:显示文字  2:显示logo )")
    private Integer showType;

    @ApiModelProperty(value = "网站描述")
    private String description;

    @ApiModelProperty(value = "站长Email")
    private String email;

    @ApiModelProperty(value = "状态 ( 1:审核通过, 2:审核未通过, 3:待审核 )")
    private Integer auditStatus;

    @ApiModelProperty(value = "链接生效时间")
    private LocalDate startTime;

    @ApiModelProperty(value = "链接结束时间")
    private LocalDate endTime;

}
