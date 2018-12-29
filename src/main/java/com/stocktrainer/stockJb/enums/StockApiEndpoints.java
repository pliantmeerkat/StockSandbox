package com.stocktrainer.stockJb.enums;

public enum StockApiEndpoints {

    SINGLE_STOCK("/stock/"),
    BATCH_STOCK("/stock/market/batch/"),
    CRYPTO_STOCK("/stock/market/crypto/"),
    EARNINGS_TODAY("/stock/market/today-earnings/"),
    IPOS_FUTURE("/stock/market/upcoming-ipos/"),
    IPOS_TODAY("(/stock/market/today-ipos/"),
    CHART_STOCK("/chart/"),
    COMPANY_SEARCH("/company/"),
    SYMBOL_SEARCH("/ref-data/symbols/"),
    TOPS_SEARCH("/tops/");

    private String value;

    StockApiEndpoints(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
