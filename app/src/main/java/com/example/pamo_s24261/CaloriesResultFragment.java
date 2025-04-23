package com.example.pamo_s24261;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class CaloriesResultFragment extends Fragment {
    private double calories = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calories_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvCalories = view.findViewById(R.id.tvCaloriesResult);
        Button btnRecipes = view.findViewById(R.id.btnSeeRecipes);

        Bundle args = getArguments();
        if (args != null) {
            calories = args.getDouble("calories", 0);
            @SuppressLint("DefaultLocale") String result = String.format("Twoje dzienne zapotrzebowanie:\n%.0f kcal", calories);
            tvCalories.setText(result);
        }

        btnRecipes.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putDouble("calories", calories);
            Navigation.findNavController(v).navigate(R.id.action_caloriesResultFragment_to_recipesFragment, bundle);
        });
    }
}
