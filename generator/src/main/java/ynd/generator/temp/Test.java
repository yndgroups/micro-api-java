package ynd.generator.temp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        // 字符串下划线转换
        /*String str = "ASSET_TYPE_CODE";
        String s = underline1Camel(str);
        System.out.println(s);*/

        // traverseFolder1();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>> underline1Camel");
        System.out.println(underline1Camel("coupon_product_category_relation"));;

    }

    private static String underline1Camel(String str){
        str = str.toLowerCase();
        final StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile("_(\\w)");
        Matcher m = p.matcher(str);
        while (m.find()) {
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }
        StringBuffer stringBuffer = m.appendTail(sb);
        return stringBuffer.substring(0, 1).toUpperCase() + stringBuffer.substring(1);
    }

    public static void traverseFolder1( ) {
        String path = System.getProperty("user.dir") + "/src/test/resources/templates/custom";
        System.out.println(path);
        int fileNum = 0;
        int folderNum = 0;
        List<List<HashMap<String,String>>> customList = new ArrayList<>();
        File file = new File(path);
        if (file.exists()) {
            LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            for (File file2 : files) {
                List<HashMap<String,String>> list1 = new ArrayList<>();
                if (file2.isDirectory()) {
                    System.out.println("文件夹F-2:" + file2.getName());
                    list.add(file2);
                    for (File file3: file2.listFiles()) {
                        HashMap<String, String> map = new HashMap<>();
                        if (file3.isDirectory()) {//如果是个目录(文件夹)则返回true
                            System.err.println("文件夹-F3:" + file2.getAbsolutePath());
                            folderNum ++;
                        } else {//输出文件
                            // System.out.println("文件-F3:" + file3.getAbsolutePath());//返回文件的完整路径。
                            map.put("folder", file2.getName());
                            map.put("folder", file3.getName());
                            fileNum ++;
                        }
                        list1.add(map);
                    }
                    folderNum ++;
                    customList.add(list1);
                } else {
                    fileNum ++;
                    System.out.println("文件-F2:" + file2.getName());
                }
            }
            System.out.println(customList);
        } else {
            System.out.println("文件不存在!");
        }
        System.out.println("文件夹共有:" + folderNum + ",文件共有:" + fileNum);
    }
}
