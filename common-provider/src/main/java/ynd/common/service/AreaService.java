package ynd.common.service;

import ynd.common.pojo.vo.AreaListVo;
import ynd.core.dto.DeleteDTO;
import ynd.common.entity.AreaEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.common.pojo.vo.AreaInsertVo;
import ynd.common.pojo.vo.AreaUpdateVo;
import ynd.common.pojo.param.AreaParam;
import ynd.core.query.QueryParameter;
import ynd.core.result.BackResult;

import java.util.List;

/**
 * <p>
 * 2020区划代码 服务接口
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
public interface AreaService extends IService<AreaEntity> {
    /**
     * description  地区管理新增
     *
     * @param areaInsertVo 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult addArea(AreaInsertVo areaInsertVo) throws Exception;

    /**
     * description  地区管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult deleteArea(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  地区管理修改
     *
     * @param areaUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult updateArea(AreaUpdateVo areaUpdateVo) throws Exception;

    /**
     * description 地区管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult findAreaPageList(QueryParameter<AreaParam> queryParameter) throws Exception;


    /**
     * description 根据parentCode查询下级列表
     *
     * @param parentCode
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult<List<AreaListVo>> findAreaListByParentCode(String parentCode);
}
