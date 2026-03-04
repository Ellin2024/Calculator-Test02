package sem4.cal.test.acceptance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;

import org.springframework.web.client.RestTemplate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions 
{
	private String server = System.getProperty("calculator.url", "http://localhost:8080"); // default
    private RestTemplate restTemplate = new RestTemplate();
    private String a;
    private String b;
    private String operator;
    private String result;

    @Given("^I have two numbers: (.*) and (.*) and (.*)$")
    public void i_have_two_numbers(String a, String b, String operator) 
    {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

    @When("^the calculator sums them$")
    public void the_calculator_sums_them() throws Exception 
    {
        // validate URL
        if (server == null || server.isEmpty()) {
            throw new IllegalArgumentException("System property 'calculator.url' is not set");
        }

        String urlString = String.format("%s/api/calculator/calculate?a=%s&b=%s", server, a, b);
        URI uri = new URI(urlString); // ensures URL is absolute
        result = restTemplate.getForObject(uri, String.class);
    }

    @Then("^I receive (.*) as a result$")
    public void i_receive_as_a_result(String expectedResult) 
    {
        assertEquals(expectedResult, result);
    }
}
