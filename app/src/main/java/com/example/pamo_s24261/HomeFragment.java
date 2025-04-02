package com.example.pamo_s24261;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnBmi = view.findViewById(R.id.btnBMI);
        Button btnCalories = view.findViewById(R.id.btnCalories);

        btnBmi.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_calculatorFragment));

        btnCalories.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_caloriesFragment));
    }

}
