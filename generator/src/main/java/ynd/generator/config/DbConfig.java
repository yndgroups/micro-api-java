package ynd.generator.config;


/**
 * 数据库配置
 */
public class DbConfig {
    public String jdbcUrl;
    public String jdbcDiverClassName;
    public String jdbcUserName;
    public String jdbcPassword;

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcDiverClassName() {
        return jdbcDiverClassName;
    }

    public void setJdbcDiverClassName(String jdbcDiverClassName) {
        this.jdbcDiverClassName = jdbcDiverClassName;
    }

    public String getJdbcUserName() {
        return jdbcUserName;
    }

    public void setJdbcUserName(String jdbcUserName) {
        this.jdbcUserName = jdbcUserName;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }
}
