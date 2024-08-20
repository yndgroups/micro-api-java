package ynd.common.service;

import ynd.common.pojo.vo.RoleMenuInsert;
import ynd.core.dto.DeleteDTO;
import ynd.common.entity.RoleEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.common.pojo.vo.RoleInsertVo;
import ynd.common.pojo.vo.RoleUpdateVo;
import ynd.common.pojo.param.RoleParam;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;

/**
 * <p>
 * 角色表 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
public interface RoleService extends IService<RoleEntity> {

    /**
     * description  角色管理新增
     *
     * @param roleInsertVo 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult insertRole(RoleInsertVo roleInsertVo) throws Exception;

    /**
     * description  角色管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult deleteRole(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  角色管理修改
     *
     * @param roleUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult updateRole(RoleUpdateVo roleUpdateVo) throws Exception;

    /**
     * description 角色管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult findRolePageList(QueryParameter<RoleParam> queryParameter) throws Exception;

    /**
     * description 角色关联菜单
     *
     * @param roleMenuInsert
     * @return 返回
     * @author yangdaqiong
     * @date 2021-09-27 21:15:03
     **/
    BackResult roleRelationMenu(RoleMenuInsert roleMenuInsert) throws Exception;
}
