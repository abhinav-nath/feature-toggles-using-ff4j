package com.codecafe.featuretoggles.controller;

import com.codecafe.featuretoggles.model.FeatureToggle;
import com.codecafe.featuretoggles.model.FeatureToggles;
import com.codecafe.featuretoggles.service.FeaturesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/features")
@AllArgsConstructor
@Validated
@Slf4j
public class FeaturesController {

  private final FeaturesService featuresService;

  @GetMapping()
  @Operation(
    summary = "Fetch feature toggles for all features",
    tags = "Features",
    responses = @ApiResponse(
      responseCode = "200",
      description = "OK",
      content = @Content(
        mediaType = APPLICATION_JSON_VALUE,
        schema = @Schema(implementation = FeatureToggles.class))))
  public ResponseEntity<FeatureToggles> fetchAllFeatureToggles() {
    return ResponseEntity
      .ok()
      .body(featuresService.getAllFeatureToggles());
  }

  @GetMapping("/{featureName}")
  @Operation(
    summary = "Fetch feature toggles for given feature",
    tags = "Features",
    responses = @ApiResponse(
      responseCode = "200",
      description = "OK",
      content = @Content(
        mediaType = APPLICATION_JSON_VALUE,
        schema = @Schema(implementation = FeatureToggle.class))))
  public ResponseEntity<FeatureToggle> fetchFeatureToggle(
    @Parameter(
      description = "Name of the feature to fetch",
      example = "product-search.feature-1") @PathVariable String featureName) {
    return ResponseEntity
      .ok()
      .body(featuresService.getFeatureToggle(featureName));
  }

  @GetMapping("/pattern/{pattern}")
  @Operation(
    summary = "Fetch all feature toggles matching given pattern",
    tags = "Features",
    responses = @ApiResponse(
      responseCode = "200",
      description = "OK",
      content = @Content(
        mediaType = APPLICATION_JSON_VALUE,
        schema = @Schema(implementation = FeatureToggles.class))))
  public ResponseEntity<FeatureToggles> getFeatureForSpecificPattern(
    @Parameter(
      description = "Feature name pattern to search",
      example = "product-search") @PathVariable String pattern) {
    return ResponseEntity
      .ok()
      .body(featuresService.getFeatureWithPattern(pattern));
  }

}