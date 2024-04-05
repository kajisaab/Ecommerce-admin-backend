package com.ecommerce.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootTest
class EcommerceApplicationTests {

	Calculator calculatorTest = new Calculator();

	@Test
	void itShouldAddNumbers() {
		// given
		int numberOne = 20;
		int numberTwo = 30;

		// when
		int result = calculatorTest.add(numberOne, numberTwo);

		// then
		int expected = 50;
		assertThat(result).isEqualTo(expected);
	}

	class Calculator {
		int add(int a, int b){
			return a + b;
		}
	}

}
