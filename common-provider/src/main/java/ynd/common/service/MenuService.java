package ynd.common.service;

import ynd.core.dto.DeleteDTO;
import ynd.common.entity.MenuEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.common.pojo.vo.MenuInsertVo;
import ynd.common.pojo.vo.MenuUpdateVo;
import ynd.core.result.BackResult;

import java.util.List;

/**
 * <p>
 * 菜单表 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
public interface MenuService extends IService<MenuEntity> {

    /**
     * description  菜单管理新增
     *
     * @param menuInsertVo 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult addMenu(MenuInsertVo menuInsertVo) throws Exception;

    /**
     * description  菜单管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult deleteMenu(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  菜单管理修改
     *
     * @param menuUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult updateMenu(MenuUpdateVo menuUpdateVo) throws Exception;

    /**
     * description 根据appId查询菜单列表
     *
     * @param appId 应用id
     * @return ynd.core.result.BackResult
     * @author yangdaqiong
     * @date 2021-06-01 21:37:18
     **/
    BackResult findMenuListByAppId(Long appId) throws Exception;

    /**
     * description 根据角色id返回菜单id列表
     *
     * @param roleId 角色id
     * @return 返回菜单id列表
     * @author yangdaqiong
     * @date 2021-10-02 17:33:28
     **/
    BackResult<List<String>> findMenuIdsByRoleIds(Long roleId);
}
