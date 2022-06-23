package com.wangguangwu.config;

import com.wangguangwu.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 1. 开启 springmvc 注解配置
 * 2. 配置视图解析器
 * 3. 配置拦截器
 * 4. 配置静态资源访问
 * 5. 配置文件上传解析器
 * 6. 配置全局异常处理器
 *
 * @author wangguangwu
 */
@Configuration
@ComponentScan("com.wangguangwu")
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 2. 添加视图解析器（可以添加多个）
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        resolver.setOrder(Ordered.LOWEST_PRECEDENCE);
        registry.viewResolver(resolver);
    }

    @Autowired
    private MyInterceptor myInterceptor;

    /**
     * 3. 添加拦截器（可以添加多个）
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.myInterceptor).addPathPatterns("/**");
    }

    /**
     * 4. 配置静态资源访问处理器
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    /**
     * 5. 配置文件上传解析器
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        // maxUploadSizePerFile:单个文件大小限制（byte）
        // maxUploadSize：整个请求大小限制（byte）
        commonsMultipartResolver.setMaxUploadSizePerFile(10 * 1024 * 1024L);
        commonsMultipartResolver.setMaxUploadSize(100 * 1024 * 1024L);
        return commonsMultipartResolver;
    }

}

