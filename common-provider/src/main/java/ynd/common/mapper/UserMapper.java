package ynd.common.mapper;

import java.util.List;

import ynd.common.pojo.vo.UserRelationRoleVo;
import ynd.core.dto.DeleteDTO;
import ynd.common.entity.UserEntity;
import ynd.common.pojo.vo.UserListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 系统用户 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

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
    * description 系统用户分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-05-13
    **/
    List<UserListVo> findUserPageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 系统用户分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-05-13
    **/
    Integer findUserPageListCount(QueryParameterExtend queryParameterExtend);

    /**
     * description 查询用户授权角色id
     *
     * @param appId 应用id
     * @param userId 用户id
     * @return 返回角色列表
     * @author yangdaqiong
     * @date 2021-10-02 22:29:37
     **/
    List<String> queryRoleIds(String appId, String userId);

    /**
     * description
     *
     * @param userRelationRoleVo 应用id
     * @return 返回用户关联角色信息
     * @author yangdaqiong
     * @date 2021-10-02 23:05:28
     **/
    Integer userRelation(UserRelationRoleVo userRelationRoleVo);

    /**
     * description 删除用户关联的角色信息
     *
     * @param
     * @return
     * @author yangdaqiong
     * @date 2021-10-02 23:45:35
     **/
    Integer deleteUserRelation(UserRelationRoleVo userRelationRoleVo);

    /**
     * description 关联应用
     *
     * @param userRelationRoleVo
     * @return Integer
     * @author yangdaqiong
     * @date 2021-10-03 01:50:32
     **/
    Integer userRelationApp(UserRelationRoleVo userRelationRoleVo);

    /**
     * description 查询关联应用
     *
     * @param userRelationRoleVo
     * @return Integer
     * @author yangdaqiong
     * @date 2021-10-03 01:50:19
     **/
    List<Long> selectUserRelationApp(UserRelationRoleVo userRelationRoleVo);
}
