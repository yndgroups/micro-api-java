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
import ynd.cms.modular.backend.entity.ArticleEntity;
import ynd.cms.modular.backend.mapper.ArticleMapper;
import ynd.cms.modular.backend.service.ArticleService;
import ynd.cms.modular.backend.pojo.dto.ArticleInsertDTO;
import ynd.cms.modular.backend.pojo.dto.ArticleUpdateDTO;
import ynd.cms.modular.backend.pojo.param.ArticleParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 信息内容详情表服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleEntity> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  文章管理新增
     *
     *@param articleInsertDTO
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-12-10
     **/
    @Override
    public BackResult insertArticle(ArticleInsertDTO articleInsertDTO) throws Exception {
        ArticleEntity articleEntity = new ArticleEntity();
        BeanUtils.copyProperties(articleInsertDTO, articleEntity);
        articleEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        articleEntity.setArtId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(articleEntity));
    }

    /**
     * description  文章管理删除
     *
     *@param deleteDTO
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-12-10
     **/
    @Override
    public BackResult deleteArticle(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  文章管理修改
     *
     *@param articleUpdateDTO
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-12-10
     **/
    @Override
    public BackResult updateArticle(ArticleUpdateDTO articleUpdateDTO) throws Exception {
       ArticleEntity articleEntity = new ArticleEntity();
       BeanUtils.copyProperties(articleUpdateDTO, articleEntity);
       articleEntity.setUpdateBy(redisUserService.getAuthUser().getUserId());
       return BackResult.update(this.updateById(articleEntity));
    }

    /**
     * description 文章管理列表查询
     *
     *@param queryParameter
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-12-10
     **/
    @Override
    public BackResult findArticlePageList(QueryParameter<ArticleParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findArticlePageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(),queryParameter.getPageSize(), totalCount,this.baseMapper.findArticlePageList(queryParameterExtend)));
        } else {
        throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据artId查询详情
     *
     *@param artId 主键id
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-12-10
     **/
    @Override
    public BackResult findArticleDetailById(String artId) throws Exception {
        LambdaQueryWrapper<ArticleEntity> eq = new QueryWrapper<ArticleEntity>().lambda().eq(ArticleEntity::getArtId, artId);
        ArticleEntity articleEntity = this.baseMapper.selectOne(eq);
        return BackResult.success(articleEntity);
    }
}
