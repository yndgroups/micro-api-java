package ynd.common.service.impl;

import ynd.common.service.EnumService;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import ynd.common.entity.EnumEntity;
import ynd.common.mapper.EnumMapper;
import ynd.common.pojo.vo.EnumInsertVo;
import ynd.common.pojo.vo.EnumUpdateVo;
import ynd.common.pojo.param.EnumParam;
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
 * 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Service
public class EnumServiceImpl extends ServiceImpl<EnumMapper, EnumEntity> implements EnumService {

    @Autowired
    private EnumMapper enumMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  枚举管理新增
     *
     * @param enumInsertVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult addEnum(EnumInsertVo enumInsertVo) throws Exception {
        EnumEntity enumEntity = new EnumEntity();
        BeanUtils.copyProperties(enumInsertVo, enumEntity);
        enumEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        enumEntity.setEnumId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(enumEntity));
    }

    /**
     * description  枚举管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult deleteEnum(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(enumMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(enumMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  枚举管理修改
     *
     * @param enumUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult updateEnum(EnumUpdateVo enumUpdateVo) throws Exception {
        EnumEntity enumEntity = new EnumEntity();
        BeanUtils.copyProperties(enumUpdateVo, enumEntity);
        enumEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(enumEntity));
    }

    /**
     * description 枚举管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult findEnumPageList(QueryParameter<EnumParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findEnumPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.findEnumPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }
}
