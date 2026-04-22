package sem4.cal.test.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService 
{
	@Cacheable(value= "sum")
	public Integer add(int a,  int b) 
	{
		// TODO Auto-generated method stub
		try {
			System.out.print("loading . . . . .");
			Thread.sleep(3000);
			System.out.print("End . . . . .");
	        
	        
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return a + b ;
		
	}

	
	

}
