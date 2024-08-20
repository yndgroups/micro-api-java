package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 友情链接表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Accessors(chain = true)
@ApiModel(value="友情链接修改", description="友情链接管理")
public class FriendlyLinksUpdateVo  extends FriendlyLinksInsertVo{

    @ApiModelProperty(value = "链接主键id", required = true)
    @NotNull(message = "链接id不能为空")
    private Long linkId;

}
