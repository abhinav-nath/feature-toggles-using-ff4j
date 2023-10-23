package com.codecafe.featuretoggles.ff4j;

import org.ff4j.FF4j;
import org.ff4j.core.Feature;

public class FeatureToggleFF4J extends FF4j {

  public boolean check(Feature fp) {
    boolean flipped = fp.isEnable();

    if (flipped && fp.getFlippingStrategy() != null) {
      flipped = fp.getFlippingStrategy().evaluate(fp.getUid(), getFeatureStore(), getCurrentContext());
    }

    return flipped;
  }

}