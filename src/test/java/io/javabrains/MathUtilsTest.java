package io.javabrains;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;

@TestInstance(Lifecycle.PER_CLASS)
class MathUtilsTest {
	
	MathUtils mathUtils;
	TestReporter testReporte;
	TestInfo testInfo;
	
	@BeforeAll
	void init(TestReporter testReporter, TestInfo testInfo) {
		mathUtils = new MathUtils();
		this.testReporte = testReporter;
		this.testInfo = testInfo;
		System.out.println("Rodando");
	}
	
	
	@AfterEach
	void cleaningUp() {
		testReporte.publishEntry("Running " + testInfo.getDisplayName() + " the tag " + testInfo.getTags());
	}
	
	@Nested
	@DisplayName("add method")
	class AddTest{
		@Test
		@DisplayName("sum positive numbers")
		void return_sum_two_numbers() {
			assertEquals(2, mathUtils.add(1, 1));
		}
		
		@Test
		@DisplayName("sum negative numbers")
		void sum_negative_numbers() {
			assertEquals(-2, mathUtils.add(-1, -1));
		}
	}
	
	
	@Test
	@DisplayName("Calculate area of Circle")
	@Tag("Calculate")
	void return_area_of_circle(){
		assertEquals(314.1592653589793, mathUtils.calculateRadiusArea(10), "Should be a radius");
	}
	
	@Test
	@DisplayName("Subtract")
	@Tag("Calculate")
	void return_subtract_two_numbers() {
		assertEquals(4, mathUtils.subtract(8,4));
	}
	
	@Test
	@DisplayName("Divide")
	void return_number_divide() {
		assertEquals(2, mathUtils.divide(4,2));
		assertThrows(IllegalArgumentException.class, () -> mathUtils.divide(1, 0));
	}
	
	@Test
	@DisplayName("multiple tests with lambda")
	void return_multiply() {
		assertAll( 
					() -> assertEquals(2, mathUtils.divide(4,2)),
					() -> assertEquals(0, mathUtils.divide(0,2))
					);
	}

}
