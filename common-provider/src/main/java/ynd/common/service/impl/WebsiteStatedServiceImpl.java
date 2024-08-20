package ynd.common.service.impl;

import ynd.common.pojo.param.WebsiteStatedParam;
import ynd.common.pojo.vo.WebsiteStatedInsertVo;
import ynd.common.pojo.vo.WebsiteStatedUpdateVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ynd.common.service.WebsiteStatedService;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import ynd.core.dto.DeleteDTO;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.constant.BaseConstant;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisUserService;
import ynd.common.entity.WebsiteStatedEntity;
import ynd.common.mapper.WebsiteStatedMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 站点使用协议及声明表 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-06-07
 */
@Service
public class WebsiteStatedServiceImpl extends ServiceImpl<WebsiteStatedMapper, WebsiteStatedEntity> implements WebsiteStatedService {

    @Autowired
    private WebsiteStatedMapper websiteStatedMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  用户协议网站声明新增
     *
     * @param websiteStatedInsertVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-06-07
     **/
    @Override
    public BackResult insertWebsiteStated(WebsiteStatedInsertVo websiteStatedInsertVo) throws Exception {
        WebsiteStatedEntity websiteStatedEntity = new WebsiteStatedEntity();
        BeanUtils.copyProperties(websiteStatedInsertVo, websiteStatedEntity);
        websiteStatedEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        websiteStatedEntity.setStateId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(websiteStatedEntity));
    }

    /**
     * description  用户协议网站声明删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-06-07
     **/
    @Override
    public BackResult deleteWebsiteStated(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(websiteStatedMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(websiteStatedMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  用户协议网站声明修改
     *
     * @param websiteStatedUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-06-07
     **/
    @Override
    public BackResult updateWebsiteStated(WebsiteStatedUpdateVo websiteStatedUpdateVo) throws Exception {
        WebsiteStatedEntity websiteStatedEntity = new WebsiteStatedEntity();
        BeanUtils.copyProperties(websiteStatedUpdateVo, websiteStatedEntity);
        websiteStatedEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(websiteStatedEntity));
    }

    /**
     * description 用户协议网站声明列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-06-07
     **/
    @Override
    public BackResult findWebsiteStatedPageList(QueryParameter<WebsiteStatedParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findWebsiteStatedPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.findWebsiteStatedPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据appId获取详情
     *
     * @param appId 应用id
     * @return BackVo<T>
     * @author Yang Daqiong
     * @date 2021-03-21 21:42:12
     **/
    @Override
    public BackResult findWebsiteStatedDetailByAppId(String appId) {
        WebsiteStatedEntity websiteStatedEntity = this.baseMapper.selectOne(new QueryWrapper<WebsiteStatedEntity>().lambda().eq(WebsiteStatedEntity::getAppId, appId));
        if (websiteStatedEntity != null) {
            return BackResult.success(websiteStatedEntity);
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据stateId获取详情
     *
     * @param stateId 声明id
     * @return BackVo<T>
     * @author Yang Daqiong
     * @date 2021-03-21 21:41:36
     **/
    @Override
    public BackResult findWebsiteStatedDetailByStateId(String stateId) {
        WebsiteStatedEntity websiteStatedEntity = this.baseMapper.selectOne(new QueryWrapper<WebsiteStatedEntity>().lambda().eq(WebsiteStatedEntity::getStateId, stateId));
        if (websiteStatedEntity != null) {
            return BackResult.success(websiteStatedEntity);
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }
}
