package cucumberTests.PedasysWrittenTest.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/cucumberTests/PedasysWrittenTest/features/menuLinks.feature",
		glue= "cucumberTests/PedasysWrittenTest/stepDefinitions"
		
		)

public class testRunner {
	
	

}
