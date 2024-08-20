package ynd.common.service;

import ynd.common.entity.PowerEntity;
import ynd.common.pojo.vo.RoleAndMenuVo;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.common.pojo.vo.PowerInsertVo;
import ynd.common.pojo.vo.PowerUpdateVo;
import ynd.common.pojo.param.PowerParam;
import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;

import java.util.List;

/**
 * <p>
 * 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
public interface PowerService extends IService<PowerEntity> {

    /**
     * description  权限管理新增
     *
     * @param powerInsertVo 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult addPower(PowerInsertVo powerInsertVo) throws Exception;

    /**
     * description  权限管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult deletePower(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  权限管理修改
     *
     * @param powerUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult updatePower(PowerUpdateVo powerUpdateVo) throws Exception;

    /**
     * description 权限管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult findPowerPageList(QueryParameter<PowerParam> queryParameter) throws Exception;

    /**
     * description 绑定角色和菜单
     *
     * @param roleAndMenuVos 角色和菜单关联Vo
     * @return ynd.core.result.BackResult
     * @author yangdaqiong
     * @date 2021-06-01 22:43:31
     **/
    BackResult bindRoleAndMenus(List<RoleAndMenuVo> roleAndMenuVos) throws Exception;
}
