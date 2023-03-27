package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import stepdefinitions.hooks;

import static io.restassured.RestAssured.given;

public class TestDataTrello {
    public int successfullyStatusCode=200;
    public String contentType="application/json";
    public Response deleteRequest(String path){
        Response response = given().contentType(ContentType.JSON).spec(hooks.specTrello).delete(path);
        return response;
    }

    public Response postRequest(String path){
        Response response = given().contentType(ContentType.JSON).spec(hooks.specTrello).post(path);
        return response;
    }


}
