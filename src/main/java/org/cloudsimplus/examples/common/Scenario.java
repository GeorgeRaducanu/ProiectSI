package org.cloudsimplus.examples.common;

/**
 * Shared lifecycle for the monolith and microservices simulation scenarios.
 */
public interface Scenario {
    /**
     * Creates and connects the simulation entities.
     */
    void setup();

    /**
     * Runs the configured simulation.
     */
    void run();

    /**
     * Returns the stable scenario architecture name used in result files.
     */
    String name();
}
