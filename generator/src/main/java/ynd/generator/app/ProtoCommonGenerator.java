package ynd.generator.app;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.*;


/**
 * description 代码自动化生成器
 *
 * @author yangdaqiong
 * @date 2020/04/15 21:53
 */
public class ProtoCommonGenerator {

    public static void main(String[] args) {

        String finalProjectPath = System.getProperty("user.dir") + "/ez-generator/code";

        // 数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder("jdbc:mysql://rm-bp18v2c3w2hi68gj5vo.mysql.rds.aliyuncs.com:3306/ez_common?tinyInt1isBit=false&useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC", "root", "Agile@2021@mysql!#").build();

        List<String> tables = new ArrayList<>();
        List<String> tablePrefix = new ArrayList<>();
        tables.add("sys_area");
        tables.add("sys_app");
        tables.add("sys_app_module");
        tablePrefix.add("sys_");
        tablePrefix.add("ez_");
        tablePrefix.add("t_");

        // 生成逻辑
        FastAutoGenerator.create(dataSourceConfig.getUrl(), dataSourceConfig.getUsername(), dataSourceConfig.getPassword())
                .globalConfig(builder -> {
                    builder
                            .author("ydq") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .disableOpenDir() //禁止打开输出目录
                            .outputDir(finalProjectPath + "/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    Map<OutputFile, String> mpas = new HashMap<>();
                    mpas.put(OutputFile.xml, finalProjectPath + "/src/main/resources/mapper");
                    builder
                            .parent("go") // 设置父包名
                            .moduleName("ysjz") // 设置父包模块名
                            .entity("model.entity") //设置entity包名
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .xml("mapper.xml")
                            .controller("controller")
                            .pathInfo(mpas);
                            //  .other("model.dto") // 设置dto包名
                            // .pathInfo(Collections.singletonMap(OutputFile.xml, finalProjectPath + "/src/main/resources/mapper")); // 设置mapperXml生成路径

                })
                .templateConfig(builder -> {
                    builder
                            .disable(); // 禁用所有模板
                            /*.entity("/templates/entity.java")
                            .service("/templates/service.java")
                            .serviceImpl("/templates/serviceImpl.java")
                            .mapper("/templates/mapper.java")
                            .controller("/templates/controller.java");*/
                })
                .strategyConfig(builder -> {
                    builder
                            .addTablePrefix(tablePrefix)
                            .addInclude(tables);

                    // 添加忽略字段
                    //  builder.entityBuilder().addIgnoreColumns("del_status","create_by","update_by","create_time","update_time");
                })
                .injectionConfig(consumer -> {
                    consumer.beforeOutputFile((tableInfo, objectMap) -> {
                        System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
                    });

                    Map<String, String> customFile = new HashMap<>();
                    customFile.put(".proto", "/templates/proto/entity.proto.ftl");
                    customFile.put(".api.go", "/templates/proto/api.go.ftl");
                    customFile.put(".service.go", "/templates/proto/service.go.ftl");

                    List<CustomFile> list = new ArrayList<CustomFile>();
                    CustomFile customFile1 = new CustomFile();
                    customFile.put(".proto", "/templates/proto/entity.proto.ftl");


                    consumer.customFile(customFile);
                    consumer.customFile(list);
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}