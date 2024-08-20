package ynd.common.service.impl;

import ynd.core.dto.DeleteDTO;
import ynd.core.service.RedisService;
import ynd.common.mapper.RoleAndMenuMapper;
import ynd.common.entity.RoleAndMenuEntity;
import ynd.common.pojo.vo.RoleAndMenuVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ynd.common.service.PowerService;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import ynd.common.entity.PowerEntity;
import ynd.common.mapper.PowerMapper;
import ynd.common.pojo.vo.PowerInsertVo;
import ynd.common.pojo.vo.PowerUpdateVo;
import ynd.common.pojo.param.PowerParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.constant.BaseConstant;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisUserService;

import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Service
public class PowerServiceImpl extends ServiceImpl<PowerMapper, PowerEntity> implements PowerService {

    @Autowired
    private RedisUserService redisUserService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private PowerMapper powerMapper;

    @Autowired
    private RoleAndMenuMapper roleAndMenuMapper;

    /**
     * description  权限管理新增
     *
     * @param powerInsertVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult addPower(PowerInsertVo powerInsertVo) throws Exception {
        PowerEntity powerEntity = new PowerEntity();
        BeanUtils.copyProperties(powerInsertVo, powerEntity);
        powerEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        powerEntity.setPowerId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(powerEntity));
    }

    /**
     * description  权限管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult deletePower(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(powerMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(powerMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  权限管理修改
     *
     * @param powerUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult updatePower(PowerUpdateVo powerUpdateVo) throws Exception {
        PowerEntity powerEntity = new PowerEntity();
        BeanUtils.copyProperties(powerUpdateVo, powerEntity);
        powerEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(powerEntity));
    }

    /**
     * description 权限管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult findPowerPageList(QueryParameter<PowerParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findPowerPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.findPowerPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 绑定角色和菜单
     *
     * @param roleAndMenuVos 角色和菜单关联Vo
     * @return ynd.core.result.BackResult
     * @author yangdaqiong
     * @date 2021-06-01 22:44:44
     **/
    @Override
    public BackResult bindRoleAndMenus(List<RoleAndMenuVo> roleAndMenuVos) throws Exception {
        if (roleAndMenuVos.size() > 0) {
            String redisKey = "roleId_" + roleAndMenuVos.get(0).getRoleId();
            redisService.delete(redisKey);
            Integer integer = 0;
            LambdaQueryWrapper<RoleAndMenuEntity> query = new QueryWrapper<RoleAndMenuEntity>().lambda()
                    .eq(RoleAndMenuEntity::getRoleId, roleAndMenuVos.get(0).getRoleId())
                    .eq(RoleAndMenuEntity::getAppId, roleAndMenuVos.get(0).getAppId());
            Integer integer1 = roleAndMenuMapper.delete(query);
            if (integer1 != null) {
                System.out.println("删除" + integer1 + "条数数据");
            }
            // 插入授权数据
            for (RoleAndMenuVo roleAndMenuVo : roleAndMenuVos) {
                RoleAndMenuEntity menuRelationRoleEntity = new RoleAndMenuEntity();
                BeanUtils.copyProperties(roleAndMenuVo, menuRelationRoleEntity);
                menuRelationRoleEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
                integer += roleAndMenuMapper.insert(menuRelationRoleEntity);
            }
            return new BackResult("授权" + integer + "条数据", ResponseEnum.AUTH_SUCCESS);
        } else {
            throw new CustomException(0, "不能传空值");
        }
    }
}
