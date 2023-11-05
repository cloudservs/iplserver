package com.cloudserv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;;
@SpringBootApplication
@ComponentScan("com.cloudserv")
public class Application extends SpringBootServletInitializer {
    @Autowired
    private ApplicationContext context;
    @Bean
    public ServletRegistrationBean restApi() {
        XmlWebApplicationContext applicationContext = new XmlWebApplicationContext();
        applicationContext.setParent(context);
        applicationContext.setConfigLocation("classpath:/META-INF/dispatcher-servlet.xml");

        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setApplicationContext(context);

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/rest/*");
        servletRegistrationBean.setName("restApi");

        return servletRegistrationBean;
    }
    static public void main(String[] args) throws Exception {
        SpringApplication.run(Application.class,args);
    }
}
