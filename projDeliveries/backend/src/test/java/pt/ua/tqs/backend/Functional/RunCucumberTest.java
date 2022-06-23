package pt.ua.tqs.backend.Functional;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("pt/ua/tqs/backend/Functional")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "pt.ua.tqs.backend.Functional")
class RunCucumberTest {
}
