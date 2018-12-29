package com.stocktrainer.stockJb.enums;

public enum UrlConstants {

    BASE_URL_LOCAL("http://localhost:8080"),
    DB_URL_LOCAL("http://localhost:27017"),
    STOCK_API_BASE_URL("https://api.iextrading.com/1.0");

    private String urlValue;

    UrlConstants(String url) {
        this.urlValue = url;
    }

    @Override
    public String toString() {
        return this.urlValue;
    }
}
