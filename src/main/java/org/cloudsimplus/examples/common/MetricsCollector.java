package org.cloudsimplus.examples.common;

/**
 * Shared metrics boundary for both architecture implementations.
 *
 * <p>CSV persistence and CloudSim listeners will be wired in a later step.</p>
 */
public interface MetricsCollector {
    void recordRequest(
        long requestId,
        String architecture,
        double arrivalTime,
        double finishTime,
        boolean success);

    void recordSample(
        double time,
        String service,
        int vmsUp,
        double cpuUtilization);

    void recordFault(
        double time,
        String entityId,
        String service,
        String event);
}
