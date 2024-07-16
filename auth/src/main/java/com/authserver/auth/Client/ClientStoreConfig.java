package com.authserver.auth.Client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

@Configuration
public class ClientStoreConfig {
 
  @Bean
  RegisteredClientRepository registeredClientRepository() {
    return null;
  }

}
