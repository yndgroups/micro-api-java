package ynd.common.service;

import ynd.common.pojo.vo.UserRelationRoleVo;
import ynd.common.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.common.pojo.vo.UserInsertVo;
import ynd.common.pojo.vo.UserUpdateVo;
import ynd.common.pojo.param.UserParam;
import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;

import java.util.List;

/**
 * <p>
 * 系统用户 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
public interface UserService extends IService<UserEntity> {

    /**
     * description  用户管理新增
     *
     * @param userInsertVo 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult addUser(UserInsertVo userInsertVo) throws Exception;

    /**
     * description  用户管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult deleteUser(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  用户管理修改
     *
     * @param adminUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult updateUser(UserUpdateVo adminUpdateVo) throws Exception;

    /**
     * description 用户管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult findUserPageList(QueryParameter<UserParam> queryParameter) throws Exception;

    /**
     * description 获取用户登陆的微信公众号个人信息
     *
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-08-29 14:36:35
     **/
    BackResult queryWeChatWebUserInfo(String confId) throws Exception;

    /**
     * description 根据用户id和应用id查询授权角色
     *
     * @param appId  应用id
     * @param userId 用户id
     * @return 返回查询
     * @author yangdaqiong
     * @date 2021-10-02 22:22:15
     **/
    BackResult<List<String>> queryRoleIds(String appId, String userId);

    /**
     * description 用户关联角色
     *
     * @param userRelationRoleVo 应用id
     * @return 返回查询
     * @author yangdaqiong
     * @date 2021-10-02 22:55:43
     **/
    BackResult userRelation(UserRelationRoleVo userRelationRoleVo) throws Exception;
}
