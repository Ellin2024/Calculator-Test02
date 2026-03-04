package sem4.cal.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import sem4.cal.test.service.CalculatorService;


class CalculatorApplicationTests 
{
	private final CalculatorService calculatorTest = new CalculatorService();
	

    @Test
    void shouldReturnTotalSum() {
        Integer result = calculatorTest.add(2, 4);
        assertEquals("6.0", result);
    }

    @Test
    void shouldReturnErrorForInvalidInput() {
        Integer result = calculatorTest.add(9, 4);
        assertEquals("Error: Inputs must be valid numbers", result);
    }
	
	
	

    

	

}
