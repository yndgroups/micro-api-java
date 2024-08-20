package ynd.shopping.modular.backend.service.impl;

import ynd.core.dto.DeleteDTO;
import ynd.shopping.modular.backend.mapper.CartItemMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
import ynd.shopping.modular.backend.entity.CartItemEntity;
import ynd.shopping.modular.backend.service.CartItemService;
import ynd.shopping.modular.backend.pojo.dto.CartItemInsertDTO;
import ynd.shopping.modular.backend.pojo.dto.CartItemUpdateDTO;
import ynd.shopping.modular.backend.pojo.param.CartItemParam;

/**
 * <p>
 * 购物车项 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-04
 */
@Service("AdminCartItemServiceImpl")
public class CartItemServiceImpl extends ServiceImpl<CartItemMapper, CartItemEntity> implements CartItemService {

    @Autowired
    private CartItemMapper cartItemMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  购物车项管理新增
     *
     * @param cartItemInsertDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    @Override
    public BackResult insertCartItem(CartItemInsertDTO cartItemInsertDTO) throws Exception {
        CartItemEntity cartItemEntity = new CartItemEntity();
        BeanUtils.copyProperties(cartItemInsertDTO, cartItemEntity);
        cartItemEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        cartItemEntity.setCtId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(cartItemEntity));
    }

    /**
     * description  购物车项管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    @Override
    public BackResult deleteCartItem(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(this.baseMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(this.baseMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  购物车项管理修改
     *
     * @param cartItemUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    @Override
    public BackResult updateCartItem(CartItemUpdateDTO cartItemUpdateVo) throws Exception {
        CartItemEntity cartItemEntity = new CartItemEntity();
        BeanUtils.copyProperties(cartItemUpdateVo, cartItemEntity);
        cartItemEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(cartItemEntity));
    }

    /**
     * description 购物车项管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    @Override
    public BackResult queryCartItemPageList(QueryParameter<CartItemParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.queryCartItemPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.queryCartItemPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据id查询详情
     *
     * @param id 主键id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-09-04
     **/
    @Override
    public BackResult queryCartItemEntityDetailById(String id) throws Exception {
        LambdaQueryWrapper<CartItemEntity> eq = new QueryWrapper<CartItemEntity>().lambda().eq(CartItemEntity::getCtId, id);
        CartItemEntity cartItemEntity = this.baseMapper.selectOne(eq);
        return BackResult.success(cartItemEntity);
    }
}
