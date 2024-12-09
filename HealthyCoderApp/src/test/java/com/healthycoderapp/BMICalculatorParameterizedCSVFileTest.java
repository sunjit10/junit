package com.healthycoderapp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public class BMICalculatorParameterizedCSVFileTest {

    @ParameterizedTest(name = "weight={0}, height={1}")
    @CsvFileSource(resources = "/diet-recommended-input-data.csv", numLinesToSkip=1)
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
