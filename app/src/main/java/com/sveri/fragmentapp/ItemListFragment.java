package com.sveri.fragmentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ItemListFragment extends Fragment {
    String[] fruits = {"Avacado","Mango","Apple","Orange","Banana","Jack Fruit","Dragon Fruit",
                       "Grape","Guava","WaterMelon","Musk Melon","Chickoo","Strawberry","Melon"};
    ListView lvFruits;
    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        lvFruits = view.findViewById(R.id.fruitList);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,fruits);
        lvFruits.setAdapter(adapter);

        //item clicklistener
        lvFruits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextFragment textFragment = (TextFragment) getParentFragmentManager().findFragmentById(R.id.fragmentText);
                textFragment.change("Fruit: "+fruits[position]);
                /*final FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.fragmentItemList, new TextFragment(), "Fruits :"+fruits[position]);
                ft.addToBackStack(null);
                ft.commit();*/
            }
        });

        return view;
    }
}