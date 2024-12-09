package com.healthycoderapp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

// ParameterizedTest allows you to run with multiple values one by one
public class BMICalculatorParameterizedTest {

    @ParameterizedTest
    @ValueSource(doubles = {90.0, 89.0, 95.0, 110.0})
    void should_ReturnTrue_When_DietRecommended(Double coderWeight) {
	// arrange
	double weight = coderWeight;
	double height = 1.72;
	
	// act
	boolean recommended = BMICalculator.isDietRecommended(weight, height);
	
	// assert
	assertTrue(recommended);
    }

    @ParameterizedTest
    @CsvSource(value = {"89.0, 1.72", "95.0, 1.75", "110.0, 1.78"})
    void should_ReturnTrue_When_DietRecommended(Double coderWeight, Double coderHeight) {
	// arrange
	double weight = coderWeight;
	double height = coderHeight;
	
	// act
	boolean recommended = BMICalculator.isDietRecommended(weight, height);
	
	// assert
	assertTrue(recommended);
    }


    // Advantage here is the output values will be labelled as weight=89.0, height=1.72
    // vs 89.0, 1.72
    @ParameterizedTest(name = "weight={0}, height={1}")
    @CsvSource(value = {"89.0, 1.72", "95.0, 1.75", "110.0, 1.78"})
    void should_ReturnTrue_When_DietRecommended2(Double coderWeight, Double coderHeight) {
	// arrange
	double weight = coderWeight;
	double height = coderHeight;
	
	// act
	boolean recommended = BMICalculator.isDietRecommended(weight, height);
	
	// assert
	assertTrue(recommended);
    }
}
