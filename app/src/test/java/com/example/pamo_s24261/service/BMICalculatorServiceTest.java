package com.example.pamo_s24261.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BMICalculatorServiceTest {

    private BMICalculatorService bmiService;

    @Before
    public void setUp() {
        bmiService = new BMICalculatorService();
    }

    @Test
    public void testComputeBMI_withHeightInMeters() {
        double bmi = bmiService.computeBMI(70, 1.75);
        assertEquals(22.86, bmi, 0.01);
    }

    @Test
    public void testComputeBMI_withHeightInCentimeters() {
        double bmi = bmiService.computeBMI(70, 175);
        assertEquals(22.86, bmi, 0.01);
    }

    @Test
    public void testGetBMIStatus_underweight() {
        String status = bmiService.getBMIStatus(17.0);
        assertEquals("niedowaga", status);
    }

    @Test
    public void testGetBMIStatus_optimum() {
        String status = bmiService.getBMIStatus(22.0);
        assertEquals("optimum", status);
    }

    @Test
    public void testGetBMIStatus_overweight() {
        String status = bmiService.getBMIStatus(27.0);
        assertEquals("nadwaga", status);
    }

    @Test
    public void testGetBMIStatus_obese() {
        String status = bmiService.getBMIStatus(32.0);
        assertEquals("otyłość", status);
    }
}
