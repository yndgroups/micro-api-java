package ynd.common.service;

import ynd.core.dto.DeleteDTO;
import ynd.common.entity.DictEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.common.pojo.vo.DictInsertVo;
import ynd.common.pojo.vo.DictUpdateVo;
import ynd.common.pojo.param.DictParam;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;

/**
 * <p>
 * 上传资源分类表 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
public interface DictService extends IService<DictEntity> {
    /**
     * description  字典管理新增
     *
     * @param dictInsertVo 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult addDict(DictInsertVo dictInsertVo) throws Exception;

    /**
     * description  字典管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult deleteDict(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  字典管理修改
     *
     * @param dictUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult updateDict(DictUpdateVo dictUpdateVo) throws Exception;

    /**
     * description 字典管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult findDictPageList(QueryParameter<DictParam> queryParameter) throws Exception;

    /**
     * description 字典树状列表查询
     *
     * @param parentId 字典父亲id
     * @return ynd.core.result.BackResult
     * @author yangdaqiong
     * @date 2021-07-17 15:59:58
     **/
    BackResult findDictTreeByParentId(String parentId) throws Exception;
}
