package ynd.cms.modular.backend.mapper;

import java.util.List;

import ynd.cms.modular.backend.entity.ArticleEntity;
import ynd.cms.modular.backend.pojo.vo.ArticleListVo;
import org.apache.ibatis.annotations.Mapper;
import ynd.core.query.QueryParameterExtend;
import ynd.core.dto.DeleteDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 信息内容详情表 Mapper 数据库操作接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-10
 */
@Mapper
public interface ArticleMapper extends BaseMapper<ArticleEntity> {

    /**
     * description 逻辑删除
     *
     * @param deleteDTO 删除数据参数
     * @return Integer
     * @author yangdaqiong
     * @date 2021-12-10
     **/
    Integer logicalDelete(DeleteDTO deleteDTO);

    /**
    * description 信息内容详情表分页列表查询
    *
    * @param queryParameterExtend 查询条件
    * @return List<ArticleListVo>
    * @author yangdaqiong
    * @date 2021-12-10
    **/
    List<ArticleListVo> findArticlePageList(QueryParameterExtend queryParameterExtend);

    /**
    * description 信息内容详情表分页列表总数查询
    *
    * @param queryParameterExtend 查询条件
    * @return Integer
    * @author yangdaqiong
    * @date 2021-12-10
    **/
    Integer findArticlePageListCount(QueryParameterExtend queryParameterExtend);
}
