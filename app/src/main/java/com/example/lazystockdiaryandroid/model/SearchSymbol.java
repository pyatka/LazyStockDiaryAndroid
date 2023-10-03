package com.example.lazystockdiaryandroid.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SearchSymbol implements Serializable {
    @SerializedName("code")
    public String Code;
    @SerializedName("exchange")
    public String Exchange;
    @SerializedName("name")
    public String Name;
    @SerializedName("type")
    public String Type;
    @SerializedName("country")
    public String Country;
    @SerializedName("currency")
    public String Currency;
    @SerializedName("isin")
    public String ISIN;
    @SerializedName("previousClose")
    public Double PreviousClose;
    @SerializedName("previousCloseDate")
    public LocalDateTime PreviousCloseDate;
}
