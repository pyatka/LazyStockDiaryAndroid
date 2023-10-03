package com.example.lazystockdiaryandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SymbolListFragment extends Fragment {
    private FloatingActionButton fab;

    public static SymbolListFragment newInstance() {
        return new SymbolListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_symbol_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fab = ((MainActivity) getActivity()).findViewById(R.id.fab);
    }

    @Override
    public void onResume() {
        super.onResume();
        fab.show();
    }

    @Override
    public void onPause() {
        super.onPause();
        fab.hide();
    }
}