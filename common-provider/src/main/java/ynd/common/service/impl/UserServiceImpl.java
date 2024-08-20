package ynd.common.service.impl;

import ynd.common.pojo.vo.UserRelationRoleVo;
import ynd.common.service.PayConfService;
import ynd.core.constant.BaseConstant;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.model.PayConf;
import ynd.core.model.TokenParseUserAuth;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisService;
import ynd.core.service.RedisUserService;
import ynd.core.utils.WeChatUtil;
import ynd.core.dto.DeleteDTO;
import ynd.common.mapper.UserMapper;
import ynd.common.entity.UserEntity;
import ynd.common.pojo.param.UserParam;
import ynd.common.pojo.vo.UserInsertVo;
import ynd.common.pojo.vo.UserUpdateVo;
import ynd.common.service.UserService;
import ynd.common.entity.PayConfEntity;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUserService redisUserService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private PayConfService payConfService;

    /**
     * description  用户管理新增
     *
     * @param userInsertVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult addUser(UserInsertVo userInsertVo) throws Exception {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userInsertVo, userEntity);
        userEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        userEntity.setUserId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(userEntity));
    }

    /**
     * description  用户管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult deleteUser(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(userMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(userMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  用户管理修改
     *
     * @param adminUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult updateUser(UserUpdateVo adminUpdateVo) throws Exception {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(adminUpdateVo, userEntity);
        userEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(userEntity));
    }

    /**
     * description 用户管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult findUserPageList(QueryParameter<UserParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findUserPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.findUserPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 获取微信公众号的个人信息
     *
     * @param confId 配置id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-08-29 15:39:24
     **/
    @Override
    public BackResult queryWeChatWebUserInfo(String confId) throws Exception {
        PayConf payConf = redisUserService.getPayConf(confId);
        if (payConf == null) {
            PayConfEntity payConfEntity = payConfService.getBaseMapper().selectById(confId);
            if (payConfEntity != null) {
                payConf = new PayConf();
                BeanUtils.copyProperties(payConfEntity, payConf);
                redisService.setString("conf_" + confId.trim(), JSON.toJSONString(payConfEntity), BaseConstant.wxLoginTime);
            } else {
                throw new CustomException(0, "未查询到对应的配置新信息");
            }
        }
        String key = "access_token_" + payConf.getAppSecret();
        String accessToken = redisService.getString(key);
        if (accessToken == null) {
            accessToken = WeChatUtil.getAccessToken(payConf.getAppId(), payConf.getAppSecret());
            redisService.setString(key, accessToken, BaseConstant.publicLoginTime);
        }
        // TokenParseUserAuth tokenParseUserAuth = redisUserService.getAuthUser(payConf.getFromAppId());
        TokenParseUserAuth tokenParseUserAuth = redisUserService.getAuthUser();
        return BackResult.success(WeChatUtil.getWeChatWebUserInfo(accessToken, tokenParseUserAuth.getOpenId()));
    }

    /**
     * description 查询用户授权角色id
     *
     * @param appId  应用id
     * @param userId 用户id
     * @author yangdaqiong
     * @date 2021-10-02 22:26:48
     **/
    @Override
    public BackResult<List<String>> queryRoleIds(String appId, String userId) {
        List<String> list = this.baseMapper.queryRoleIds(appId, userId);
        if (list.size() > 0) {
            return BackResult.success(list);
        } else {
            throw new CustomException(0, "未查询到该用户绑定的角色");
        }
    }

    /**
     * description 用户用户关联角色信息
     *
     * @param userRelationRoleVo 关联参数
     * @return 返回用户用户关联角色信息
     * @author yangdaqiong
     * @date 2021-10-02 23:00:56
     **/
    @Override
    public BackResult userRelation(UserRelationRoleVo userRelationRoleVo) throws Exception {
        userRelationRoleVo.setCreateBy(String.valueOf(redisUserService.getAuthUser().getUserId()));
        List<Long> s1 = this.baseMapper.selectUserRelationApp(userRelationRoleVo);
        if (s1.size() == 0) {
            this.baseMapper.userRelationApp(userRelationRoleVo);
        }
        this.baseMapper.deleteUserRelation(userRelationRoleVo);
        Integer integer = this.baseMapper.userRelation(userRelationRoleVo);
        if (integer > 0) {
            return BackResult.success("用户关联角色成功");
        } else {
            return BackResult.fail("用户关联角色失败");
        }
    }
}
