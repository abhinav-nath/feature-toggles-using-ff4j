package com.codecafe.featuretoggles.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@ConditionalOnProperty(value = "app.service-auth.enable-security", havingValue = "false", matchIfMissing = true)
public class NoSecurityConfiguration {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
      .csrf().disable()
      .authorizeRequests()
      .antMatchers("/**").permitAll()
      .and()
      .build();
  }

}