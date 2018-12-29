package com.stocktrainer.stockJb.controllers;

import com.stocktrainer.stockJb.model.Stock;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StocksController implements ApplicationController {

    Stock foundStock;

    @GetMapping(value = "/sym/{sym}")
    public ResponseEntity getStockBySym(String stockSym) {
        return null;
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity getStockByName(String stockName) {
        return null;
    }

    @GetMapping(value = "/high-price")
    public ResponseEntity getHighestPriceStocks() {
        return null;
    }

    @GetMapping(value = "/high-price/{num}")
    public ResponseEntity getHighestPriceStocks(int num) {
        return null;
    }

    @GetMapping(value = "/low-price")
    public ResponseEntity getLowestPriceStocks() {
        return null;
    }

    @GetMapping(value = "/low-price/{num}")
    public ResponseEntity getLowestPriceStocks(int num) {
        return null;
    }

    @GetMapping(value = "/high-performers")
    public ResponseEntity getTopEarningStocks() {
        return null;
    }

    @GetMapping(value = "/high-performers/{num}")
    public ResponseEntity getTopEarningStocks(int num) {
        return null;
    }

    @GetMapping(value = "/low-performers")
    public ResponseEntity getLowPerformingStocks() {
        return null;
    }

    @GetMapping(value = "/low-performers/{num}")
    public ResponseEntity getLowPerformingStocks(int num) {
        return null;
    }
}
