package com.yonyou.cbrand;

import com.yonyou.iuap.auth.shiro.StatelessAuthcFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Shiro 配置
 * @author  
 * @date 2019-9-25 21:04:26
 */
@Configuration
@ImportResource(locations = { "classpath*:/applicationContext-shiro.xml" })
@SuppressWarnings({ "rawtypes", "unchecked" })

public class ShiroConfig {
        @Bean
        public FilterRegistrationBean regShiroDelegatingFilterProxy() {
                FilterRegistrationBean registration = new FilterRegistrationBean();
                registration.setFilter(new org.springframework.web.filter.DelegatingFilterProxy());
                registration.addUrlPatterns("/*");
                registration.addInitParameter("targetFilterLifecycle", "true");
                registration.setName("shiroFilter");
                registration.setOrder(3);
                return registration;
        }

        @Bean
        public FilterRegistrationBean unRegStateLessFilterBean(StatelessAuthcFilter statelessAuthcFilter) {
                FilterRegistrationBean registration = new FilterRegistrationBean(statelessAuthcFilter);
                registration.setEnabled(false);
                return registration;
        }

        @Bean
        public FilterRegistrationBean unRegLogoutBean(com.yonyou.iuap.auth.shiro.LogoutFilter logoutFilter) {
                FilterRegistrationBean registration = new FilterRegistrationBean(logoutFilter);
                registration.setEnabled(false);
                return registration;
        }
}
