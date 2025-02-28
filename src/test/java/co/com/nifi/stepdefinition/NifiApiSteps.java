package co.com.nifi.stepdefinition;

import co.com.nifi.tasks.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static co.com.nifi.utils.Constants.*;

public class NifiApiSteps {

    private Response response;

    @Given("qa consulta si nifi se esta ejecutando")
    public void flujoListo() {
        GetTokenApi.getTokenNifi();
        String statusNifi = GetStatusApi.getStatusNifi();
        Assertions.assertNotEquals(STATUS_NIFI_STOP, statusNifi);
    }

    @When("realiza la ejecucion del flujo parametrizado")
    public void iniciarFlujo() {
        response = StartNifiApi.startNifi();
        Assertions.assertEquals(STATUS_CODE_API, response.getStatusCode());
    }

    @When("realiza la consulta de nifi")
    public void validarEstadoFlujo() {
        String statusNifi = GetStatusApi.getStatusNifi();
        Assertions.assertEquals(STATUS_NIFI_OK, statusNifi);
    }

    @Then("espera que el flujo pueda terminar")
    public void esperarFlujoCompletar() {
        boolean terminado = ExecutionCyclesApis.waitNifiComplete();
        Assertions.assertTrue(terminado);
    }

    @Then("valida que el archivo csv fue creado y contenga los datos")
    public void validarArchivoSalida() throws Exception {
        Assertions.assertTrue(GenerateFileCSV.fileCreated());
    }
}
