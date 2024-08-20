package ynd.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {

    @ApiModelProperty(value = "删除状态(0:未删除，1:删除，默认是:0）")
    public Boolean delStatus;

    @ApiModelProperty(value = "创建者")
    public Long createBy;

    @ApiModelProperty(value = "更新者")
    public Long updateBy;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    public Date createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    public Date updateTime;

}
