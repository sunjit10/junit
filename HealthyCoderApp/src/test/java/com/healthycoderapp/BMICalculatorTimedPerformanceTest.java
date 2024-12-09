package com.healthycoderapp;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// With assertTimeout, I can specify a time limit within which a test should complete
// In this case I have set it to 50ms but that can be adjusted based on machine resources
public class BMICalculatorTimedPerformanceTest {

    @Test
    void should_ReturnCoderWithWorstBMIIn50Ms_When_CoderListHas10000Elements() {
	// arrange
	List<Coder> coders = new ArrayList<>();
	for (int i = 0; i < 10000; i++) {
	    coders.add(new Coder(1.0 + i, 10.0 + i));
	}
	
	// act
	Executable executable = () -> BMICalculator.findCoderWithWorstBMI(coders);
	
	// assert
	assertTimeout(Duration.ofMillis(50), executable);
    }
}
