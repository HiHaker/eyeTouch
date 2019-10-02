package com.yonyou.cfavorites;

import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.mybatis.UcfMapperFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * 模块启动器
 *
 * @author  
 * @date 2019-10-2 18:16:06
 * @since v5.0.0
 */
@ComponentScan(basePackages = {"com.yonyou"})
@MapperScan(basePackages = "com", annotationClass = MyBatisRepository.class, factoryBean = UcfMapperFactoryBean.class)
@EnableTransactionManagement
@SpringBootApplication(exclude = {
        JpaRepositoriesAutoConfiguration.class //禁止springboot自动加载持久化bean
})
@EnableSwagger2
@Slf4j
public class BootApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
