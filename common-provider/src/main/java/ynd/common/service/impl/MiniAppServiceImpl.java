package ynd.common.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import ynd.common.entity.MiniAppEntity;
import ynd.common.mapper.MiniAppMapper;
import ynd.common.service.MiniAppService;
import ynd.common.pojo.vo.MiniAppInsertVo;
import ynd.common.pojo.vo.MiniAppUpdateVo;
import ynd.common.pojo.param.MiniAppParam;
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


/**
 * <p>
 * 微应用 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Service
public class MiniAppServiceImpl extends ServiceImpl<MiniAppMapper, MiniAppEntity> implements MiniAppService {

    @Autowired
    private MiniAppMapper miniAppMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  小程序管理新增
     *
     * @param miniAppInsertVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult addMiniApp(MiniAppInsertVo miniAppInsertVo) throws Exception {
        MiniAppEntity miniAppEntity = new MiniAppEntity();
        BeanUtils.copyProperties(miniAppInsertVo, miniAppEntity);
        miniAppEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        miniAppEntity.setAppId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(miniAppEntity));
    }

    /**
     * description  小程序管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult deleteMiniApp(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(miniAppMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(miniAppMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  小程序管理修改
     *
     * @param miniAppUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult updateMiniApp(MiniAppUpdateVo miniAppUpdateVo) throws Exception {
        MiniAppEntity miniAppEntity = new MiniAppEntity();
        BeanUtils.copyProperties(miniAppUpdateVo, miniAppEntity);
        miniAppEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(miniAppEntity));
    }

    /**
     * description 小程序管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult findMiniAppPageList(QueryParameter<MiniAppParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findMiniAppPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.findMiniAppPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }
}
