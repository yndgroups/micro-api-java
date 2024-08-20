package ynd.core.utils;

import ynd.core.exception.CustomException;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * description  公共验证类
 *
 * @author yangdaqiong
 * @date 2020-06-19 10:25:36
 **/
public class ValidateUtil {

    /**
     * description 判断是否为空(为空)
     *
     * @param str
     * @return boolean
     * @author yangdaqiong
     * @date 2019-12-27 13:48
     **/
    public static boolean isEmpty(final String str) {
        return (str == null) || (str.length() == 0) || ("null".equals(str));
    }

    /**
     * description 判断是否不为空（不为空）
     *
     * @param str
     * @return boolean
     * @author yangdaqiong
     * @date 2019-12-27 13:48
     **/
    public static boolean isNotEmpty(final String str) {
        return !isEmpty(str);
    }

    /**
     * description 验证请求参数，主要是解决请求时字段安全问题
     *
     * @param jsonObject
     * @return BackVO
     * @author yangdaqiong
     * @date 2020-01-05 17:54
     **/
    public static JSONObject validatedGetParams(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        Set<String> set = jsonObject.keySet();
        for (String key : set) {
            Object value = jsonObject.get(key);
            if (value instanceof JSONArray) {
                //数组
                continue;
            } else if (value instanceof JSONObject) {
                // 对象
                if (jsonObject.getJSONObject(key).size() == 0) {
                    throw new CustomException(0, "不能一次性请求全部数据,请按需传入");
                } else {
                    validatedGetParams(jsonObject.getJSONObject(key));
                }
            }
        }
        return jsonObject;
    }

    public static boolean validateFiled(String filed, String errMsg) {
        if (isEmpty(filed)) {
            throw new CustomException(0, errMsg);
        } else {
            return true;
        }
    }

}
