import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(strict = true,
features = {"C:/testingproject/src/test/java/Features/BorrowingCalculator.feature"},
plugin = {"json:target/cucumber-parallel/1.json"},
monochrome = true,
tags = {"@smoke"},
glue = { "steps" })
public class Parallel01IT extends AbstractTestNGCucumberTests {
}
