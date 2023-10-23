package com.codecafe.featuretoggles.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
  NOT_FOUND(404, "FEAT-TOGGLE-001", "Feature Not Found"),
  UNAUTHENTICATED(401, "FEAT-TOGGLE-002", "Unauthenticated"),
  ACCESS_DENIED(403, "FEAT-TOGGLE-003", "Access denied");

  private final Integer httpCode;
  private final String code;
  private final String name;
}