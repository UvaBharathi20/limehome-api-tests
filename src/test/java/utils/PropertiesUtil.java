package utils;

import common.TestBase;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;

public class PropertiesUtil {
    public static ResponseSpecification getSpec(){
        ResponseSpecBuilder builder = new ResponseSpecBuilder ();
        builder.expectContentType(ContentType.JSON);
        return builder.build ();
    }

    public static JsonPath getPropertiesResponse(){
        return given().
                when().
                get(TestBase.getPropertiesPath()).
                then().
                statusCode(200).
                and()
                .time(Matchers.lessThan(TestBase.getResponseTimeLimit())).
                extract().jsonPath();
    }
}
