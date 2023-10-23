package com.codecafe.featuretoggles.config;

import org.ff4j.FF4j;
import org.ff4j.web.FF4jDispatcherServlet;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({FF4jDispatcherServlet.class})
@AutoConfigureAfter(FF4jConfig.class)
public class FF4jWebConsoleConfiguration extends SpringBootServletInitializer {

  @Bean
  @ConditionalOnMissingBean
  public FF4jDispatcherServlet defineFF4jServlet(FF4j ff4j) {
    FF4jDispatcherServlet ff4jConsoleServlet = new FF4jDispatcherServlet();
    ff4jConsoleServlet.setFf4j(ff4j);
    ff4jConsoleServlet.setAskConfirmationBeforeDeleting(true);
    return ff4jConsoleServlet;
  }

  @Bean
  public ServletRegistrationBean<FF4jDispatcherServlet> registerFF4jServlet(FF4jDispatcherServlet ff4jDispatcherServlet) {
    return new ServletRegistrationBean<>(ff4jDispatcherServlet, "/feature-toggle-service/*");
  }

}