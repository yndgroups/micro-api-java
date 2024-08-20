package ynd.shopping.modular.backend.pojo.param;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 店铺查询参数
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-07
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "店铺查询条件", description = "店铺管理")
public class StoreParam {

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "已付保证金")
    private BigDecimal bailPaid;

    @ApiModelProperty(value = "E-mail")
    private String email;

    @ApiModelProperty(value = "简介")
    private String introduction;

    @ApiModelProperty(value = "是否启用(1:启用（默认） 2：禁用)")
    private Boolean enabled;

    @ApiModelProperty(value = "搜索关键词")
    private String keyword;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "类型")
    private Integer type;

    @ApiModelProperty(value = "店铺管理人员")
    private String storeUsers;

    @ApiModelProperty(value = "门店编码")
    private String storeNo;

}
