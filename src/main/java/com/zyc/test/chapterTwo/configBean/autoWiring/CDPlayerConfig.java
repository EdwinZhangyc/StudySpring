package com.zyc.test.chapterTwo.configBean.autoWiring;

import com.zyc.test.chapterTwo.configBean.MarkInterface;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ComponentScan 该注解表示自动扫描spring下的bean
 * 与XML配置文件中的<context:component-scan base-package="com.zyc.test.chapterTwo.configBean.autoWiring"/>意思一致
 */
@Configuration //该注解表示该Java是一个配置类
//@ComponentScan //当@ComponentScan注解后面没有标识扫描哪个包下bean时，默认是本类包及子包下的所有类
//@ComponentScan (basePackages = "com.zyc.test.chapterTwo.configBean")//当扫描是包的时候需要写全地址
@ComponentScan(basePackageClasses = MarkInterface.class)//当扫描是类的时候可以写全地址也可以写将类引入进来
public class CDPlayerConfig {
}