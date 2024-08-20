package ynd.shopping.modular.backend.service.impl;

import ynd.core.dto.DeleteDTO;
import ynd.shopping.modular.backend.mapper.CartMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.constant.BaseConstant;
import ynd.core.query.QueryParameter;
import ynd.core.query.QueryParameterExtend;
import ynd.core.result.BackResult;
import ynd.core.result.Pager;
import ynd.core.service.RedisUserService;
import ynd.shopping.modular.backend.entity.CartEntity;
import ynd.shopping.modular.backend.service.CartService;
import ynd.shopping.modular.backend.pojo.dto.CartInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.CartUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.CartParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 购物车 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-04
 */
@Service("AdminCartServiceImpl")
public class CartServiceImpl extends ServiceImpl<CartMapper, CartEntity> implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  购物车管理新增
     *
     * @param cartInsertDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    @Override
    public BackResult insertCart(CartInsertDTO cartInsertDTO) throws Exception {
        CartEntity cartEntity = new CartEntity();
        BeanUtils.copyProperties(cartInsertDTO, cartEntity);
        cartEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        cartEntity.setCartId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(cartEntity));
    }

    /**
     * description  购物车管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    @Override
    public BackResult deleteCart(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  购物车管理修改
     *
     * @param cartUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    @Override
    public BackResult updateCart(CartUpdateDTO cartUpdateVo) throws Exception {
        CartEntity cartEntity = new CartEntity();
        BeanUtils.copyProperties(cartUpdateVo, cartEntity);
        cartEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(cartEntity));
    }

    /**
     * description 购物车管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    @Override
    public BackResult queryCartPageList(QueryParameter<CartParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.queryCartPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.queryCartPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据cartId查询详情
     *
     * @param cartId 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    @Override
    public BackResult queryCartEntityDetailById(String cartId) throws Exception {
        LambdaQueryWrapper<CartEntity> eq = new QueryWrapper<CartEntity>().lambda().eq(CartEntity::getCartId, cartId);
        CartEntity cartEntity = this.baseMapper.selectOne(eq);
        return BackResult.success(cartEntity);
    }
}
