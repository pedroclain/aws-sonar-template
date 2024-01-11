package com.example.echo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EchoApplicationTests {

  @LocalServerPort
  private int port;
  private TestRestTemplate testRestTemplate;

  @BeforeEach
  void setUp() {
    RestTemplateBuilder builder = new RestTemplateBuilder()
        .rootUri(String.format("http://localhost:%d", port));
    testRestTemplate = new TestRestTemplate(builder);
  }

  @Test
  @DisplayName("when access root endpoint, then return echo")
  void echo() {
    ResponseEntity<String> response = testRestTemplate.getForEntity("/", String.class);
    String echoMessage = "Hello world, from Spring Boot with AWS and Sonar Cloud";

    assertThat(response.getStatusCodeValue()).isEqualTo(200);
    assertThat(response.getBody()).isEqualTo(echoMessage);
  }

}
