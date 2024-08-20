package ynd.generator.config;

/**
 * description 输出配置
 *
 * @author yangdaqiong
 * @date 2021-09-25 17:39:15
 **/
public class OutConfig {

    private String projectName;
    private String projectPath;
    private String templateFilePath;
    private String outResourcesPath;
    private String outJavaPath;
    private String outMapperXmlPath;
    private boolean isCover;

    public OutConfig () {
    }

    public OutConfig (String projectName) {
        this.projectPath = System.getProperty("user.dir");
        this.templateFilePath = "/templates/";
        this.outJavaPath = projectPath + "/" + projectName + "/src/main/java";
        this.outResourcesPath = projectPath + "/" + projectName + "/src/main/resources/";
        this.outMapperXmlPath = outResourcesPath + "mybatis/mapper/";
        this.isCover = false;
    }

    public OutConfig (String projectName, boolean isCover) {
        this.projectPath = System.getProperty("user.dir");
        this.templateFilePath = "/templates/";
        this.outJavaPath = projectPath + "/" + projectName + "/src/main/java";
        this.outResourcesPath = projectPath + "/" + projectName + "/src/main/resources/";
        this.outMapperXmlPath = outResourcesPath + "mybatis/mapper/";
        this.isCover = isCover;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getTemplateFilePath() {
        return templateFilePath;
    }

    public void setTemplateFilePath(String templateFilePath) {
        this.templateFilePath = templateFilePath;
    }

    public String getOutResourcesPath() {
        return outResourcesPath;
    }

    public void setOutResourcesPath(String outResourcesPath) {
        this.outResourcesPath = outResourcesPath;
    }

    public String getOutJavaPath() {
        return outJavaPath;
    }

    public void setOutJavaPath(String outJavaPath) {
        this.outJavaPath = outJavaPath;
    }

    public String getOutMapperXmlPath() {
        return outMapperXmlPath;
    }

    public void setOutMapperXmlPath(String outMapperXmlPath) {
        this.outMapperXmlPath = outMapperXmlPath;
    }

    public boolean isCover() {
        return isCover;
    }

    public void setCover(boolean cover) {
        isCover = cover;
    }
}
