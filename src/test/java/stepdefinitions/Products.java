package stepdefinitions;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;
import org.json.simple.JSONObject;

public class Products {

    public int statusCode;
    public RequestSpecification httpRequest;
    public Response response;
    public ResponseBody responseBody;
    public JSONObject requestParams;
    public JsonPath jsonPath;


    @Given("I hit the url of get products api endpoint")
    public void i_hit_the_url_of_get_products_api_endpoint() {
        RestAssured.baseURI = "http://fakestoreapi.com/";
    }

    @When("I pass the url of products in the request")
    public void i_pass_the_url_of_products_in_the_request() {
        httpRequest = RestAssured.given();
        response = httpRequest.get("products");
    }

    @Then("I receive the response code as {int}")
    public void i_receive_the_response_code_as(int responseCode) {
        statusCode = response.getStatusCode();
        assertEquals(responseCode, statusCode);
    }

    @Then("I verify that the rate of the first product is {}")
    public void iVerifyThatTheRateOfTheFirstProductIsRate(String rate) {
        responseBody = response.getBody();

        String responseBodyString = responseBody.asString();

        JsonPath jsonPath = response.jsonPath();

        String s = jsonPath.getJsonObject("rating[0].rate").toString();

        assertEquals(s, rate);

        System.out.println("Rate = " + s);
        System.out.println("GET successful.\n");
    }

    @Given("I hit the url of post products api endpoint")
    public void iHitTheUrlOfPostProductsApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = RestAssured.given();

    }

    @And("I pass the request body of product title {}")
    public void iPassTheRequestBodyOfProductTitleProductTitle(String productTitle) {

        requestParams = new JSONObject();
        requestParams.put("title", productTitle);
        requestParams.put("price", "15.00");
        requestParams.put("description", "lorem ipsum set");
        requestParams.put("image", "https://i.pravatar.cc");
        requestParams.put("category", "electronics");

        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.post("products");
        jsonPath = response.jsonPath();
        ResponseBody responseBody = response.getBody();

        System.out.println(response.getStatusCode());
        System.out.println(responseBody.asString());
        System.out.println("POST successful.\n");

    }

    @Then("I receive the response body with id as {}")
    public void iReceiveTheResponseBodyWithIdAsId(String id) {
        String s = jsonPath.getJsonObject("id").toString();
        assertEquals(s, id);
    }

    @When("I pass the url of products in the request with {}")
    public void iPassTheUrlOfProductsInTheRequestWithProductNumber(int productNumber) {
        httpRequest = RestAssured.given();

        requestParams = new JSONObject();
        requestParams.put("title", "Shoes");
        requestParams.put("price", "15.00");
        requestParams.put("description", "lorem ipsum set");
        requestParams.put("image", "https://i.pravatar.cc");
        requestParams.put("category", "electronics");
        httpRequest.body(requestParams.toJSONString());

        response = httpRequest.put("products/" + productNumber);
        jsonPath = response.jsonPath();
        ResponseBody responseBody = response.getBody();

        System.out.println(response.getStatusCode());
        System.out.println(responseBody.asString());
        System.out.println("PUT successful.\n");
    }

    @Given("I hit the url of delete products api endpoint")
    public void iHitTheUrlOfDeleteProductsApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = RestAssured.given();
    }

    @When("I pass the url of products in the delete request with {}")
    public void iPassTheUrlOfProductsInTheDeleteRequestWithProductNumber(int productNumber) {
        httpRequest = RestAssured.given();
        response = httpRequest.delete("products/" + productNumber);
        jsonPath = response.jsonPath();
        ResponseBody responseBody = response.getBody();

        System.out.println(response.getStatusCode());
        System.out.println(responseBody.asString());
        System.out.println("DELETE successful.\n");
    }
}
