package com.codecafe.featuretoggles.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
@Schema(description = "Collection of feature toggles")
public class FeatureToggles {

  @Schema(description = "List of feature toggles")
  List<FeatureToggle> featureTogglesList;

}