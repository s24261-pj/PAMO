package com.example.pamo_s24261;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {
    private static final String KEY_BMI = "BMI";
    private static final String KEY_STATUS = "STATUS";

    private TextView tvResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        tvResult = view.findViewById(R.id.tvResult);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle arguments = getArguments();

        if (arguments != null) {
            double bmi = arguments.getDouble(KEY_BMI, 0);
            String status = arguments.getString(KEY_STATUS, "");

            @SuppressLint("DefaultLocale") String resultText = String.format("BMI: %.2f\nStatus: %s", bmi, status);
            tvResult.setText(resultText);
        }
    }
}
