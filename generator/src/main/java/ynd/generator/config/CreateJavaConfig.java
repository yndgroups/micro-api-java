package ynd.generator.config;

public class CreateJavaConfig {

    private String prefix;
    private String moduleName;
    private String basePackage;
    private String swaggerApiTitle;
    private Boolean createMapperXml;
    private Boolean isCreateProperties;
    private Boolean createCustomJava;
    private Boolean createController;
    private Boolean createEntity;

    private Boolean createPojo;

    private Boolean createProto;
    private Boolean createServiceAndImpl;
    private Boolean createMapper;

    public Boolean getCreatePojo() {
        return createPojo;
    }

    public void setCreatePojo(Boolean createPojo) {
        this.createPojo = createPojo;
    }

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

    public Boolean getCreateMapperXml() {
        return createMapperXml;
    }

    public void setCreateMapperXml(Boolean createMapperXml) {
        this.createMapperXml = createMapperXml;
    }

    public Boolean getCreateProperties() {
        return isCreateProperties;
    }

    public void setCreateProperties(Boolean createProperties) {
        isCreateProperties = createProperties;
    }

    public Boolean getCreateCustomJava() {
        return createCustomJava;
    }

    public void setCreateCustomJava(Boolean createCustomJava) {
        this.createCustomJava = createCustomJava;
    }

    public Boolean getCreateController() {
        return createController;
    }

    public void setCreateController(Boolean createController) {
        this.createController = createController;
    }

    public Boolean getCreateEntity() {
        return createEntity;
    }

    public void setCreateEntity(Boolean createEntity) {
        this.createEntity = createEntity;
    }

    public Boolean getCreateServiceAndImpl() {
        return createServiceAndImpl;
    }

    public void setCreateServiceAndImpl(Boolean createServiceAndImpl) {
        this.createServiceAndImpl = createServiceAndImpl;
    }

    public Boolean getCreateMapper() {
        return createMapper;
    }

    public void setCreateMapper(Boolean createMapper) {
        this.createMapper = createMapper;
    }
}
