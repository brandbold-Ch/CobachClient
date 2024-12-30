package org.core.config;

import java.io.Serial;
import java.io.Serializable;

public class ConfigSecrets implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    public static ConfigSecrets instance;
    private String accessToken;
    private boolean cacheable;

    public static ConfigSecrets getInstance() {
        if (instance == null) {
            instance = new ConfigSecrets();
        }
        instance.accessToken = Register.ACCESS_TOKEN;
        instance.cacheable = Register.CACHEABLE;

        return instance;
    }

    public static void setInstance(ConfigSecrets instance) {
        ConfigSecrets.instance = instance;
        Register.ACCESS_TOKEN = instance.accessToken;
        Register.CACHEABLE = instance.cacheable;
    }
}
