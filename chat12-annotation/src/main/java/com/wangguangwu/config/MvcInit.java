package com.wangguangwu.config;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;


/**
 * 创建初始化类，替代 web.xml
 * <p>
 * 背景：
 * Servlet 3.0 环境中，容器会在类路径中查找实现 javax.servlet.ServletContainerInitializer 接口的类，找到该类就用它来配置 Servlet 容器
 * <p>
 * spring 中提供了 ServletContainerInitializer 这个接口的实现，名为 SpringServletContainerInitializer
 * 这个类会查找实现 WebApplicationInitializer 的类并将配置的任务交给他们完成。
 * <p>
 * Spring 3.2 引入了一个便利的 WebApplicationInitializer 的基础实现，名为 AbstractAnnotationConfigDispatcherServletInitializer。
 * <p>
 * 当我们的类扩展了 AbstractAnnotationConfigDispatcherServletInitializer，并将其部署到 Servlet3.0 容器的时候，容器会自动发现他，并用它来配置 Servlet 上下文
 * <p>
 * <p>
 * 1. 创建 Mvc 初始化类，需要继承 AbstractAnnotationConfigDispatcherServletInitializer
 *
 * @author wangguangwu
 */
public class MvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * springmvc 的父容器 spring 配置类
     * 实际工作中我们的项目比较复杂，可以将 controller 层放在 springmvc 容器中
     * 其他层，如 service 层、dao 层放在父容器了，bean 管理起来更清晰一些
     * 也可以没有父容器，将所有 bean 都放在 springmvc 容器中
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
     * 2. 设置 springmvc 容器的 spring 配置类
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    /**
     * 3. 配置 DispatcherServlet 的 url-pattern
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 4. 注册拦截器
     */
    @Override
    protected Filter[] getServletFilters() {
        // 添加拦截器，解决乱码问题
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceRequestEncoding(true);
        characterEncodingFilter.setForceResponseEncoding(true);
        return new Filter[]{characterEncodingFilter};
    }

}
