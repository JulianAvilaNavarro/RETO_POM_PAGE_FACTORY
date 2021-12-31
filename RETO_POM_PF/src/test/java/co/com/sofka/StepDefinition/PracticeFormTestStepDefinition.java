package co.com.sofka.StepDefinition;

import co.com.sofka.model.PracticeFormModel;
import co.com.sofka.page.PracticeFormPage;
import co.com.sofka.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTestStepDefinition extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(PracticeFormTestStepDefinition.class);
    private PracticeFormModel cliente;
    private PracticeFormModel cliente2;
    private PracticeFormPage practiceFormPage;
    private static final String ASSETION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados: %s";
    //Background
    @Given("El cliente se encuentra en la pagina de zonafit")
    public void el_cliente_se_encuentra_en_la_pagina_de_zonafit() {

        try{
            generalSetup();
            LOGGER.info("Configuración del driver lista.");
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(),exception);
        }

    }
    //Escenario 1
    @When("el cliente escoge el producto y llena su formulario")
    public void el_cliente_escoge_el_producto_y_llena_su_formulario() {
        try{
        generarComprador();
        practiceFormPage = new PracticeFormPage(cliente, super.driver);
        practiceFormPage.fillFieldsScenario1();
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(),exception);
        }
    }

    @Then("la pagina debera mostrar un mensaje indicando que fue pedido el producto")
    public void la_pagina_debera_mostrar_un_mensaje_indicando_que_fue_pedido_el_producto() {
        try{
            Assertions.assertEquals(
                    expectedOutcomeForMandatoryFields().toString(),
                    practiceFormPage.isRegistrationDone().toString(),
                    String.format(ASSETION_EXCEPTION_MESSAGE, messageForMandatoryFields())
            );
            LOGGER.info("Comparacion completa");
            quiteDriver();
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(),exception);
        }
    }
    //Escenario 2
    @When("el cliente selecciona los productos que desea comprar y llena el formulario")
    public void el_cliente_selecciona_los_productos_que_desea_comprar_y_llena_el_formulario() {
        try{
            generarComprador2();
            practiceFormPage = new PracticeFormPage(cliente2, super.driver);
            practiceFormPage.fillFieldsScenario2();
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(),exception);
        }

    }

    @Then("la pagina debera mostrar un mensaje indicando que fueron pedidos los productos")
    public void la_pagina_debera_mostrar_un_mensaje_indicando_que_fueron_pedidos_los_productos() {

        try{
            Assertions.assertEquals(
                    expectedOutcomeForMandatoryFields().toString(),
                    practiceFormPage.isRegistrationDone().toString(),
                    String.format(ASSETION_EXCEPTION_MESSAGE, messageForMandatoryFields())
            );
            LOGGER.info("Comparacion completa");
            quiteDriver();
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.warn(exception.getMessage(),exception);
        }

    }

    private void generarComprador() {
        cliente = new PracticeFormModel();
        cliente.setNumeroCedula("1110547963");
        cliente.setEmail("maria.ramirez@gmail.com");
        cliente.setNombre("Maria");
        cliente.setApellido("Ramirez");
        cliente.setDepartamento("Tolima");
        cliente.setCiudad("Ibagué");
        cliente.setDireccion("Avenida siempre viva calle falsa 123");
        cliente.setDireccioncomplementaria("Casa 1");
        cliente.setCelular("3101234569");
        cliente.setAnotaciones("Favor avisar con antelación la llegada del pedido");

    }


    private void generarComprador2() {
        cliente2 = new PracticeFormModel();
        cliente2.setNumeroCedula("1110547989");
        cliente2.setEmail("carlos.marulanda@gmail.com");
        cliente2.setNombre("Carlos");
        cliente2.setApellido("Marulanda");
        cliente2.setDepartamento("Antioquia");
        cliente2.setCiudad("Medellin");
        cliente2.setDireccion("Int 7 apto 403 Conjunto mediano");
        cliente2.setDireccioncomplementaria("Bloque 3");
        cliente2.setCelular("3101234568");
        cliente2.setAnotaciones("Favor dejar el pedido en porteria");

    }

    public List<String> expectedOutcomeForMandatoryFields(){
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add("Gracias. Tu pedido ha sido recibido.");
        return submitedFormResult;
    }
    private String messageForMandatoryFields(){
        return "\n" + practiceFormPage.isRegistrationDone().toString() + "\n\r" + expectedOutcomeForMandatoryFields().toString();
    }

}
