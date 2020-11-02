package com.aaa.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class PathConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 说明：增加虚拟路径(经过本人测试：在此处配置的虚拟路径，用springboot内置的tomcat时有效，
         用外部的tomcat也有效;所以用到外部的tomcat时不需在tomcat/config下的相应文件配置虚拟路径了,阿里云linux也没问题)
         */
        registry.addResourceHandler("/static/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/static/bootstrap-3.3.7-dist/css/**").addResourceLocations("classpath:/static/bootstrap-3.3.7-dist/css/");
        registry.addResourceHandler("/static/bootstrap-3.3.7-dist/fonts/**").addResourceLocations("classpath:/static/bootstrap-3.3.7-dist/fonts/");
        registry.addResourceHandler("/static/bootstrap-3.3.7-dist/js/**").addResourceLocations("classpath:/static/bootstrap-3.3.7-dist/js/");
        registry.addResourceHandler("/photo/**").addResourceLocations("file:D:/photoimg/");

        super.addResourceHandlers(registry);
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setBeanName("HiddenHttpMethodFilter");
        hiddenHttpMethodFilter.setMethodParam("_method");
        return hiddenHttpMethodFilter;
    }
}
