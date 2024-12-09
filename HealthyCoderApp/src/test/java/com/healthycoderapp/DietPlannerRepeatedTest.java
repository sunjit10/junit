package com.healthycoderapp;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

// Extension of DietPlannerTest where here we want to repeat
// it multiple times by using @RepeatedTest(<Num Times>)
public class DietPlannerRepeatedTest {
    
    private DietPlanner dietPlanner;
    
    @BeforeEach
    void setup() {
	this.dietPlanner = new DietPlanner(20, 30, 50);
    }

    // Can also do: @RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
    @RepeatedTest(5)
    void should_ReturnCorrectDietPlan_When_CorrectCoder() {
	// arrange
	Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
	DietPlan expected = new DietPlan(2202, 110, 73, 275);
	
	// act
	DietPlan dietPlan = dietPlanner.calculateDiet(coder);
	
	// assert
	assertAll(
		  () -> assertEquals(expected.getCalories(), dietPlan.getCalories()),
		  () -> assertEquals(expected.getProtein(), dietPlan.getProtein()),
		  () -> assertEquals(expected.getFat(), dietPlan.getFat()),
		  () -> assertEquals(expected.getCarbohydrate(), dietPlan.getCarbohydrate())								    
		  );
    }
}
