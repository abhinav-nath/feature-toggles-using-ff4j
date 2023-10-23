package com.codecafe.featuretoggles.service;

import com.codecafe.featuretoggles.error.FeatureToggleNotFoundException;
import com.codecafe.featuretoggles.ff4j.FeatureToggleFF4J;
import com.codecafe.featuretoggles.model.FeatureToggle;
import com.codecafe.featuretoggles.model.FeatureToggles;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ff4j.exception.FeatureNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static com.codecafe.featuretoggles.error.ErrorCode.NOT_FOUND;

@RequiredArgsConstructor
@Slf4j
@Service
public class FeaturesService {
  private static final String FEATURE_WITH_NAME_NOT_FOUND = "Feature with name '%s' not found";

  private final FeatureToggleFF4J ff4j;

  public FeatureToggle getFeatureToggle(String featureName) {
    try {
      return new FeatureToggle(featureName, ff4j.check(ff4j.getFeature(featureName)));
    } catch (FeatureNotFoundException e) {
      throw new FeatureToggleNotFoundException(NOT_FOUND, String.format(FEATURE_WITH_NAME_NOT_FOUND, featureName), e);
    }
  }

  public FeatureToggles getAllFeatureToggles() {
    return ff4j.getFeatures()
               .entrySet()
               .stream()
               .map(featureDetails -> new FeatureToggle(featureDetails.getKey(), ff4j.check(featureDetails.getValue())))
               .collect(Collectors.collectingAndThen(Collectors.toList(), FeatureToggles::new));
  }

  public FeatureToggles getFeatureWithPattern(String pattern) {
    return ff4j.getFeatures()
               .entrySet()
               .stream()
               .filter(featureDetails -> featureDetails.getValue().getUid().startsWith(pattern))
               .map(featureDetails -> new FeatureToggle(featureDetails.getKey(), ff4j.check(featureDetails.getValue())))
               .collect(Collectors.collectingAndThen(Collectors.toList(), FeatureToggles::new));
  }

}