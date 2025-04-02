package com.example.pamo_s24261;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class CaloriesFragment extends Fragment {
    private EditText etAge, etWeight, etHeight;
    private RadioGroup genderGroup;
    private Spinner activitySpinner;
    private Button btnCalculate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etAge = view.findViewById(R.id.etAge);
        etWeight = view.findViewById(R.id.etWeight);
        etHeight = view.findViewById(R.id.etHeight);
        genderGroup = view.findViewById(R.id.genderGroup);
        activitySpinner = view.findViewById(R.id.activitySpinner);
        btnCalculate = view.findViewById(R.id.btnCalculateCalories);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.activity_levels,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activitySpinner.setAdapter(adapter);

        btnCalculate.setOnClickListener(this::calculateCalories);
    }

    private void calculateCalories(View view) {
        String ageStr = etAge.getText().toString();
        String weightStr = etWeight.getText().toString();
        String heightStr = etHeight.getText().toString();
        int genderId = genderGroup.getCheckedRadioButtonId();

        if (TextUtils.isEmpty(ageStr) || TextUtils.isEmpty(weightStr) || TextUtils.isEmpty(heightStr) || genderId == -1) {
            Toast.makeText(requireContext(), "Wypełnij wszystkie pola!", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(ageStr);
        double weight = Double.parseDouble(weightStr);
        double height = Double.parseDouble(heightStr);

        boolean isMale = genderId == R.id.radioMale;

        double bmr;
        if (isMale) {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }

        String activityLevel = activitySpinner.getSelectedItem().toString();
        double multiplier = getActivityMultiplier(activityLevel);

        double calories = bmr * multiplier;

        Bundle bundle = new Bundle();
        bundle.putDouble("calories", calories);

        Navigation.findNavController(view).navigate(R.id.action_caloriesFragment_to_caloriesResultFragment, bundle);
    }

    private double getActivityMultiplier(String level) {
        switch (level) {
            case "Brak aktywności":
                return 1.2;
            case "Umiarkowana aktywność":
                return 1.55;
            case "Wysoka aktywność":
                return 1.9;
            default:
                return 1.2;
        }
    }
}
