package com.example.pamo_s24261;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pamo_s24261.adapter.ShoppingListAdapter;
import com.example.pamo_s24261.model.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListFragment extends Fragment {

    private RecyclerView rvShopping;
    private ShoppingListAdapter adapter;
    private List<ShoppingItem> itemList;

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shopping_list,
                container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvShopping = view.findViewById(R.id.rvShopping);
        rvShopping.setLayoutManager(new LinearLayoutManager(requireContext()));

        itemList = new ArrayList<>();
        itemList.add(new ShoppingItem("Rukola"));
        itemList.add(new ShoppingItem("Jajko gotowane"));
        itemList.add(new ShoppingItem("Pomidorki cherry"));
        itemList.add(new ShoppingItem("Sos winegret"));

        adapter = new ShoppingListAdapter(itemList);
        rvShopping.setAdapter(adapter);
    }
}
