package shirt;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"not @ignore"}
)
public class RunCukesTest {
    @BeforeClass()
    public static void setSystemProperties() {
        System.setProperty("log4j.configurationFile", "./log4j2.xml");
    }
}