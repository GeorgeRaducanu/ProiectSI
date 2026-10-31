package org.cloudsimplus.examples.common;

import java.util.List;

/**
 * Generates deterministic request arrival times from a scenario configuration.
 */
@FunctionalInterface
public interface WorkloadGenerator {
    /**
     * Generates arrival times in simulated seconds.
     *
     * @param config scenario parameters, including the random seed
     * @return request arrival times in ascending order
     */
    List<Double> generate(ScenarioConfig config);
}
