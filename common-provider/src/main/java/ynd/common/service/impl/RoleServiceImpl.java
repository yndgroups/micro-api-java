package ynd.common.service.impl;

import ynd.common.pojo.vo.RoleMenuInsert;
import ynd.common.service.RoleMenuService;
import ynd.common.entity.RoleMenuEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ynd.common.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import ynd.common.entity.RoleEntity;
import ynd.common.mapper.RoleMapper;
import ynd.common.pojo.vo.RoleInsertVo;
import ynd.common.pojo.vo.RoleUpdateVo;
import ynd.common.pojo.param.RoleParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ynd.core.dto.DeleteDTO;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.constant.BaseConstant;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisUserService;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

    @Autowired
    private RedisUserService redisUserService;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * description  角色管理新增
     *
     * @param roleInsertVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult insertRole(RoleInsertVo roleInsertVo) throws Exception {
        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(roleInsertVo, roleEntity);
        roleEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        roleEntity.setRoleId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(roleEntity));
    }

    /**
     * description  角色管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult deleteRole(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(roleMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(roleMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  角色管理修改
     *
     * @param roleUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult updateRole(RoleUpdateVo roleUpdateVo) throws Exception {
        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(roleUpdateVo, roleEntity);
        roleEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(roleEntity));
    }

    /**
     * description 角色管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult findRolePageList(QueryParameter<RoleParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findRolePageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.findRolePageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 角色关联菜单
     *
     * @param roleMenuInsert 角色关联菜单
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-09-27 21:32:02
     **/
    @Override
    public BackResult roleRelationMenu(RoleMenuInsert roleMenuInsert) throws Exception {
        roleMenuService.remove(new QueryWrapper<RoleMenuEntity>().lambda().eq(RoleMenuEntity::getRoleId, roleMenuInsert.getRoleId()));
        List list = new ArrayList<RoleMenuEntity>();
        roleMenuInsert.getMenuIds().forEach(it -> {
            RoleMenuEntity roleMenuEntity = new RoleMenuEntity();
            roleMenuEntity.setMenuId(it);
            roleMenuEntity.setRoleId(roleMenuInsert.getRoleId());
            try {
                roleMenuEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            list.add(roleMenuEntity);
        });
        boolean b = roleMenuService.saveBatch(list);
        if (b) {
            return BackResult.success("授权成功");
        } else {
            return BackResult.fail("授权成功");
        }
    }
}
