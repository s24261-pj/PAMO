package com.example.pamo_s24261.service;

public class BMICalculatorService {

    public double computeBMI(double weight, double height) {
        if (height > 3) {
            height /= 100.0;
        }
        return weight / (height * height);
    }

    public String getBMIStatus(double bmi) {
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
