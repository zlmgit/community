package com.zlm.community.util;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Describe : 代码自动生成配置
 * @author zhuluming
 */
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    private static String scanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入表名：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + "表名" + "！");
    }

    public static void main(String[] args) {
        do {
            // 代码生成器
            AutoGenerator mpg = new AutoGenerator();
            // 全局配置
            GlobalConfig gc = new GlobalConfig();
            final String projectPath = System.getProperty("user.dir");
            gc.setOutputDir(projectPath + "/src/main/java");
            gc.setAuthor("zhuluming");
            gc.setOpen(false);
            mpg.setGlobalConfig(gc);

            // 数据源配置
            DataSourceConfig dsc =null;
            dsc=new DataSourceConfig();
            dsc.setUrl("jdbc:mysql://172.16.5.50:3306/user?useUnicode=true&characterEncoding=utf8");
            dsc.setDriverName("com.mysql.jdbc.Driver");
            dsc.setUsername("root");
            dsc.setPassword("123456");
            mpg.setDataSource(dsc);

            // 包配置
            PackageConfig pc = new PackageConfig();
            pc.setParent("com.zlm.community.");
            pc.setEntity("model");
            pc.setMapper("dao");
            pc.setService("service");
            pc.setServiceImpl("service.impl");
            pc.setController("controller");
            mpg.setPackageInfo(pc);

            // 自定义配置
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    // to do nothing
                }
            };
            List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
            focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输入文件名称
                    return projectPath + "/src/main/java/com/zlm/community/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }

            });
            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);
            mpg.setTemplate(new TemplateConfig().setXml(null));

            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
            strategy.setEntityLombokModel(true);
            strategy.setInclude(scanner());
            mpg.setStrategy(strategy);
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
            mpg.execute();
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入 y 继续，其他退出");
            String input = scanner.next();
            if (!"y".equals(input)) {
                return;
            }
        } while (true);
    }
}
