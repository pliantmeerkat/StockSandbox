package com.stocktrainer.stockJb.model;

public class Stock implements ApplicationModel {

    private String stockSym;

    public Stock(String stockSym) {
        this.stockSym = stockSym;
    }
}
