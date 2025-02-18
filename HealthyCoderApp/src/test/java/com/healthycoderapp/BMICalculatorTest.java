package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

// METHOD NAME:    should_<RETURNSTH>_When_<DOINGSTH>()
// WITHIN METHOD:  given...when...then OR arrange...act...assert
public class BMICalculatorTest {

    // Check something is true - assertTrue(true)
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
    
    // Check something is false - assertFalse(false)
    @Test
    void should_ReturnFalse_When_DietNotRecommended() {
	// arrange
	double weight = 50.0;
	double height = 1.92;
	
	// act
	boolean recommended = BMICalculator.isDietRecommended(weight, height);
	
	// assert
	assertFalse(recommended);
    }

    // Required: import org.junit.jupiter.api.function.Executable;
    @Test
    void should_ThrowException_When_HeightIsZero() {
	// arrange
	double weight = 50.0;
	double height = 0.0;
	
	// act
	Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
	
	// assert
	assertThrows(ArithmeticException.class, executable);
    }
    
    // Assert mutiple values - assertAll(() -> assertEquals(test1), () -> assertEquals(test2));
    @Test
    void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty() {
	// arrange
	List<Coder> coders = new ArrayList<>();
	coders.add(new Coder(1.80, 60.0));
	coders.add(new Coder(1.82, 98.0));
	coders.add(new Coder(1.82, 64.7));
	
	// act
	Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
	
	// assertAll will test the second one with Weight even if the first
	// call that checks for height fails for any reason
	assertAll(
	  () -> assertEquals(1.82, coderWorstBMI.getHeight()),
	  () -> assertEquals(98.0, coderWorstBMI.getWeight())
	);
    }

    // Test for Null -  assertNull(SomeObjectThatIsNull)
    @Test
    void should_ReturnNullWorstBMICoder_When_CoderListEmpty() {
	// arrange
	List<Coder> coders = new ArrayList<>();
	
	// act
	Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
	
	// assert
	assertNull(coderWorstBMI);
    }
    
    // Test for arrays - assertArrayEquals(array1, array2);
    @Test
    void should_ReturnCorrectBMIScoreArray_When_CoderListNotEmpty() {
	// arrange
	List<Coder> coders = new ArrayList<>();
	coders.add(new Coder(1.80, 60.0));
	coders.add(new Coder(1.82, 98.0));
	coders.add(new Coder(1.82, 64.7)); 
	
	double[] expectedValues = {18.52, 29.59, 19.53};

	// act
	double bmiScores[] = BMICalculator.getBMIScores(coders);
	
	// assert
	assertArrayEquals(expectedValues, bmiScores);
    }
}
