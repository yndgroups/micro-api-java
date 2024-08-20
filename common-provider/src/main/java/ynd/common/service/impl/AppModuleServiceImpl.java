package ynd.common.service.impl;

import ynd.common.pojo.param.AppModuleParam;
import ynd.common.pojo.vo.AppModuleInsertVo;
import ynd.common.pojo.vo.AppModuleListVo;
import ynd.common.pojo.vo.AppModuleUpdateVo;
import ynd.core.dto.DeleteDTO;
import ynd.common.service.AppModuleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.constant.BaseConstant;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisUserService;
import ynd.common.entity.AppModuleEntity;
import ynd.common.mapper.AppModuleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * <p>
 * 应用模块 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-10-30
 */
@Service
public class AppModuleServiceImpl extends ServiceImpl<AppModuleMapper, AppModuleEntity> implements AppModuleService {

    @Autowired
    private AppModuleMapper appModuleMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  应用模块管理新增
     *
     * @param appModuleInsertVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-10-30
     **/
    @Override
    public BackResult insertAppModule(AppModuleInsertVo appModuleInsertVo) throws Exception {
        AppModuleEntity appModuleEntity = new AppModuleEntity();
        BeanUtils.copyProperties(appModuleInsertVo, appModuleEntity);
        appModuleEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        appModuleEntity.setMdId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(appModuleEntity));
    }

    /**
     * description  应用模块管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-10-30
     **/
    @Override
    public BackResult deleteAppModule(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  应用模块管理修改
     *
     * @param appModuleUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-10-30
     **/
    @Override
    public BackResult updateAppModule(AppModuleUpdateVo appModuleUpdateVo) throws Exception {
        AppModuleEntity appModuleEntity = new AppModuleEntity();
        BeanUtils.copyProperties(appModuleUpdateVo, appModuleEntity);
        appModuleEntity.setUpdateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(appModuleEntity));
    }

    /**
     * description 应用模块管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-10-30
     **/
    @Override
    public BackResult findAppModulePageList(QueryParameter<AppModuleParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findAppModulePageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.findAppModulePageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据mdId查询详情
     *
     * @param mdId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-10-30
     **/
    @Override
    public BackResult findAppModuleDetailById(String mdId) throws Exception {
        LambdaQueryWrapper<AppModuleEntity> eq = new QueryWrapper<AppModuleEntity>().lambda().eq(AppModuleEntity::getMdId, mdId);
        AppModuleEntity appModuleEntity = this.baseMapper.selectOne(eq);
        return BackResult.success(appModuleEntity);
    }

    /**
     * description 根据appId查询模块列表
     *
     * @param appId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-10-30
     **/
    @Override
    public BackResult findAppModuleListByAppId(String appId) {
        List<AppModuleListVo> appModuleListVo = this.baseMapper.findAppModuleListByAppId(appId);
        return BackResult.success(appModuleListVo);
    }
}
