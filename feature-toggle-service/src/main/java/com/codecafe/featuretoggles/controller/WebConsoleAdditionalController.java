package com.codecafe.featuretoggles.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@Slf4j
@Hidden
public class WebConsoleAdditionalController {

  @GetMapping("/")
  public ResponseEntity<Void> redirectToFeatureToggleUI() {
    return ResponseEntity
      .status(HttpStatus.TEMPORARY_REDIRECT)
      .location(URI.create("/feature-toggle-service").normalize())
      .build();
  }

  @GetMapping("/logout/callback")
  public ResponseEntity<String> logoutCallback() {
    return ResponseEntity
      .ok()
      .contentType(MediaType.TEXT_HTML)
      .body("Logout successful");
  }

}