package com.example.lazystockdiaryandroid;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.lazystockdiaryandroid.model.OperationDetails;
import com.example.lazystockdiaryandroid.model.SearchSymbol;

import java.util.Calendar;

public class BuySymbolFragment extends Fragment {
    private OperationDetails operationDetails;
    private EditText dateEdit;

    private int year;
    private int month;
    private int day;
    public BuySymbolFragment() {

    }

    private void openDateDialog(View v){
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) (view1, year1, month1, dayOfMonth) -> {
            year = year1;
            month = month1;
            day = dayOfMonth;
            dateEdit.setText((day + "-" + (month + 1) + "-" + year));
        }, year, month, day);
        datePickerDialog.show();
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
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        TextView exchangeView = view.findViewById(R.id.operation_symbol_exchange);
        exchangeView.setText(operationDetails.Symbol.Exchange);

        TextView nameView = view.findViewById(R.id.operation_symbol_name);
        nameView.setText(operationDetails.Symbol.Name);

        EditText quantityEdit = view.findViewById(R.id.operation_quantity);
        EditText priceEdit = view.findViewById(R.id.operation_price);

        dateEdit = view.findViewById(R.id.operation_date);
        dateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDateDialog(v);
            }
        });
        dateEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus == true){
                    openDateDialog(v);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_buy_symbol, container, false);
    }
}