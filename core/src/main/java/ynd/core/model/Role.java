package ynd.core.model;

import lombok.Data;

/**
 * description 角色实体
 *
 * @author yangdaqiong
 * @date 2019-11-16 17:39
 **/
@Data
public class Role {

    /* 角色Id */
    private String roleId;

    /* 应用id */
    private String appId;

    /* 角色名称 */
    private String name;

    /* 角色标签 */
    private String remark;

    /* 排序 */
    private Integer sort;

    /* 角色等级 */
    private Integer roleLv;

    /* 创建者 */
    private String createBy;

    /* 更新者 */
    private String updateBy;

    /* 删除状态 */
    private Integer delStatus;

    /* 创建时间 */
    private String createTime;

    /* 更新时间 */
    private String updateTime;
}
