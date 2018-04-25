package com.spring.four.chapterTwenty.JmxManager.config;

import com.spring.four.chapterTwenty.JmxManager.controller.SpittleController;
import com.spring.four.chapterTwenty.JmxManager.service.SpittleControllerManagedOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodExclusionMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodNameBasedMBeanInfoAssembler;
import org.springframework.jmx.support.RegistrationPolicy;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("com")
public class JmxConfig {

    /**
     * 声明一个MBeanExporter，他会将SpittleController导出为一个模型MBean
     * @param spittleController
     * @return
     */
    @Bean
    public MBeanExporter mBeanExporter(SpittleController spittleController){
        MBeanExporter exporter = new MBeanExporter();
        Map<String, Object> beans = new HashMap<String, Object>();
        beans.put("spitter:name=SpittleController", spittleController);
        exporter.setBeans(beans);
        return exporter;
    }

    /**
     * 20.1.1 通过方法名称进行暴露与不暴露方法
     * 指定上传数据的暴露的接口
     * @return
     */
    @Bean
    public MethodNameBasedMBeanInfoAssembler assembler(){
        MethodNameBasedMBeanInfoAssembler assembler = new MethodNameBasedMBeanInfoAssembler();
        //暴露的方法
        assembler.setManagedMethods(new String[] {
                "getSpittlesPerPage", "setSpittlePerPage"
        });
        return assembler;
    }
    //指定不暴露方法
    @Bean
    public MethodExclusionMBeanInfoAssembler assemblerExclusion(){
        MethodExclusionMBeanInfoAssembler assembler = new MethodExclusionMBeanInfoAssembler();
        //指定不暴露方法
        assembler.setIgnoredMethods(new String[] {
                "spittles"
        });
        return assembler;
    }
    @Bean
    public MBeanExporter mBeanExporterMethod(SpittleController spittleController,
                                             MBeanInfoAssembler assembler){
        MBeanExporter exporter = new MBeanExporter();
        Map<String, Object> beans = new HashMap<String, Object>();
        beans.put("spitter:name=SpittleController", spittleController);
        exporter.setBeans(beans);
        exporter.setAssembler(assembler);
        /**
         * 处理MBean冲突，一共有三种解决犯方案
         * RegistrationPolicy.IGNORE_EXISTING 当MBean名称冲突时忽略冲突同时不注册新MBean
         */
        exporter.setRegistrationPolicy(RegistrationPolicy.IGNORE_EXISTING);
        return exporter;
    }

    /**
     * 20.1.2 使用接口定义MBean的操作和属性
     */
    @Bean
    public InterfaceBasedMBeanInfoAssembler assemblerInterface (){
        InterfaceBasedMBeanInfoAssembler assembler = new InterfaceBasedMBeanInfoAssembler();
        assembler.setManagedInterfaces(
                new Class<?>[] {SpittleControllerManagedOperations.class}
        );
        return assembler;
    }
}