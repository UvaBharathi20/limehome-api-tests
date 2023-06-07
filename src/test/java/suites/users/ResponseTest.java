package suites.users;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.TestBase;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.PropertiesUtil;

import java.io.File;
import java.io.IOException;


public class ResponseTest extends TestBase {
    @BeforeClass
    public void setUp() {
        Reporter.log("Set Up", true);
    }
    @Test
    public void validatePropertiesResponse() throws IOException {
        Reporter.log("get response",true);
        JsonPath res = PropertiesUtil.getPropertiesResponse();
        Assert.assertEquals(res.get("success"), Boolean.TRUE);
        Assert.assertEquals(res.get("message"), "Successfully fetched property.");
        Assert.assertEquals(res.get("message"), "Successfully fetched property.");
        int val = 129;
        Assert.assertEquals((int)res.get("payload.id"), 129);
        Assert.assertEquals(res.get("payload.name"), "aachen vereinsstraße");
        Assert.assertEquals(res.get("payload.description"), "In the middle of Aachen's city center you will find our limehome Aachen Vereinsstraße in a quiet side street. Due to the convenient location, you will find the perfect place to escape the hustle and bustle of the city center and start the day relaxed. The connection with public transport could not be better, as the main train station is only 270 m away.");
        //Assert.assertEquals(res.get("payload.location"), "{\"lat\":50.7697713,\"lng\":6.0931558,\"city\":\"Aachen\",\"postalCode\":\"52062\",\"countryCode\":\"DE\",\"addressLine1\":\"Vereinsstraße 2\",\"countryName\":\"Germany\"}");
        /*
        coed to validate full json. But a pjo has to be created.
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/test/resources/golden_set_properties.json");
        JsonNode actualObj1 = mapper.readTree(file);
        Assert.assertEquals(actualObj1,res.get("payload"));
         */
    }
}
