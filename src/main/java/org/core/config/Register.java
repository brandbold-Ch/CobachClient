package org.core.config;

import java.io.Serializable;

public class Register implements Serializable {
    public static final String API_URL = "http://www.brandbold.site:8000";
    public static String ACCESS_TOKEN = "";
    public static boolean CACHEABLE = false;
    private static Register instance;

    public Register getInstance() {
        if (instance == null) {
            instance = new Register();
        }
        return instance;
    }

    public void setInstance(Register instance) {
        Register.instance = instance;
    }
}
