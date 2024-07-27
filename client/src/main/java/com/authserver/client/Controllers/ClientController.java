package com.authserver.client.Controllers;

import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;

@RestController
public class ClientController {
  
  @SuppressWarnings("null")
  @GetMapping("home")
  public Mono<String> home(
    @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client,
    @AuthenticationPrincipal OidcUser oidcUser
  ) {
    return Mono.just("""
      <h2>Access Token gerado: %s</h2>
      <h2>Refresh Token gerado: %s</h2>
      <h2>ID Token gerado (OpenID): %s</h2>
      <h2>Claims do usuário: %s</h2>
    """.formatted(
      client.getAccessToken().getTokenValue(), client.getRefreshToken().getTokenValue(),
      oidcUser.getIdToken().getTokenValue(), oidcUser.getClaims()
    ));
  }  

}
