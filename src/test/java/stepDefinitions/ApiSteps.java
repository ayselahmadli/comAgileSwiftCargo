package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import static Hooks.Api.spec;
import static Hooks.Api.token;
import static io.restassured.RestAssured.given;

public class ApiSteps {

    String fullPath;
    Response response;

    @Given("Admin sets the parameters in the path {string}.")
    public void admin_sets_the_parameters_in_the_path(String rawPaths) {
        String[] paths = rawPaths.split("/");   //  ["api","visitorsPurposeList"]

        StringBuilder tempParam = new StringBuilder("/{");

        for (int i = 0; i < paths.length; i++) {
            String key = "pp" + (i + 1);
            String value = paths[i].trim();
            spec.pathParam(key, value);

            tempParam.append(key + "}/{");
        }
        tempParam.deleteCharAt(tempParam.lastIndexOf("{"));
        tempParam.deleteCharAt(tempParam.lastIndexOf("/"));

        fullPath = tempParam.toString();
    }

    @Given("send Get request for adminHubList")
    public void send_get_request_for_admin_hub_list() {
        response = given().spec(spec).headers("Authorization","Bearer " + token).when().get(fullPath);

    }
    @Given("verifies that the return response for the adminHubList Api succesfull")
    public void verifies_that_the_return_response_for_the_admin_hub_list_api_succesfull() {
        response.then().assertThat().statusCode(200).body("message", Matchers.equalTo("Success"));
    }


}
