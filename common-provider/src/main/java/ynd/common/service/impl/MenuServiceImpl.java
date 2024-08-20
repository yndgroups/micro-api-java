package ynd.common.service.impl;

import ynd.common.mapper.MenuMapper;
import ynd.common.mapper.RoleMapper;
import ynd.common.pojo.vo.MenuInsertVo;
import ynd.common.pojo.vo.MenuListVo;
import ynd.common.pojo.vo.MenuUpdateVo;
import ynd.common.service.MenuService;
import ynd.core.constant.BaseConstant;
import ynd.core.exception.CustomException;
import ynd.core.result.BackResult;
import ynd.core.service.RedisService;
import ynd.core.service.RedisUserService;
import ynd.core.dto.DeleteDTO;
import ynd.common.entity.MenuEntity;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RedisUserService redisUserService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private RoleMapper roleMapper;

    /**
     * description  菜单管理新增
     *
     * @param menuInsertVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult addMenu(MenuInsertVo menuInsertVo) throws Exception {
        MenuEntity menuEntity = new MenuEntity();
        BeanUtils.copyProperties(menuInsertVo, menuEntity);
        menuEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        menuEntity.setMenuId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(menuEntity));
    }

    /**
     * description  菜单管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult deleteMenu(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(menuMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(menuMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  菜单管理修改
     *
     * @param menuUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult updateMenu(MenuUpdateVo menuUpdateVo) throws Exception {
        MenuEntity menuEntity = new MenuEntity();
        BeanUtils.copyProperties(menuUpdateVo, menuEntity);
        menuEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(menuEntity));
    }

    /**
     * description 根据appId查询菜单列表
     *
     * @param appId 应用ids
     * @return ynd.core.result.BackResult
     * @author yangdaqiong
     * @date 2021-06-01 21:39:26
     **/
    @Override
    public BackResult findMenuListByAppId(Long appId) throws Exception {
        // 根据appId角色查询出角色
        String storeRoleIds = "ms_";
        List<String> powerSigns = new ArrayList<>();
        List<MenuListVo> menuEntities;
        List<String> menuIds = new ArrayList<>();
        if (redisUserService.getAuthUser().getUserId().longValue() == BaseConstant.administrator.longValue()) {
            // 运维角色管理员查询全部菜单
            menuEntities = this.menuMapper.selectMenuListAll(appId);
            for (MenuListVo menuListVo : menuEntities) {
                menuIds.add(menuListVo.getMenuId());
                if (menuListVo.getPowerSign() != null && !"".equals(menuListVo.getPowerSign())) {
                    powerSigns.add(menuListVo.getPowerSign());
                }
            }
        } else {
            // 非运维角色，其他类型的管理员
            List<Long> roleIds = this.baseMapper.selectRoleIdsByAppId(appId, redisUserService.getAuthUser().getUserId());
            if (roleIds.size() == 0) {
                throw new CustomException(0, "未查询到您在该应用下的角色权限");
            } else {
                for (Long ids : roleIds) {
                    storeRoleIds += String.valueOf(ids);
                }
            }
            menuIds = this.baseMapper.findMenuIdsByRoleIds(roleIds);
            if (menuIds.size() == 0) {
                throw new CustomException(0, "未查询到您菜单权限");
            }
            // 根据菜单权限列表查询菜单列表
            menuEntities = this.baseMapper.selectMenuList(menuIds);
            if (menuEntities.size() == 0) {
                throw new CustomException(0, "没有查询到菜单相关信息");
            }
            for (MenuListVo menuListVo : menuEntities) {
                if (menuListVo.getPowerSign() != null && !"".equals(menuListVo.getPowerSign())) {
                    powerSigns.add(menuListVo.getPowerSign());
                }
            }
        }
        Map<String, Object> result = new HashMap<>();
        result.put("menuList", menusTree(menuEntities));
        result.put("powerSign", powerSigns);
        result.put("menuIds", menuIds);
        // 判断是否有缓存
        // redisService.setString(storeRoleIds, JSONObject.toJSONString(result), Constant.publicLoginTime);
        return BackResult.success(result);
    }

    /**
     * description 根据角色id查询菜单id列表
     *
     * @param roleId 角色id
     * @return 返回菜单id列表
     * @author yangdaqiong
     * @date 2021-10-02 17:41:10
     **/
    @Override
    public BackResult<List<String>> findMenuIdsByRoleIds(Long roleId) {
        List<Long> longs = new ArrayList<Long>();
        longs.add(roleId);
        List<String> strings = this.baseMapper.findMenuIdsByRoleIds(longs);
        if (strings.size() > 0) {
            return BackResult.success(strings);
        } else {
            throw new CustomException(0, "未查询到角色对于的菜单信息");
        }
    }

    /**
     * description 处理菜单列表的树形关系
     *
     * @param menuEntities
     * @return java.util.List<ynd.dao.common.backend.entity.MenuEntity>
     * @author yangdaqiong
     * @date 2021-06-05 08:19:24
     **/
    private List<MenuListVo> menusTree(List<MenuListVo> menuEntities) {
        List<MenuListVo> parentList = menuEntities.stream().filter(it -> it.getParentId().equals("1")).collect(Collectors.toList());
        List<MenuListVo> childList = menuEntities.stream().filter(it -> !it.getParentId().equals("1")).collect(Collectors.toList());
        Map<String, List<MenuListVo>> groupMenu = childList.stream().collect(Collectors.groupingBy(it -> it.getParentId()));
        parentList.stream().forEach(it -> {
            List<MenuListVo> child = groupMenu.get(it.getMenuId());
            if (child != null) {
                it.setChildren(childTree(child, groupMenu));
            }
        });
        return parentList;
    }

    /**
     * description 递归找出子菜单
     *
     * @param menuListVos 子菜单
     * @return groupMenu 分组子菜单
     * @author yangdaqiong
     * @date 2021-09-27 01:30:14
     **/
    private List<MenuListVo> childTree(List<MenuListVo> menuListVos, Map<String, List<MenuListVo>> groupMenu) {
        List<MenuListVo> list = new ArrayList<>();
        menuListVos.stream().forEach(it -> {
            List<MenuListVo> child = groupMenu.get(it.getMenuId());
            if (child != null) {
                it.setChildren(childTree(child, groupMenu));
            }
        });
        return menuListVos;
    }
}
