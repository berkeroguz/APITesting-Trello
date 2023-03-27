package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import stepdefinitions.hooks;

import static io.restassured.RestAssured.given;

public class ReusableMethods {

    public static String preparePathParameters(String givenPaths){
        String [] paths = givenPaths.split("/");
        StringBuilder tempPath = new StringBuilder("{");

        for ( int i =0 ; i<paths.length;i++){
            String key = "pp"+i;
            String value = paths[i].trim();
            hooks.specTrello.pathParam(key,value);

            tempPath.append(key+"}/{");
        }
        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));
        return tempPath.toString();
    }
}
