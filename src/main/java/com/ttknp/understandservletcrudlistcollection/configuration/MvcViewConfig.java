package com.ttknp.understandservletcrudlistcollection.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// This config works for @Controller not @WebServlet
@Configuration
public class MvcViewConfig implements WebMvcConfigurer {

    /**
       same application.properties
            ...
            spring.mvc.view.prefix= /WEB-INF/jsp/
            spring.mvc.view.suffix= .jsp
    */
    @Bean
    public ViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // base on *** webapp folder
        viewResolver.setPrefix("/WEB-INF/jsp/");
        // viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
