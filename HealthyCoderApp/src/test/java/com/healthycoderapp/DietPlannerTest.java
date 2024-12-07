package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

public class DietPlannerTest {

    private DietPlanner dietPlanner;
    
    @BeforeEach
    void setup() {
	this.dietPlanner = new DietPlanner(20, 30, 50);
    }

    @AfterEach
    void afterEach() {
	System.out.println("Wrapped up Unit Tests");
    }

    @Test
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
