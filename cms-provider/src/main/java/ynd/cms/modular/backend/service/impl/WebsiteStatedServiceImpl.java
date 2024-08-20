package ynd.cms.modular.backend.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ynd.core.dto.DeleteDTO;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.constant.BaseConstant;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisUserService;
import ynd.cms.modular.backend.entity.WebsiteStatedEntity;
import ynd.cms.modular.backend.mapper.WebsiteStatedMapper;
import ynd.cms.modular.backend.service.WebsiteStatedService;
import ynd.cms.modular.backend.pojo.dto.WebsiteStatedInsertDTO;
import ynd.cms.modular.backend.pojo.dto.WebsiteStatedUpdateDTO;
import ynd.cms.modular.backend.pojo.param.WebsiteStatedParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 站点使用协议及声明表服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-15
 */
@Service
public class WebsiteStatedServiceImpl extends ServiceImpl<WebsiteStatedMapper, WebsiteStatedEntity> implements WebsiteStatedService {

    @Autowired
    private WebsiteStatedMapper websiteStatedMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  站长声明管理新增
     *
     *@param websiteStatedInsertDTO
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-12-15
     **/
    @Override
    public BackResult insertWebsiteStated(WebsiteStatedInsertDTO websiteStatedInsertDTO) throws Exception {
        WebsiteStatedEntity websiteStatedEntity = new WebsiteStatedEntity();
        BeanUtils.copyProperties(websiteStatedInsertDTO, websiteStatedEntity);
        websiteStatedEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        websiteStatedEntity.setStateId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(websiteStatedEntity));
    }

    /**
     * description  站长声明管理删除
     *
     *@param deleteDTO
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-12-15
     **/
    @Override
    public BackResult deleteWebsiteStated(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  站长声明管理修改
     *
     *@param websiteStatedUpdateDTO
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-12-15
     **/
    @Override
    public BackResult updateWebsiteStated(WebsiteStatedUpdateDTO websiteStatedUpdateDTO) throws Exception {
       WebsiteStatedEntity websiteStatedEntity = new WebsiteStatedEntity();
       BeanUtils.copyProperties(websiteStatedUpdateDTO, websiteStatedEntity);
       websiteStatedEntity.setUpdateBy(redisUserService.getAuthUser().getUserId());
       return BackResult.update(this.updateById(websiteStatedEntity));
    }

    /**
     * description 站长声明管理列表查询
     *
     *@param queryParameter
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-12-15
     **/
    @Override
    public BackResult findWebsiteStatedPageList(QueryParameter<WebsiteStatedParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findWebsiteStatedPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(),queryParameter.getPageSize(), totalCount,this.baseMapper.findWebsiteStatedPageList(queryParameterExtend)));
        } else {
        throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据stateId查询详情
     *
     *@param stateId 主键id
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-12-15
     **/
    @Override
    public BackResult findWebsiteStatedDetailById(String stateId) throws Exception {
        LambdaQueryWrapper<WebsiteStatedEntity> eq = new QueryWrapper<WebsiteStatedEntity>().lambda().eq(WebsiteStatedEntity::getStateId, stateId);
        WebsiteStatedEntity websiteStatedEntity = this.baseMapper.selectOne(eq);
        return BackResult.success(websiteStatedEntity);
    }
}
