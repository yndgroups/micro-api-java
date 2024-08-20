package ynd.common.mapper;

import java.util.List;

import ynd.common.entity.MenuEntity;
import ynd.common.pojo.vo.MenuListVo;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ynd.core.dto.DeleteDTO;

/**
 * <p>
 * 菜单表 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Mapper
public interface MenuMapper extends BaseMapper<MenuEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 根据菜单id匹配id
    *
    * @param menus 角色id列表
    * @return Integer
    * @author yangdaqiong
    * @date 2021-05-13
    **/
    List<MenuListVo> selectMenuList(List<String> menus);

    /**
     * description 根据用户id查询出当前账号的角色
     *
     * @param
     * @return
     * @author yangdaqiong
     * @date 2021-10-02 11:45:54
     **/
    List<Long> selectRoleIdsByAppId(Long appId, Long userId);

    /**
     * description 根据角色id查询出菜单授权id菜单列表
     *
     * @param
     * @return
     * @author yangdaqiong
     * @date 2021-10-02 12:15:50
     **/
    List<String> findMenuIdsByRoleIds(List<Long> roleIds);

    /**
     * description 根据appId查询全部菜单
     *
     * @param appId 应用appId
     * @return
     * @author yangdaqiong
     * @date 2021-10-02 16:19:45
     **/
    List<MenuListVo> selectMenuListAll(Long appId);
}
