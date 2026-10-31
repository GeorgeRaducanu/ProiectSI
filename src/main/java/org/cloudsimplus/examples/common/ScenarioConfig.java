package org.cloudsimplus.examples.common;

import java.util.Map;
import java.util.Objects;

/**
 * Configuration shared by every simulation architecture.
 */
public record ScenarioConfig(
    String architecture,
    String scenario,
    long seed,
    Map<String, Integer> replicasPerService,
    String allocationPolicy,
    double duration) {

    public ScenarioConfig {
        architecture = requireText(architecture, "architecture");
        scenario = requireText(scenario, "scenario");
        replicasPerService = Map.copyOf(
            Objects.requireNonNull(replicasPerService, "replicasPerService"));
        allocationPolicy = requireText(allocationPolicy, "allocationPolicy");
        if (duration <= 0) {
            throw new IllegalArgumentException("duration must be positive");
        }
    }

    private static String requireText(final String value, final String field) {
        Objects.requireNonNull(value, field);
        if (value.isBlank()) {
            throw new IllegalArgumentException(field + " must not be blank");
        }
        return value;
    }
}
