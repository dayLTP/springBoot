package com.day.Config;

import org.junit.Test;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
 
/**
 * <p>
 * 自动生成代码
 * </p>
 */
public class GenteratorCode {
    @Test
    public void generateCode() {
        String packageName = "com.day";
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
        generateByTables(serviceNameStartWithI, packageName,"user");
    }
 
    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
    	String projectPath = System.getProperty("user.dir");
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&serverTimezone=UTC&useSSL=false" ;
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("day@123")
                .setDriverName("com.mysql.cj.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(true) // 【实体】是否为lombok模型（默认 false)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setAuthor("hlt")
                .setOutputDir(projectPath+ "/src/main/java")
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("Controller")
                                .setEntity("Entity")
                ).execute();
    }
 
    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }
}