package cucumber;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.ConfigurationParameter;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("cucumber")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "cucumber.steps")
@IncludeTags({"LogoutTest", "LoginTest"})
public class CucumberRunnerTest {
}
