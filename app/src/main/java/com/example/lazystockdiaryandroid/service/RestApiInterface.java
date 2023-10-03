package com.example.lazystockdiaryandroid.service;

import com.example.lazystockdiaryandroid.model.SearchSymbol;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApiInterface {
    @GET("/search")
    Call<ArrayList<SearchSymbol>> Search(@Query("query") String query);
}
