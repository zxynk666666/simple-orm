package com.thoughtworks.orm.config;

public class ORMConfig {
    private static String databaseUrl;

    public static void setDatabaseUrl(String databaseUrl) {
        ORMConfig.databaseUrl = databaseUrl;
    }

    public static String getDatabaseUrl() {
        return databaseUrl;
    }
}
