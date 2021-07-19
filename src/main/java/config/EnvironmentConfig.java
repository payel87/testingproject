package config;


import helpers.DataReader;

import java.util.Map;

public class EnvironmentConfig {

    private String environment;
    private String environmentUrl;
    private String waitTime;
    private String driver;
    private Map<String, Map<String, String>> environmentDetails;

    public EnvironmentConfig() {
        environmentDetails = new DataReader().yamlReader("env_config.yaml");

    }

    public void setEnvironmentDetails()
    {
        environmentUrl = environmentDetails.get("environmentUrl").get(environment);
        waitTime = environmentDetails.get("waitTime").get(environment);
        driver = environmentDetails.get("driver").get(environment);

    }

    public String getEnvironmentUrl() {
            return environmentUrl;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setDefaultEnvironment()
    {
        environment = environmentDetails.get("environment").get("name");
    }





}
