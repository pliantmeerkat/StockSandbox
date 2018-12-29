package com.stocktrainer.stockJb.controllers;

import com.stocktrainer.stockJb.model.Stock;
import com.stocktrainer.stockJb.repositories.StockPurchaseRepository;
import com.stocktrainer.stockJb.repositories.UsersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StocksController implements ApplicationController {

    Stock foundStock;

    StockPurchaseRepository stockPurchaseRepository;
    UsersRepository usersRepository;

    @GetMapping(value = "/sym/{sym}")
    public ResponseEntity getStockBySym(String stockSym) {
        return null;
    }

    @PostMapping(value = "/purchase")
    public ResponseEntity purchaseStock(String purchaseJson) {
        return null;
    }
}
