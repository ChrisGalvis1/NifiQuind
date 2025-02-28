package co.com.nifi.tasks;

import io.restassured.response.Response;

import static co.com.nifi.utils.Constants.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class GetTokenApi {

    static {
        useRelaxedHTTPSValidation(); // Desactiva la validación de certificados
    }

    public static void getTokenNifi() {
        Response tokenResponse = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("username", USER_NIFI)
                .formParam("password", PASSWORD_NIFI)
                .post(BASE_URL_NIFI + "/access/token");
        TOKEN_NIFI = tokenResponse.getBody().asString();
        System.out.println("El Token de Nifi es: " + TOKEN_NIFI);
    }

    public static void tokenAuthorization() {
        if (TOKEN_NIFI == null) {
            getTokenNifi();
        }
    }
}
