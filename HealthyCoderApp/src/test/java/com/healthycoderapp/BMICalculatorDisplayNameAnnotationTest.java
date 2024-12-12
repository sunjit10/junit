package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

// Using @DisplayName, it will show that customized name
// vs showing the (default) method name
public class BMICalculatorDisplayNameAnnotationTest {

    @Test
    @DisplayName(">>>>>> sample method display name")
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
