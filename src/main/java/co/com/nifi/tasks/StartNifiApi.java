package co.com.nifi.tasks;

import io.restassured.response.Response;

import static co.com.nifi.utils.Constants.*;
import static io.restassured.RestAssured.given;

public class StartNifiApi {

    public static Response startNifi() {
        Response reponse = given()
                .header("Authorization", "Bearer " + TOKEN_NIFI)
                .header("Content-Type", "application/json")
                .body("{\"id\": \"" + ID_PROCESS_GROUP + "\", \"state\": \"RUNNING\"}")
                .when()
                .put(BASE_URL_NIFI + "/flow/process-groups/" + ID_PROCESS_GROUP);
        System.out.println("LA URL ES.....:" + BASE_URL_NIFI + "/flow/process-groups/" + ID_PROCESS_GROUP);
        return reponse;
    }
}
