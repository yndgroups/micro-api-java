package ynd.core;

import ynd.core.jwt.JwtManage;
import org.junit.Test;

import java.util.HashMap;

public class JwtTest {

    @Test
    public void createToken() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", "ee1");
        map.put("userName", "ydq");
        map.put("age", 32);
        System.out.println("+++++++++++++++++++++");
        System.out.println(JwtManage.createToken(map));;
        System.out.println("+++++++++++++++++++++");
    }

    @Test
    public void parseToken() throws Exception {
        System.out.println("+++++++++++++++++++++");
        String token = "Bearer eyJhbGciOiJSUzUxMiJ9.eyJpc3MiOiJlZTEiLCJ1c2VyTmFtZSI6InlkcSIsImV4cCI6MTYxOTExMzEwMSwidXNlcklkIjoiZWUxIiwiaWF0IjoxNjE5MTAyMzAxLCJhZ2UiOjMyfQ.DziwpcgT3t2UYGQTTojNfwYs9wq8I3mHM5CGNAeuNou8gWuDKTXW2B58b3ukV8seqlG01xlc31i-4mAHY1un-nUHaw7zERSftqngzdaJswH0MpUqMOc2pt6IbOdRP1kpNkt9GjhJ_6rUY5yhkOri5BE9qr80awBIlf2OGWX639E";
        System.out.println("+++++++++++++++++++++");
        System.out.println(JwtManage.parseToken(token));
    }

    @Test
    public void createKeyPairs() {
        System.out.println(JwtManage.createKeyPairs(1));
        System.out.println("+++++++++++++++++++++");
        System.out.println(JwtManage.createKeyPairs(2));
    }

}
