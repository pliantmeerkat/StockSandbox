package com.stocktrainer.stockJb.enums;

public enum UrlConstants {

    BASE_URL_LOCAL("http://localhost:8080"),
    DB_URL_LOCAL("http://localhost:27017");

    private String urlValue;

    UrlConstants(String url) {
        this.urlValue = url;
    }

    @Override
    public String toString() {
        return this.urlValue;
    }
}
