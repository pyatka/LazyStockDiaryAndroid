package com.example.lazystockdiaryandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.lazystockdiaryandroid.model.OperationDetails;
import com.example.lazystockdiaryandroid.model.SearchSymbol;

public class BuySymbolFragment extends Fragment {
    private OperationDetails operationDetails;
    public BuySymbolFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            operationDetails = new OperationDetails((SearchSymbol) getArguments().getSerializable("symbol"));
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_buy_symbol, container, false);
    }
}