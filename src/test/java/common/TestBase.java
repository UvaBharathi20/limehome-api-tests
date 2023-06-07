package common;

import io.restassured.RestAssured;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

public class TestBase {

    public String runId = String.valueOf(System.currentTimeMillis()).substring(5, 12);
    public String uname;
    public String pwd;

    @BeforeClass
    public void beforeClass(ITestContext context) {
        //RestAssured.baseURI = context.getCurrentXmlTest().getParameter("BaseURI");
        Reporter.log("API test for" + RestAssured.baseURI, true);
    }
    private static Properties properties;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) {
        setTestProperties();
        setEnvironmentForTest();
    }

    protected void setTestProperties() {
        properties = new Properties();
        properties.put("baseURI", "https://api.limehome.com");
        properties.put("propertiesPath", "/properties/v1/public/properties/129");
        System.getenv().forEach((key, value) -> properties.setProperty(key, value));
        properties.put("responseTimeLimit", "5000");
    }

    public static void setEnvironmentForTest() {
        RestAssured.reset();
        RestAssured.baseURI = properties.getProperty("baseURI");
    }

    public static String getAccessToken() {
        return "Bearer " + properties.getProperty("accessToken");
    }

    public static String getPropertiesPath() {
        return properties.getProperty("propertiesPath");
    }


    public static Long getResponseTimeLimit() {
        return Long.parseLong(properties.getProperty("responseTimeLimit"));
    }


}
