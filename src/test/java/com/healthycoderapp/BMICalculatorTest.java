package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {
	
	@Test
	void should_ReturnTrue_When_DietRecommended() {
		
		// given
		double weight = 81.2;
		double height = 1.65;
		
		// when
		boolean recommended = BMICalculator.isDietRecommended(weight, height);
		
		// then
		assertTrue(recommended);
	}
	
	@Test
	void should_ReturnFalse_When_DietNotRecommended() {
		
		// given
		double weight = 50.0;
		double height = 1.92;
		
		// when
		boolean recommended = BMICalculator.isDietRecommended(weight, height);
		
		// then
		assertFalse(recommended);
	}
	
	@Test
	void should_ThrowArithmeticException_When_HeightZero() {
		
		// given
		double weight = 50.0;
		double height = 0.0;
		
		// when
		Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
		
		// then
		assertThrows(ArithmeticException.class, executable);
	}
	
	@Test
	void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty() {
		
		// given
		List<Coder> coders = new ArrayList<>();
		coders.add(new Coder(1.80, 60.0));
		coders.add(new Coder(1.82, 98.0));
		coders.add(new Coder(1.82, 64.7));
		
		// when
		Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
		
		// then
		// Here, if first assertion fails, then second would never be executed.
		// So, we won't get to know if our first assertion only failed or both of them
		assertEquals(1.82, coderWorstBMI.getHeight());
		assertEquals(98.0, coderWorstBMI.getWeight());
	}
	
}