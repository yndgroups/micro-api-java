package ynd.common.service.impl;

import ynd.common.pojo.vo.DictListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import ynd.common.entity.DictEntity;
import ynd.common.mapper.DictMapper;
import ynd.common.service.DictService;
import ynd.common.pojo.vo.DictInsertVo;
import ynd.common.pojo.vo.DictUpdateVo;
import ynd.common.pojo.param.DictParam;
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

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * <p>
 * 上传资源分类表 服务实现类
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, DictEntity> implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Autowired
    private RedisUserService redisUserService;

    /**
     * description  字典管理新增
     *
     * @param dictInsertVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult addDict(DictInsertVo dictInsertVo) throws Exception {
        DictEntity dictEntity = new DictEntity();
        BeanUtils.copyProperties(dictInsertVo, dictEntity);
        dictEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        dictEntity.setDictId(redisUserService.createPrimaryKey());
        return BackResult.insert(this.save(dictEntity));
    }

    /**
     * description  字典管理删除
     *
     * @param deleteDTO
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult deleteDict(DeleteDTO deleteDTO) throws Exception {
        if (BaseConstant.deleteType == 1) {
            deleteDTO.setUpdateBy(redisUserService.getAuthUser().getUserId());
            return BackResult.delete(dictMapper.logicalDelete(deleteDTO));
        } else {
            return BackResult.delete(dictMapper.deleteBatchIds(deleteDTO.getIds()));
        }
    }

    /**
     * description  字典管理修改
     *
     * @param dictUpdateVo
     * @return BackVO
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult updateDict(DictUpdateVo dictUpdateVo) throws Exception {
        DictEntity dictEntity = new DictEntity();
        BeanUtils.copyProperties(dictUpdateVo, dictEntity);
        dictEntity.setCreateBy(redisUserService.getAuthUser().getUserId());
        return BackResult.update(this.updateById(dictEntity));
    }

    /**
     * description 字典管理列表查询
     *
     * @param queryParameter
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-05-13
     **/
    @Override
    public BackResult findDictPageList(QueryParameter<DictParam> queryParameter) throws Exception {
        QueryParameterExtend queryParameterExtend = new QueryParameterExtend(queryParameter, redisUserService.getAuthUser());
        Integer totalCount = this.baseMapper.findDictPageListCount(queryParameterExtend);
        if (totalCount > 0) {
            return BackResult.success(new Pager(queryParameter.getPageIndex(), queryParameter.getPageSize(), totalCount, this.baseMapper.findDictPageList(queryParameterExtend)));
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }

    /**
     * description 根据父亲id获取字典树状列表
     *
     * @param parentId 父id
     * @return ynd.core.result.BackResult
     * @author yangdaqiong
     * @date 2021-07-17 16:16:12
     **/
    @Override
    public BackResult findDictTreeByParentId(String parentId) throws Exception {
        List<DictListVo> dictEntityList = this.baseMapper.queryDictTreeByParentId(parentId);
        if (dictEntityList.size() > 0) {
            List<DictListVo> parentList = dictEntityList.stream().filter(it -> it.getParentId().equals(parentId)).collect(Collectors.toList());
            if (parentList.size() > 0) {
                List<DictListVo> childList = dictEntityList.stream().filter(it -> !it.getParentId().equals(parentId)).collect(Collectors.toList());
                Map<String, List<DictListVo>> mapList = childList.stream().collect(Collectors.groupingBy(it -> it.getParentId()));
                parentList.stream().forEach(it -> {
                    List<DictListVo> list = mapList.get(it.getDictId());
                    if (list != null && list.size() > 0) {
                        it.setChildren(list);
                    }
                });
                return BackResult.success(parentList);
            } else {
                throw new CustomException(ResponseEnum.REQ_NOT_DATA);
            }
        } else {
            throw new CustomException(ResponseEnum.REQ_NOT_DATA);
        }
    }
}
