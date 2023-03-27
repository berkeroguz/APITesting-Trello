package stepdefinitions;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;


public class hooks {
    public static RequestSpecification specTrello;

    @Before
    public void setUpBaseUrl(){
        specTrello = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("trelloUrl")).build();
        specTrello.queryParams("key",ConfigReader.getProperty("apikey"),"token",ConfigReader.getProperty("tokenApi"));
    }
}
