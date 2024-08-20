package ynd.shopping.modular.backend.pojo.vo;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 店铺分类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-08
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "店铺分类列表", description = "店铺分类管理")
public class StoreCategoryListVo {

    @ApiModelProperty(value = "店铺分类id")
    private Long storeCategoryId;

    @ApiModelProperty(value = "保证金")
    private BigDecimal bail;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "排序")
    private Integer sortBy;

    @ApiModelProperty(value = "版本号")
    private String version;

    @ApiModelProperty(value = "删除状态（false || 0：未删除，true || 1：删除）")
    private Boolean delStatus;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
