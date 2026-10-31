package org.cloudsimplus.examples.common;

import java.util.Map;
import java.util.Objects;

/**
 * Mean time to failure and mean time to repair per service.
 */
public record FaultConfig(
    Map<String, Double> mttfByService,
    Map<String, Double> mttrByService) {

    public FaultConfig {
        mttfByService = validateValues(mttfByService, "mttfByService");
        mttrByService = validateValues(mttrByService, "mttrByService");
    }

    private static Map<String, Double> validateValues(
        final Map<String, Double> values,
        final String field) {
        Objects.requireNonNull(values, field);
        values.forEach((service, value) -> {
            if (service == null || service.isBlank()) {
                throw new IllegalArgumentException(field + " contains a blank service");
            }
            if (value == null || value <= 0) {
                throw new IllegalArgumentException(field + " values must be positive");
            }
        });
        return Map.copyOf(values);
    }
}
