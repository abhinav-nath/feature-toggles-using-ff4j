package com.codecafe.featuretoggles.config;

import com.codecafe.featuretoggles.ff4j.FeatureToggleFF4J;
import org.ff4j.FF4j;
import org.ff4j.security.SpringSecurityAuthorisationManager;
import org.ff4j.springjdbc.store.EventRepositorySpringJdbc;
import org.ff4j.springjdbc.store.FeatureStoreSpringJdbc;
import org.ff4j.springjdbc.store.PropertyStoreSpringJdbc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FF4jConfig {

  @Bean
  public FF4j getFF4j(DataSource dataSource) {
    FeatureToggleFF4J ff4j = new FeatureToggleFF4J();
    ff4j.setFeatureStore(new FeatureStoreSpringJdbc(dataSource));
    ff4j.setPropertiesStore(new PropertyStoreSpringJdbc(dataSource));
    ff4j.setEventRepository(new EventRepositorySpringJdbc(dataSource));
    ff4j.audit(true);
    ff4j.setAutocreate(false);
    ff4j.createSchema();
    ff4j.setAuthorizationsManager(new SpringSecurityAuthorisationManager());
    return ff4j;
  }

}