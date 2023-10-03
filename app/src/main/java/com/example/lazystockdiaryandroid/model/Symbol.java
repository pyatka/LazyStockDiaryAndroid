package com.example.lazystockdiaryandroid.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Symbol implements Serializable {
    public String Code;
    public String Exchange;
    public String Name;
    public String Type;
    public String Country;
    public String Currency;
    public String ISIN;

    public LocalDateTime PreviousCloseDate;

    public double Open;
    public double Close;
    public double High;
    public double Low;
    public int Volume;

    public double PreviousClose;

    public double ChangeAbsolute;
    public double ChangePercent;


    public LocalDateTime DividendLastUpdate;
    public LocalDateTime EodLastUpdate;


    public int Quantity;
    public double Price;
    public double DividendRevenue;

    public Symbol(){

    }
    public Symbol(SearchSymbol searchSymbol){
        this.Code = searchSymbol.Code;
        this.Exchange = searchSymbol.Exchange;
        this.Name = searchSymbol.Name;
        this.Type = searchSymbol.Type;
        this.Country = searchSymbol.Country;
        this.Currency = searchSymbol.Currency;
        this.ISIN = searchSymbol.ISIN;
        this.PreviousClose = searchSymbol.PreviousClose;
        this.PreviousCloseDate = searchSymbol.PreviousCloseDate;
    }
}