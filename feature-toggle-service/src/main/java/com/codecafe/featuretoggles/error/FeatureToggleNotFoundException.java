package com.codecafe.featuretoggles.error;

import lombok.Getter;

@Getter
public class FeatureToggleNotFoundException extends RuntimeException {

  public FeatureToggleNotFoundException(ErrorCode errorCode, String message, Throwable throwable) {
    super(errorCode.getCode() + ": " + message, throwable);
  }

}