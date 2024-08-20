package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

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
@ApiModel(value="友情链接表", description="友情链接表")
public class FriendlyLinksListVo {

    @ApiModelProperty(value = "链接主键id")
    private String linkId;

    @ApiModelProperty(value = "网站名称")
    private String name;

    @ApiModelProperty(value = "网站连接地址")
    private String linkUrl;

    @ApiModelProperty(value = "显示类型 ( 1:显示文字  2:显示logo )")
    private Integer showType;

    @ApiModelProperty(value = "排序")
    private Integer sortBy;

    @ApiModelProperty(value = "网站Logo")
    private String logo;

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

    @ApiModelProperty(value = "删除状态")
    private Integer delStatus;

}
