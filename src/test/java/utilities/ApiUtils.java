package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static Hooks.Api.spec;
import static Hooks.Api.token;
import static io.restassured.RestAssured.given;

public class ApiUtils {
    public static String generateToken(){

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();

        spec.pathParams("pp1","api","pp2","gettoken");

        Map<String,Object> dataCredentials = new HashMap<>();

        dataCredentials.put("email",ConfigReader.getProperty("adminUserName"));
        dataCredentials.put("password",ConfigReader.getProperty("password"));

        Response response = given()
                .contentType(ContentType.JSON)
                .spec(spec)
                .headers(
                        "Authorization","Bearer "+token, // gerekli authorization bilgisi giriş satırı
                        "Content-Type", ContentType.JSON,  // gönderdiğim bilgilerJson formatında
                        "Accept",ContentType.JSON       // bana cevabı ( response) Json formatında gönder
                )
                .when()
                .body(dataCredentials)
                .post("/{pp1}/{pp2}");

        response.prettyPrint();
        JsonPath jsonResponse = response.jsonPath();

        String token = jsonResponse.getString("data.token");

        return token;
    }
}
