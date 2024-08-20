package ynd.common.service;

import ynd.core.dto.DeleteDTO;
import ynd.common.entity.PayConfEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ynd.common.pojo.vo.PayConfInsertVo;
import ynd.common.pojo.vo.PayConfUpdateVo;
import ynd.common.pojo.param.PayConfParam;
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
public interface PayConfService extends IService<PayConfEntity> {

    /**
     * description  支付管理新增
     *
     * @param payConfInsertVo 新增参数
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult addPayConf(PayConfInsertVo payConfInsertVo) throws Exception;

    /**
     * description  支付管理删除
     *
     * @param deleteDTO 删除参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult deletePayConf(DeleteDTO deleteDTO) throws Exception;

    /**
     * description  支付管理修改
     *
     * @param payConfUpdateVo
     * @return BackResult 返回修改结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult updatePayConf(PayConfUpdateVo payConfUpdateVo) throws Exception;

    /**
     * description 支付管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    BackResult findPayConfPageList(QueryParameter<PayConfParam> queryParameter) throws Exception;
}
