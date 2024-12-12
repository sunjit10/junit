package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;

// Using @Disabled to disable a specific test from being run.
// In the example below, the test will fail since it recommended is true
// But by Annotating it with @Disabled, the test will not run

// To run a single/specific test:
// mvn test -Dtest=BMICalculatorDisabledAnnotationTest
public class BMICalculatorDisabledAnnotationTest {

    @Test
    @Disabled
    void should_ReturnTrue_When_DietRecommended() {
	// arrange
	double weight = 89.0;
	double height = 1.72;
	
	// act
	boolean recommended = BMICalculator.isDietRecommended(weight, height);
	
	// assert
	assertFalse(recommended);
    }
}
