package com.example.lazystockdiaryandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lazystockdiaryandroid.R;
import com.example.lazystockdiaryandroid.model.SearchSymbol;

import java.util.ArrayList;

public class SearchSymbolAdapter extends ArrayAdapter<SearchSymbol> {
    private ArrayList<SearchSymbol> dataSet;
    Context mContext;
    public SearchSymbolAdapter(ArrayList<SearchSymbol> data, Context context) {
        super(context, R.layout.search_symbol_row, data);
        this.dataSet = data;
        this.mContext=context;
    }

    private static class ViewHolder {
        TextView code;
        TextView exchange;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SearchSymbol dataModel = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.search_symbol_row, parent, false);
            viewHolder.code = (TextView) convertView.findViewById(R.id.code);
            viewHolder.exchange = (TextView) convertView.findViewById(R.id.exchange);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.code.setText(dataModel.Code);
        viewHolder.exchange.setText(dataModel.Exchange);
        return convertView;
    }
}
