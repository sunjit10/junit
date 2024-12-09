package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;

public class BMICalculatorBeforeAfterTest {
    
    @BeforeAll
    static void beforeAll() {
	System.out.println("Before All Unit Tests");
    }

    @AfterAll
    static void afterAll() {
	System.out.println("After All Unit Tests");
    }

    @Test
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
