package com.lennydennis.dukayangu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SellFragment extends Fragment {

    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    private ArrayList<String> itemName = new ArrayList<>();
    private  ArrayList<String> itemImage = new ArrayList<>();
    private ArrayList<String> itemPrice = new ArrayList<>();

    public SellFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SellFragment newInstance(String param1, String param2) {
        SellFragment fragment = new SellFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        initItem();

        View view = inflater.inflate(R.layout.fragment_sell, container, false);
        ButterKnife.bind(this,view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),itemName,itemImage,itemPrice);
        recyclerView.setAdapter(recyclerViewAdapter  );
        layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        // Inflate the layout for this fragment
        return view;
    }

    private void initItem(){
        itemImage.add("https://images.unsplash.com/photo-1558981806-ec527fa84c39?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=60");
        itemName.add("Bike");
        itemPrice.add("Ksh 200");

        itemImage.add("https://images.unsplash.com/photo-1496181133206-80ce9b88a853?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=60");
        itemName.add("Laptop");
        itemPrice.add("Ksh 500");

        itemImage.add("https://images.unsplash.com/photo-1558981806-ec527fa84c39?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=60");
        itemName.add("Bike");
        itemPrice.add("Ksh 200");

        itemImage.add("https://images.unsplash.com/photo-1523206489230-c012c64b2b48?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=60");
        itemName.add("Phone");
        itemPrice.add("Ksh 300");

        itemImage.add("https://images.unsplash.com/photo-1558981806-ec527fa84c39?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=60");
        itemName.add("Bike");
        itemPrice.add("Ksh 200");

        itemImage.add("https://images.unsplash.com/photo-1558981806-ec527fa84c39?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=60");
        itemName.add("Bike");
        itemPrice.add("Ksh 200");

        itemImage.add("https://images.unsplash.com/photo-1558981806-ec527fa84c39?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=60");
        itemName.add("Bike");
        itemPrice.add("Ksh 200");

        itemImage.add("https://images.unsplash.com/photo-1542362567-b07e54358753?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=60");
        itemName.add("Car");
        itemPrice.add("Ksh 200");

        itemImage.add("https://images.unsplash.com/photo-1558981806-ec527fa84c39?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=60");
        itemName.add("Bike");
        itemPrice.add("Ksh 200");

        itemImage.add("https://images.unsplash.com/photo-1558981806-ec527fa84c39?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=60");
        itemName.add("Bike");
        itemPrice.add("Ksh 200");

        itemImage.add("https://images.unsplash.com/photo-1505740420928-5e560c06d30e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=60");
        itemName.add("Headphones");
        itemPrice.add("Ksh 200");
    }
}
