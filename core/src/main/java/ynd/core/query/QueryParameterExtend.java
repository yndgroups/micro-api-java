package ynd.core.query;

import ynd.core.service.RedisUserService;
import ynd.core.model.TokenParseUserAuth;
import ynd.core.utils.CommonUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * description 查询扩展类统一封装
 *
 * @author yangdaqiong
 * @date 2019-07-24 23:02
 **/
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Data
public class QueryParameterExtend extends QueryParameter {

    @Autowired
    private RedisUserService redisUserService;

    private TokenParseUserAuth auth;

    public QueryParameterExtend() {
        super();
    }

    public QueryParameterExtend(QueryParameter requestVo, TokenParseUserAuth tokenParseUserAuth) {
        super(requestVo);
        if (tokenParseUserAuth != null && tokenParseUserAuth.getAreaCode() != null && tokenParseUserAuth.getAreaCode().length() > 0 && tokenParseUserAuth.getAreaTag() != 0) {
            tokenParseUserAuth.setAreaCode(CommonUtil.substringAreaCode(tokenParseUserAuth.getAreaCode(), tokenParseUserAuth.getAreaTag()));
        }
        this.auth = tokenParseUserAuth;
    }

}
