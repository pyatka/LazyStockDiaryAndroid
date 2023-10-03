package com.example.lazystockdiaryandroid;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lazystockdiaryandroid.adapter.SearchSymbolAdapter;
import com.example.lazystockdiaryandroid.model.SearchSymbol;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SymbolSearchFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ListView searchSymbolListView;

    public static SymbolSearchFragment newInstance() {
        return new SymbolSearchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_symbol_search, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        searchSymbolListView = getActivity().findViewById(R.id.search_symbol_list_view);
        searchSymbolListView.setOnItemClickListener(this);

        EditText searchInput = getActivity().findViewById(R.id.search_symbol_input);
        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0){
                    Call<ArrayList<SearchSymbol>> call = ((MainActivity)getActivity()).restApiInterface.Search("msft");
                    call.enqueue(new Callback<ArrayList<SearchSymbol>>() {
                        @Override
                        public void onResponse(Call<ArrayList<SearchSymbol>> call, Response<ArrayList<SearchSymbol>> response) {
                            ArrayList<SearchSymbol> resource = response.body();
                            SearchSymbolAdapter adapter = new SearchSymbolAdapter(resource, getActivity().getApplicationContext());
                            searchSymbolListView.setAdapter(adapter);
                        }

                        @Override
                        public void onFailure(Call<ArrayList<SearchSymbol>> call, Throwable t) {
                            call.cancel();
                        }
                    });
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        SearchSymbol symbol = (SearchSymbol) parent.getItemAtPosition(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("symbol", (Serializable) symbol);
        ((MainActivity)getActivity()).navController.navigate(R.id.buySymbolFragment, bundle);
    }
}