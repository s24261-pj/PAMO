package com.example.pamo_s24261;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class CalculatorFragment extends Fragment {
    private static final String KEY_BMI = "BMI";
    private static final String KEY_STATUS = "STATUS";

    private EditText etWeight;
    private EditText etHeight;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        etWeight = view.findViewById(R.id.etWeight);
        etHeight = view.findViewById(R.id.etHeight);
        Button btnCalculate = view.findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(this::calculateBMI);

        return view;
    }

    private void calculateBMI(View view) {
        final String weightStr = etWeight.getText().toString();
        final String heightStr = etHeight.getText().toString();

        if (TextUtils.isEmpty(weightStr) || TextUtils.isEmpty(heightStr)) {
            Toast.makeText(requireContext(), "Wypełnij wszystkie pola!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            final double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr);

            final double bmi = computeBMI(weight, height);
            final String status = getBMIStatus(bmi);

            Bundle bundle = new Bundle();
            bundle.putDouble(KEY_BMI, bmi);
            bundle.putString(KEY_STATUS, status);

            Navigation.findNavController(view)
                    .navigate(R.id.action_calculatorFragment_to_resultFragment, bundle);
        } catch (NumberFormatException e) {
            Toast.makeText(requireContext(), "Podaj prawidłowe dane!", Toast.LENGTH_SHORT).show();
        }
    }

    private double computeBMI(double weight, double height) {
        if (height > 3) {
            height /= 100.0;
        }
        return weight / (height * height);
    }

    private String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "niedowaga";
        } else if (bmi < 25) {
            return "optimum";
        } else if (bmi < 30) {
            return "nadwaga";
        } else {
            return "otyłość";
        }
    }
}
