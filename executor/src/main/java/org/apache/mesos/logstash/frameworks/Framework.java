package org.apache.mesos.logstash.frameworks;

import java.nio.file.Paths;
import java.util.List;

/**
 * Created by peldan on 02/07/15.
 */
public abstract class Framework {
    protected String name;
    protected String configuration;
    protected List<String> logLocations;

    public Framework(String frameworkName, String configuration) {
        this.configuration = configuration;
        this.name = frameworkName;
        this.logLocations = parseLogLocations(configuration);
    }

    public String getName() {
        return name;
    }

    public String getConfiguration() {
        return configuration;
    }

    public List<String> getLogLocations() {
        return logLocations;
    }

    public abstract String generateLogstashConfig();

    protected abstract List<String> parseLogLocations(String configuration);
}