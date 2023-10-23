package com.codecafe.featuretoggles.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "app.service-auth")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class SecurityConfigurationProperties {

  Boolean enableSecurity = false;
  String[] unsecuredRoutes;
  Map<String, List<Route>> scopes;

  @Nullable
  String defaultScope;

  @FieldDefaults(level = AccessLevel.PRIVATE)
  @Data
  public static class Route {
    String[] antMatchers;
  }

}