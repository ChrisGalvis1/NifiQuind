package co.com.nifi.tasks;

import io.restassured.response.Response;

import java.util.List;

import static co.com.nifi.utils.Constants.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class GetStatusApi {

    static {
        useRelaxedHTTPSValidation(); // Desactiva la validación de certificados
    }

    public static String getStatusNifi() {
        Response response = given()
                .header("Authorization", "Bearer " + TOKEN_NIFI)
                .when()
                .get(BASE_URL_NIFI + "/flow/process-groups/" + ID_PROCESS_GROUP + "/status");

        String URLJSON = BASE_URL_NIFI + "/flow/process-groups/" + ID_PROCESS_GROUP + "/status";
        String ResponseBody = response.getBody().asString();
        System.out.println("La URL donde se consulta Nifi es: " + URLJSON);
        System.out.println("Codigo de respuesta: " + response.getStatusCode());
        System.out.println("Respuesta Nifi: " + ResponseBody);

        if (!ResponseBody.trim().startsWith("{")) {
            System.out.println("⚠️ La respuesta no es JSON, posiblemente sea un error HTML o texto plano.");
            return "ERROR";
        }
        List<String> estado = response.jsonPath().getList("processGroupStatus.aggregateSnapshot.processorStatusSnapshots.processorStatusSnapshot.runStatus");
        String status = estado.get(0);
        System.out.println("El Status de Nifi es: " + status);
        return status;
    }
}
