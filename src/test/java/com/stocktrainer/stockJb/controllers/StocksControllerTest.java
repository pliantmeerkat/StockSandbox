package com.stocktrainer.stockJb.controllers;

import com.stocktrainer.stockJb.enums.Endpoints;
import com.stocktrainer.stockJb.model.Stock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StocksControllerTest extends ControllerTest{

    private Stock testStock;

    private String testSym = "APL";

    @Before
    public void initialize() {
        endpointUrl = BASE_URL.concat(Endpoints.STOCKS.toString());
    }

    @After
    public void clearUp() {

    }

    @Test
    public void testGetStockBySymReturnsStockWithValidSym() {

    }

    @Test
    public void testGetStockBySymReturnsErrorWithInvalidSym() {

    }
}
