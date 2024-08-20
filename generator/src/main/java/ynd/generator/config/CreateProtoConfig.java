package ynd.generator.config;

public class CreateProtoConfig {

    private String prefix;
    private String moduleName;
    private String basePackage;
    private String swaggerApiTitle;

    private Boolean createProto;


    public Boolean getCreateProto() {
        return createProto;
    }

    public void setCreateProto(Boolean createProto) {
        this.createProto = createProto;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getSwaggerApiTitle() {
        return swaggerApiTitle;
    }

    public void setSwaggerApiTitle(String swaggerApiTitle) {
        this.swaggerApiTitle = swaggerApiTitle;
    }
}
