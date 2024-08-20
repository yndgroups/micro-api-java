package ynd.common.service.impl;

import ynd.core.dto.DeleteDTO;
import ynd.common.entity.PayConfEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import ynd.common.mapper.PayConfMapper;
import ynd.common.service.PayConfService;
import ynd.common.pojo.vo.PayConfInsertVo;
import ynd.common.pojo.vo.PayConfUpdateVo;
import ynd.common.pojo.param.PayConfParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class PayConfServiceImpl extends ServiceImpl<PayConfMapper, PayConfEntity> implements PayConfService {

    @Autowired
    private PayConfMapper payConfMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  支付管理新增
     *
     * @param payConfInsertVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult addPayConf(PayConfInsertVo payConfInsertVo) throws Exception {
        PayConfEntity payConfEntity = new PayConfEntity();
        BeanUtils.copyProperties(payConfInsertVo, payConfEntity);
        payConfEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        payConfEntity.setConfId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(payConfEntity));
    }

    /**
     * description  支付管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult deletePayConf(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(payConfMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(payConfMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  支付管理修改
     *
     * @param payConfUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult updatePayConf(PayConfUpdateVo payConfUpdateVo) throws Exception {
        PayConfEntity payConfEntity = new PayConfEntity();
        BeanUtils.copyProperties(payConfUpdateVo, payConfEntity);
        payConfEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(payConfEntity));
    }

    /**
     * description 支付管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult findPayConfPageList(QueryParameter<PayConfParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findPayConfPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.findPayConfPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }
}
