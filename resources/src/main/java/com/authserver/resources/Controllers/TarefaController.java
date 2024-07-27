package com.authserver.resources.Controllers;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;


@RestController
@RequestMapping("tarefas")
public class TarefaController {

  @GetMapping
  public String getTarefas(@AuthenticationPrincipal Jwt jwt) {
    return """
      <h1>Todas as tarefas secretas do %s</h1>

      <ol>
        <li>Tarefa Secreta 1</li>
        <li>Tarefa Secreta 2</li>
        <li>Tarefa Secreta 3</li>
        <li>Tarefa Secreta 4</li>
        <li>Tarefa Secreta 5</li>
        <li>Tarefa Secreta 6</li>
      </ol>
    """.formatted(jwt.getSubject());
  }

}
