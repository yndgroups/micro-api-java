package ynd.core;

import ynd.core.utils.FiledDesensitizedUtils;
import org.junit.Test;

public class FieldDesensitizedTest {

    @Test
    public void test() {
        User user = new User();
        user.setIdCard("522426198904117136");
        user.setPhone("15085999726");
        user.setUserName("杨大琼");
        System.out.println(FiledDesensitizedUtils.getJSONObject(user));
    }
}
