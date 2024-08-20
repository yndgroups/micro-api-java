
package ynd.order.service;

import ynd.order.pojo.dao.PayAccount;
import ynd.order.pojo.dao.ApyAccountRepository;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author egan
 * email egzosn@gmail.com
 * date 2016/11/18 1:11
 */
@Service
public class ApyAccountService {

//    @Resource
    private ApyAccountRepository dao;

    @Resource
    private AutowireCapableBeanFactory spring;

    /**
     * 缓存
     */
    private final static Map<Integer, PayResponse> payResponses = new HashMap<Integer, PayResponse>();

    /**
     * 这里简单初始化，引入orm等框架之后可自行删除
     */
    {

        dao = new ApyAccountRepository();
    }


    /**
     *  获取支付响应
     * @param id 账户id
     * @return 支付响应
     */
    public PayResponse getPayResponse(Integer id) {

        PayResponse payResponse = payResponses.get(id);
        if (payResponse  == null) {
            PayAccount payAccountEntity = dao.findByPayId(id);
            if (payAccountEntity == null) {
                throw new IllegalArgumentException ("无法查询");
            }
            payResponse = new PayResponse();
            spring.autowireBean(payResponse);
            payResponse.init(payAccountEntity);
            payResponses.put(id, payResponse);
            // 查询
        }
        return payResponse;
    }


}
