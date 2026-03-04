package sem4.cal.test.acceptance;


import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.spring.CucumberContextConfiguration;
import sem4.cal.test.CalculatorApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = CalculatorApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberSpringConfiguration 
{
	
}
