package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration;

/**
  * description  日志打印类
  *
  *@param
  *@return
  *@author yangdaqiong
  *@date 2020/06/19 10:24:55
  **/
public class Logger {

    public static boolean DEBUG = true;

    public Logger() {
    }

    public static void d(String tag, String msg) {
        if (DEBUG) {
            System.err.println(tag + ".DEBUG: " + msg);
        }
    }

    public static void v(String tag, String msg) {
        if (DEBUG) {
            System.out.println(tag + ".VERBOSE: " + msg);
        }
    }

    public static void i(String tag, String msg) {
        if (DEBUG) {
            System.out.println(tag + ".INFO: " + msg);
        }
    }

    public static void e(String tag, String msg) {
        if (DEBUG) {
            System.err.println(tag + ".ERROR: " + msg);
        }

    }

    public static void w(String tag, String msg) {
        if (DEBUG) {
            System.err.println(tag + ".WARN: " + msg);
        }
    }
}