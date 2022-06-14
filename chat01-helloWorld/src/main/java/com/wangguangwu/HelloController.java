package com.wangguangwu;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 1. tomcat 启动时，会初始化 DispatcherServlet，DispatcherServlet 中会创建一个 springMvc 容器，容器的类型是 WebApplicationContext
 * 容器会加载 web.xml 中指定的 springMvc.xml 配置文件；
 * 2. springMvc.xml 中指定了扫描包的规则，而 HelloController 符合这个扫描规则，所以会被注册到 springMvc 容器中。
 * 3. web.xml 中指定所有的请求都由 DispatcherServlet 处理器处理，当接收到请求后，处理器会根据请求路径，去 springMvc 容器中找到处理这个请求的方法
 * 这个步骤是通过 @RequestMapping 注解来匹配的，通过这个注解将请求和方法进行映射，匹配的请求会被 @RequestMapping 标注的方法处理
 * 4. DispatcherServlet 中通过反射来调用 helloController 这个 bean 的 hello 方法
 * 5. DispatcherServlet 接收到了 hello 方法的返回值
 * 6. DispatcherServlet 根据 hello 方法中的返回值，做跳转操作，相当于
 * request.getRequestDispatcher("/WEB-INF/view/hello.jsp").forward(request, response);
 *
 * @author wangguangwu
 */
@RestController
public class HelloController {

    @RequestMapping("hello")
    public ModelAndView hello(HttpServletRequest request) {
        System.out.println("request:" + request);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/hello.jsp");
        // modelAndView.addObject 方法相当于 request.setAttribute 方法
        modelAndView.addObject("msg", "Hello wangguangwu");
        return modelAndView;
    }

}
