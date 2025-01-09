package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import static org.junit.jupiter.api.Assertions.*;

// This shows how to skip a test
public class BMICalculatorSkippedTest {

    private String environment = "dev";

    @Test
    void should_ReturnTrue_When_DietRecommended() {

	// Note: It is assumeTrue, NOT assertTrue
	assumeTrue(this.environment.equals("prod"));

	// arrange
	double weight = 89.0;
	double height = 1.72;
	
	// act
	boolean recommended = BMICalculator.isDietRecommended(weight, height);
	System.out.println("BMICalculatorSkippedTest: recommended: " + recommended);
	
	// assert
	assertTrue(recommended);
    }
}
