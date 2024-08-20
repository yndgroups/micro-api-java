package ynd.common.service;

import ynd.common.entity.EnumEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.common.pojo.vo.EnumInsertVo;
import ynd.common.pojo.vo.EnumUpdateVo;
import ynd.common.pojo.param.EnumParam;
import ynd.core.dto.DeleteDTO;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;

/**
 * <p>
 * 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
public interface EnumService extends IService<EnumEntity> {
    /**
     * description  枚举管理新增
     *
     * @param enumInsertVo 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult addEnum(EnumInsertVo enumInsertVo) throws Exception;

    /**
     * description  枚举管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult deleteEnum(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  枚举管理修改
     *
     * @param enumUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult updateEnum(EnumUpdateVo enumUpdateVo) throws Exception;

    /**
     * description 枚举管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult findEnumPageList(QueryParameter<EnumParam> queryParameter) throws Exception;
}
