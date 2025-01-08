package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AdditionTest {

    @Test
    public void shouldAdd() {
	// arrange
	int num1 = 20;
	int num2 = 30;

	// act
	int expectedSum = 50;
	boolean isSame = Addition.add(num1, num2) == 50;

	// assert
	assertTrue(isSame);

    }
}
