//package com.albusxing.msa.account;
//
//import com.albusxing.msa.common.base.BaseEntity;
//import com.baomidou.mybatisplus.core.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//
///**
// * @author Albusxing
// * @created 2022/7/1
// */
//public class MpGenerator {
//
//
//    public static void main(String[] args) {
//
//        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
//        generator.strategy(strategyConfig());
//        generator.global(globalConfig().build());
//        generator.packageInfo(packageConfig().build());
//        generator.injection(injectionConfig().build());
//        generator.template(templateConfig().build());
//        generator.execute();
//    }
//
//
//    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
//            .Builder("jdbc:mysql://127.0.0.1:3306/jokeshop_account?serverTimezone=Asia/Shanghai", "root", "root")
//            .build();
//
//    /**
//     * 策略配置
//     */
//    protected static StrategyConfig strategyConfig() {
//        StrategyConfig strategyConfig = new StrategyConfig.Builder().addInclude("t_user").addTablePrefix("t_").build();
//        strategyConfig = strategyConfig.entityBuilder().superClass(BaseEntity.class).enableLombok().build();
//        strategyConfig = strategyConfig.controllerBuilder().enableRestStyle().build();
//        return strategyConfig;
//    }
//
//
//    /**
//     * 全局配置
//     */
//    protected static GlobalConfig.Builder globalConfig() {
//        return new GlobalConfig.Builder()
//                .author("Albusxing")
//                .outputDir("./msa-account/src/main/java")
//                .enableSwagger()
//                .dateType(DateType.TIME_PACK)
//                .commentDate("yyyy-MM-dd");
//    }
//
//    /**
//     * 包配置
//     */
//    protected static PackageConfig.Builder packageConfig() {
//        return new PackageConfig.Builder()
//                .parent("com.albusxing.msa.account")
//                .controller("web");
//    }
//
//    /**
//     * 模板配置
//     */
//    protected static TemplateConfig.Builder templateConfig() {
//        return new TemplateConfig.Builder();
//    }
//
//    /**
//     * 注入配置
//     */
//    protected static InjectionConfig.Builder injectionConfig() {
//        // 测试自定义输出文件之前注入操作，该操作再执行生成代码前 debug 查看
//        return new InjectionConfig.Builder().beforeOutputFile((tableInfo, objectMap) -> {
//            System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
//        });
//    }
//
//}
