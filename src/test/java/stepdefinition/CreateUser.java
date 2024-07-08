package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utility.APIAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CreateUser {

    //Declare global variables like request ,endpoint and response
    private RequestSpecification request;
    private Response response;
    private String endpoint="";
    APIAdapter apiAdapter = new APIAdapter();
    @Given("^User is ready with required details like endpoint \"([^\"]*)\"$")
    public void user_is_ready_with_required_details_like_endpoint(String endpoint) throws Throwable {
        //Read endpoint
       this.endpoint = endpoint;
    }

    @When("^user creates a required payload with fields like \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and sends request$")
    public void user_creates_a_required_payload_with_fields_like_and_sends_request(String name, String id, String job, String createdAT) throws Throwable {
        RestAssured.baseURI = endpoint;
        //create payload by calling method
      //  String strPayload = apiAdapter.createPayload(name, id, job, createdAT);
        String strPayload = new String(Files.readAllBytes(Paths.get("src/test/java/payloads/createUserPayload")));
        System.out.println("Request payload: "+strPayload);
        request = given();
        request.header("Content-Type","application/json").body(strPayload);
        //post request
        response = request.post();
        System.out.println("Response: "+response.prettyPrint());
    }

    @Then("^Verify that user is created using status code \"([^\"]*)\" and one of the response field \"([^\"]*)\"$")
    public void verify_that_user_is_created_using_status_code_and_one_of_the_response_field(int statusCode, String name) throws Throwable {
        //Verify status code
        Assert.assertEquals("Status code is not correct",statusCode,response.getStatusCode());
        //Verify response field value
        String strName = response.jsonPath().get("Name");
        Assert.assertEquals("Required field is not correct in the response",name, strName);

        //Get details
        given().when().get("https://reqres.in/api/users/2").then().assertThat().statusCode(200);
        given().when().get("https://reqres.in/api/users/2").prettyPrint();
    }
}
