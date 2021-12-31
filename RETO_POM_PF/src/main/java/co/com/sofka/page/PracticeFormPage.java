package co.com.sofka.page;

import co.com.sofka.model.PracticeFormModel;
import co.com.sofka.page.common.CommonActionOnpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class PracticeFormPage extends CommonActionOnpages {

    private final PracticeFormModel practiceFormModel;


    // locators

    @FindBy(xpath = "//a[@class='dashicons-tag mega-menu-link']")
    private WebElement ofertas;

    @FindBy(css = "input[data-brand='800']")
    private WebElement marcaZonaFit;

    @FindBy(className = "primary is-small mb-0 button product_type_bundle add_to_cart_button ajax_add_to_cart is-flat")
    private WebElement addCarrito;
    @FindBy(css = "div[class='wc-proceed-to-checkout']")
    private WebElement finalizarCompra;

    @FindBy(id = "billing_myfield12")
    private WebElement numeroCedula;

    @FindBy(id = "billing_email")
    private WebElement email;

    @FindBy(id = "billing_first_name")
    private WebElement nombre;

    @FindBy(id = "billing_last_name")
    private WebElement apellido;

    @FindBy(id = "select2-billing_state-container")
    private WebElement departamento;
    @FindBy(css = "input[class='select2-search__field']")
    private WebElement campoDepartamento;

    @FindBy(id = "select2-billing_city-container")
    private WebElement ciudad;
    @FindBy(css = "input[class='select2-search__field']")
    private WebElement campoCiudad;

    @FindBy(id = "billing_address_1")
    private WebElement direccion;

    @FindBy(id = "billing_address_2")
    private WebElement direccionComplementaria;

    @FindBy(id = "billing_phone")
    private WebElement celular;

    @FindBy(id="order_comments")
    private WebElement anotaciones;

    //ubicación cero
    @FindBy(id = "payment_method_bacs")
    private WebElement tipopago1;

    @FindBy(id = "payment_method_bank_transfer_1")
    private WebElement tipopago2;

    //ubicacion 2
    @FindBy(id = "payment_method_woo-mercado-pago-basic")
    private WebElement tipopago3;

    @FindBy(id = "terms")
    private WebElement terminosycondiciones;

    @FindBy(id="place_order")
    private WebElement botonordenar;

    //For Validation
    @FindBy(xpath="//*[@id=\"main\"]/div[2]/div/div/div[2]/div/p/strong")
    private WebElement locatorAssertionMensajeComprobacion;


    // for sikulix

    private static final String PAGE_BASE_PATCH = USER_DIR.value() + "\\src\\main\\resources\\page.PracticeFormPage\\";
    private static final String SELECT_PICTURE_ADD_CAR = PAGE_BASE_PATCH + "anadirCarrito.PNG";
    private static final String SELECT_PICTURE_SEE_CAR = PAGE_BASE_PATCH + "verCarrito.PNG";


    //constructor
    public PracticeFormPage (PracticeFormModel practiceFormModel, WebDriver webDriver) {
        super(webDriver);
        this.practiceFormModel = practiceFormModel;
        PageFactory.initElements(webDriver, this);

    }

    //functions
    public void fillFieldsScenario1 () {


        click(ofertas);
        click(ofertas);
        click(marcaZonaFit);
        scrollDown();
        click(SELECT_PICTURE_ADD_CAR);
        click(SELECT_PICTURE_SEE_CAR);

        click(finalizarCompra);

        typeInto(numeroCedula,practiceFormModel.getNumeroCedula());
        typeInto(email,practiceFormModel.getEmail());
        typeInto(nombre,practiceFormModel.getNombre());
        typeInto(apellido,practiceFormModel.getApellido());

        scrollDown();
        click(departamento);
        typeInto(campoDepartamento,practiceFormModel.getDepartamento());
        pressEnter(campoDepartamento);

        click(ciudad);
        typeInto(campoCiudad,practiceFormModel.getCiudad());
        pressEnter(campoCiudad);

        typeInto(direccion,practiceFormModel.getDireccion());
        typeInto(direccionComplementaria,practiceFormModel.getDireccioncomplementaria());
        typeInto(celular, practiceFormModel.getCelular());
        typeInto(anotaciones, practiceFormModel.getAnotaciones());

        scrollTo(tipopago2);
        waitForElementToBeInvisible(By.className("blockOverlay"));
        waitToBeClickable(tipopago2);
        click(tipopago2);

        waitForElementToBeInvisible(By.className("blockOverlay"));

        click(terminosycondiciones);
        click(botonordenar);

    }


    public void fillFieldsScenario2 () {

        click(ofertas);
        click(ofertas);
        scrollDown();
        scrollDown();
        scrollDown();
        scrollDown();
        scrollDown();
        scrollDown();
        scrollDown();


        click(SELECT_PICTURE_ADD_CAR);
        scrollDown();
        click(SELECT_PICTURE_ADD_CAR);
        click(SELECT_PICTURE_SEE_CAR);

        click(finalizarCompra);

        typeInto(numeroCedula,practiceFormModel.getNumeroCedula());
        typeInto(email,practiceFormModel.getEmail());
        typeInto(nombre,practiceFormModel.getNombre());
        typeInto(apellido,practiceFormModel.getApellido());

        scrollDown();
        click(departamento);
        typeInto(campoDepartamento,practiceFormModel.getDepartamento());
        pressEnter(campoDepartamento);

        click(ciudad);
        typeInto(campoCiudad,practiceFormModel.getCiudad());
        pressEnter(campoCiudad);

        typeInto(direccion,practiceFormModel.getDireccion());
        typeInto(direccionComplementaria,practiceFormModel.getDireccioncomplementaria());
        typeInto(celular, practiceFormModel.getCelular());
        typeInto(anotaciones, practiceFormModel.getAnotaciones());

        scrollTo(tipopago2);
        waitToBeClickable(tipopago2);
        waitForElementToBeInvisible(By.className("blockOverlay"));
        scrollTo(tipopago2);
        click(tipopago2);

        waitForElementToBeInvisible(By.className("blockOverlay"));
        click(terminosycondiciones);
        click(botonordenar);

    }
    public List<String> isRegistrationDone(){
        List<String> submitedFormResult = new ArrayList<>();
        waitToBeClickable(locatorAssertionMensajeComprobacion);
        submitedFormResult.add(getText(locatorAssertionMensajeComprobacion).trim());
        return submitedFormResult;
    }

}
