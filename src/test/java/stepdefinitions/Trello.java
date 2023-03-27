package stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.ReusableMethods;
import utilities.TestDataTrello;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class Trello extends TestDataTrello{

    public static String path;
    public static List<String> listOfCardId = new ArrayList<>();
    public static String listId;
    public static String choosenId;
    public static Response response;
    public static String boardID;

    @Given("set {string} path parameters")
    public void set_path_parameters(String givenPaths) {
        path = ReusableMethods.preparePathParameters(givenPaths);
    }

    @Given("set name of list as {string}")
    public void set_name_of_list_as(String name) {
        hooks.specTrello.queryParams("name",name,"idBoard",boardID);

    }
    @Given("save the response to create a new list")
    public void save_the_response_to_create_a_new_list() {
        response=postRequest(path);
        JsonPath jsonPath = response.jsonPath();
        listId=jsonPath.getString("id");
    }

    @Given("set name of board as {string}")
    public void set_name_of_board_as(String name) {
        hooks.specTrello.queryParam("name",name);
    }
    @Given("save the response to create a new board")
    public void save_the_response_to_create_a_new_board() {
        response = response=postRequest(path);
        JsonPath jsonPath = response.jsonPath();
        boardID=jsonPath.getString("id");
    }
    @Given("set name of card as {string}")
    public void set_name_of_card_as(String name) {
        hooks.specTrello.queryParams("name",name,"idList",listId);
        System.out.println("Listenin ıd'si ==" + listId);
    }
    @Given("save the response to create a new card")
    public void save_the_response_to_create_a_new_card() {
        response = response=postRequest(path);
        JsonPath jsonPath = response.jsonPath();
        listOfCardId.add(jsonPath.getString("id").toString());
    }

    @Given("wait for display")
    public void wait_for_display() throws InterruptedException {
        Thread.sleep(1000);
    }
    @Given("set new and description of card")
    public void set_new_and_description_of_card() {
        hooks.specTrello.queryParams("name","Updated List!","desc","I'm Here !");
    }
    @Given("randomly choose an id of cards and set path parameters")
    public void randomly_choose_an_id_of_cards_and_set_path_parameters() {
        Random random = new Random();
        choosenId = listOfCardId.get(random.nextInt(0,listOfCardId.size()));
        hooks.specTrello.pathParams("pp1","cards","pp2",choosenId);
        path="/{pp1}/{pp2}";


    }
    @Given("update choosen card")
    public void update_choosen_card() {
        response = given().headers("Accept","application/json").
                spec(hooks.specTrello).
                put(path);
    }
    @Given("set the path of card to be deleted")
    public void set_the_path_of_card_to_be_deleted() {

        hooks.specTrello.pathParams("pp1","cards","pp2",listOfCardId.get(0));
        listOfCardId.remove(0);
        path="/{pp1}/{pp2}";

    }
    @Given("delete card")
    public void delete_card() {
        response=deleteRequest(path);

    }


    @Given("set path of board to be deleted")
    public void set_path_of_board_to_be_deleted() {
        System.out.println("son viraj <>>> "+boardID);
        hooks.specTrello.pathParams("pp1","boards","pp2",boardID);
        path="/{pp1}/{pp2}";
    }
    @Given("delete board")
    public void delete_board() {
        response=deleteRequest(path);
    }
    @Given("verify status code successfully")
    public void verify_status_code_successfully() {
        Assert.assertEquals(successfullyStatusCode,response.getStatusCode());
    }

}
