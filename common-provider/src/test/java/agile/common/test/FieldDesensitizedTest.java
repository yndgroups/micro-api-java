package agile.common.test;

import ynd.core.utils.FiledDesensitizedUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FieldDesensitizedTest {

    @Test
    public void test() {
        User user = new User();
        user.setIdCard("522426198904117136");
        user.setPhone("15085999726");
        user.setUserName("杨大琼");
        System.out.println(FiledDesensitizedUtils.getJSONObject(user));

        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        List<User> list = new ArrayList<>();
        list.add(user);
        User user1 = new User();
        user1.setIdCard("522426198965425636");
        user1.setPhone("15085888726");
        user1.setUserName("詹仙");
        list.add(user1);
        System.out.println(FiledDesensitizedUtils.getJSONArray(list));
    }
}
