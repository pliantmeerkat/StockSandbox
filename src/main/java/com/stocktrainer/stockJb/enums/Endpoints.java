package com.stocktrainer.stockJb.enums;

public enum Endpoints {

    USERS("/user"),
    STOCKS("/stock");

    private String endpointName;

    Endpoints(String url) {
        this.endpointName = url;
    }

    @Override
    public String toString() {
        return this.endpointName;
    }

}
