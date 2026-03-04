package sem4.cal.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sem4.cal.test.service.CalculatorService;


@RestController
@RequestMapping("/api/calculator")
public class CalculatorController 
{
	@Autowired
	private CalculatorService calculatorService;
	
	@GetMapping("/calculate")
    public Integer calculate(
            @RequestParam Integer a,
            @RequestParam Integer b

    ) 
	{
        return calculatorService.add(a, b);
    }
}
