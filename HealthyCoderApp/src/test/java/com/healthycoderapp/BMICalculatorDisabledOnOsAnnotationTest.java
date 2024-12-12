package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import static org.junit.jupiter.api.Assertions.*;

// Similar to @Disabled, @DisabledOnOS extends it so that we
// can control on which OS a test should run.
// The test below will not run on Windows platforms.
public class BMICalculatorDisabledOnOsAnnotationTest {

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void should_ReturnTrue_When_DietRecommended() {
	// arrange
	double weight = 89.0;
	double height = 1.72;
	
	// act
	boolean recommended = BMICalculator.isDietRecommended(weight, height);
	
	// assert
	assertTrue(recommended);
    }
}
