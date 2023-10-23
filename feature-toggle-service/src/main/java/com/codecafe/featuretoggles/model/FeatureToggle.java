package com.codecafe.featuretoggles.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
@Schema(description = "Details of the feature toggle")
public class FeatureToggle {

  @Schema(description = "Name of the toggle", example = "product-search.feature-1")
  String name;

  @Schema(description = "Indicates if toggle is enabled or not", example = "true")
  Boolean flag;

}