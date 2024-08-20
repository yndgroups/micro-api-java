package ynd.common.mapper;

import ynd.common.entity.RoleMenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * description 角色关联菜单
 *
 * @author yangdaqiong
 * @date 2021-09-27 21:02:32
 **/
@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenuEntity> { }
