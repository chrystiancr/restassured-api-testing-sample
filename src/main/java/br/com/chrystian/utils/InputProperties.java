package br.com.chrystian.utils;

public class InputProperties {

    public static String getEnvironment() {
        return System.getProperty("env") == null ? Environment.DEV : System.getProperty("env");
    }

    public interface Environment {

        String DEV = "dev";
        String HOM = "hom";
        String PREPROD = "preprod";
        String PROD = "prod";
    }
}
