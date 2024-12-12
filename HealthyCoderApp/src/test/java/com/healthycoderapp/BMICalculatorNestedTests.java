package com.healthycoderapp;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

// This class is very similar to the original BMICalculatorTest
// with the difference being that we have used the @Nested to group
// similar methods together.
// There are 3 inner classes:  IsDietRecommendedTests, FindCoderWithWorstBMITests
// and GetBMIScoresTests

// Note: You can have multiple hierarchies within @Nested and also each can have
// their own @Before/@After etc
public class BMICalculatorNestedTests {
    
    @Nested
    class IsDietRecommendedTests {
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
    }

    @Nested
    class FindCoderWithWorstBMITests {
	// Test for Null using assertNull
	@Test
	void should_ReturnNullWorstBMICoder_When_CoderListEmpty() {
	    // arrange
	    List<Coder> coders = new ArrayList<>();
	    
	    // act
	    Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
	    
	    // assert
	    assertNull(coderWorstBMI);
	}
	
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
    }

    @Nested
    class GetBMIScoresTests {
	// Test for arrays
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
}

/*
[INFO] Running com.healthycoderapp.BMICalculatorNestedTests
[INFO] Running com.healthycoderapp.BMICalculatorNestedTests$GetBMIScoresTests
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.004 s -- in com.healthycoderapp.BMICalculatorNestedTests$GetBMIScoresTests
[INFO] Running com.healthycoderapp.BMICalculatorNestedTests$FindCoderWithWorstBMITests
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.009 s -- in com.healthycoderapp.BMICalculatorNestedTests$FindCoderWithWorstBMITests
[INFO] Running com.healthycoderapp.BMICalculatorNestedTests$IsDietRecommendedTests
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.019 s -- in com.healthycoderapp.BMICalculatorNestedTests$IsDietRecommendedTests
[INFO] Tests run: 0, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.073 s -- in com.healthycoderapp.BMICalculatorNestedTests
*/
