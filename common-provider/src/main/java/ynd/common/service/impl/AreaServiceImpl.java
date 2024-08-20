package ynd.common.service.impl;

import ynd.common.pojo.vo.AreaListVo;
import ynd.core.dto.DeleteDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import ynd.common.entity.AreaEntity;
import ynd.common.mapper.AreaMapper;
import ynd.common.service.AreaService;
import ynd.common.pojo.vo.AreaInsertVo;
import ynd.common.pojo.vo.AreaUpdateVo;
import ynd.common.pojo.param.AreaParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.constant.BaseConstant;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisUserService;

import java.util.List;


/**
 * <p>
 * 2020区划代码 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, AreaEntity> implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  地区管理新增
     *
     * @param areaInsertVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult addArea(AreaInsertVo areaInsertVo) throws Exception {
        AreaEntity areaEntity = new AreaEntity();
        BeanUtils.copyProperties(areaInsertVo, areaEntity);
        areaEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.insert(this.save(areaEntity));
    }

    /**
     * description  地区管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult deleteArea(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(areaMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(areaMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  地区管理修改
     *
     * @param areaUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult updateArea(AreaUpdateVo areaUpdateVo) throws Exception {
        AreaEntity areaEntity = new AreaEntity();
        BeanUtils.copyProperties(areaUpdateVo, areaEntity);
        areaEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(areaEntity));
    }

    /**
     * description 地区管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult findAreaPageList(QueryParameter<AreaParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findAreaPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.findAreaPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据地区父级编码查询下一级地区
     *
     * @param parentCode
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult<List<AreaListVo>> findAreaListByParentCode(String parentCode) {
        if ("1".equals(parentCode)) {
            parentCode = "000000000000";
        }
        List<AreaListVo> listVos = this.baseMapper.findAreaListByParentCode(parentCode);
        if (listVos.size() > 0) {
            return BackResult.success(listVos);
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }
}
