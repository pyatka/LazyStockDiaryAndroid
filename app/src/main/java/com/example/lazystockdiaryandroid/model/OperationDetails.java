package com.example.lazystockdiaryandroid.model;

import java.time.LocalDateTime;

public class OperationDetails {
    public Symbol Symbol;
    public int Quantity;
    public double Price;
    public LocalDateTime Date;

    public OperationDetails() {

    }
    public OperationDetails(SearchSymbol searchSymbol){
        this.Symbol = new Symbol(searchSymbol);
    }
}
