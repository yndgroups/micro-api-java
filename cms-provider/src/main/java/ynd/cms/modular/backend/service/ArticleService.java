package ynd.cms.modular.backend.service;

import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;
import ynd.cms.modular.backend.entity.ArticleEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.cms.modular.backend.pojo.dto.ArticleInsertDTO;
import ynd.cms.modular.backend.pojo.dto.ArticleUpdateDTO;
import ynd.cms.modular.backend.pojo.param.ArticleParam;

/**
 * <p>
 * 信息内容详情表服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
public interface ArticleService extends IService<ArticleEntity> {

    /**
     * description  文章管理新增
     *
     *@param articleInsertDTO 新增参数
     *@return BackVO
     *@author yangdaqiong
     *@date 2021-12-10
     **/
    BackResult insertArticle(ArticleInsertDTO articleInsertDTO) throws Exception;

    /**
     * description  文章管理删除
     *
     *@param deleteDTO 删除参数
     *@return BackResult
     *@author yangdaqiong
     *@date 2021-12-10
     **/
    BackResult deleteArticle(DeleteDTO deleteDTO) throws Exception;

    /**
      * description  文章管理修改
      *
      *@param articleUpdateDTO
      *@return BackResult 返回修改结果
      *@author yangdaqiong
      *@date 2021-12-10
      **/
    BackResult updateArticle(ArticleUpdateDTO articleUpdateDTO) throws Exception;

    /**
     * description 文章管理列表查询
     *
     *@param queryParameter
     *@return BackResult 返回查询结果
     *@author yangdaqiong
     *@date 2021-12-10
     **/
    BackResult findArticlePageList(QueryParameter<ArticleParam> queryParameter) throws Exception;

    /**
     * description 根据主键id详情查询
     *
     * @param artId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-12-10
     */
    BackResult findArticleDetailById(String artId) throws Exception;
}
