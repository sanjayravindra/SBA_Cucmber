package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="Feature"
		,glue= {"stepDefs"}
		,plugin = { "pretty", "junit:report/Cucumber.xml"} 
		
		)
public class FeesTest {

}

