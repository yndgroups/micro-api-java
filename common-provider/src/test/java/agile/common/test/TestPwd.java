package agile.common.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestPwd {

    @Test
    public void showPwd(){
        System.out.println(DigestUtils.sha512Hex("Hzbcw@2021"));
    }
}
