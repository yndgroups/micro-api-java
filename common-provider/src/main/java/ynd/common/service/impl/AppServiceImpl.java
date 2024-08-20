package ynd.common.service.impl;

import ynd.common.mapper.AppMapper;
import ynd.common.pojo.param.AppParam;
import ynd.common.pojo.vo.AppInsertVo;
import ynd.common.pojo.vo.AppUpdateVo;
import ynd.common.service.AppService;
import ynd.core.constant.BaseConstant;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisUserService;
import ynd.core.dto.DeleteDTO;
import ynd.common.entity.AppEntity;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 应用表 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Service
public class AppServiceImpl extends ServiceImpl<AppMapper, AppEntity> implements AppService {

    @Autowired
    private AppMapper appMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  应用管理新增
     *
     * @param appInsertVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult addApp(AppInsertVo appInsertVo) throws Exception {
        AppEntity appEntity = new AppEntity();
        BeanUtils.copyProperties(appInsertVo, appEntity);
        appEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        appEntity.setAppId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(appEntity));
    }

    /**
     * description  应用管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult deleteApp(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            if (redisUserService.getAuthUser().getUserId() != null) {
                deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
                return BackResult.delete(appMapper.logicalDelete(deleteDTO));
            } else {
                throw new CustomException(0, "为获取到用户ip");
            }
        } else {
            return BackResult.delete(appMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  应用管理修改
     *
     * @param appUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult updateApp(AppUpdateVo appUpdateVo) throws Exception {
        AppEntity appEntity = new AppEntity();
        BeanUtils.copyProperties(appUpdateVo, appEntity);
        appEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(appEntity));
    }

    /**
     * description 应用管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult findPageList(QueryParameter<AppParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.findPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 查询应一下的权限
     *
     * @author yangdaqiong
     * @date 2021-09-26 21:13:58
     **/
    @Override
    public BackResult findAppListByUserId() throws Exception {
        if (redisUserService.getAuthUser().getUserId().longValue() == BaseConstant.administrator.longValue()) {
            return BackResult.success(this.baseMapper.findAllAppListByUserId());
        } else {
            return BackResult.success(this.baseMapper.findAppListByUserId(redisUserService.getAuthUser().getUserId()));
        }
    }
}
