package co.com.sofka.automationpractice.test.stepdefinition.shoppingcart;

import co.com.sofka.automationpractice.test.controllers.openwebpage.StartBrowserWebController;
import co.com.sofka.automationpractice.test.controllers.shoppingcart.*;
import co.com.sofka.automationpractice.test.data.objects.TestInfo;
import co.com.sofka.automationpractice.test.model.shoppingcart.ProductModel;
import co.com.sofka.automationpractice.test.stepdefinition.Setup;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class ShoppingCartStepDefinition extends Setup {
    private WebAction webAction;
    private ProductModel productModel;
    private ProductModel cartProductModel;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el usuario se encuentra en la pagina de SignIn")
    public void queElUsuarioSeEncuentraEnLaPaginaDeSignIn() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());

        startBrowserWebController.abrirTiendaOnline();
    }
    @Dado("que el usuario se registra correctamente en la tienda")
    public void queElUsuarioSeRegistraCorrectamenteEnLaTienda() {
        SignInWebController signInWebController = new SignInWebController();
        signInWebController.setWebAction(webAction);
        signInWebController.goToSignInPage();

        UserRegisterWebController userRegisterWebController = new UserRegisterWebController();
        userRegisterWebController.setWebAction(webAction);
        userRegisterWebController.registerUser();
    }
    @Cuando("el usuario navega a la seccion dresses, agrega un producto al carro de compras y navega al carrito")
    public void elUsuarioNavegaALaSeccionDressesAgregaUnProductoAlCarroDeComprasYNavegaAlCarrito() {
        AddProductToCartWebController addProductToCartWebController = new AddProductToCartWebController();
        addProductToCartWebController.setWebAction(webAction);
        addProductToCartWebController.addToCart();

        productModel = addProductToCartWebController.getProductModel();
    }
    @Entonces("el carro de compras debe contener el producto agregado")
    public void elCarroDeComprasDebeContenerElProductoAgregado() {
        CartWebController cartWebController = new CartWebController();
        cartWebController.setWebAction(webAction);
        cartWebController.getCartProductInfo();

        cartProductModel = cartWebController.getCartProductModel();

        Assert
                .Hard
                .thatString(productModel.getProductName())
                .isEqualTo(cartProductModel.getProductName());
    }
    @Dado("el usuario agrega una unidad de un producto al carro de compras y navega hacia el carrito")
    public void elUsuarioAgregaUnaUnidadDeUnProductoAlCarroDeComprasYNavegaHaciaElCarrito() {
        AddProductToCartWebController addProductToCartWebController = new AddProductToCartWebController();
        addProductToCartWebController.setWebAction(webAction);
        addProductToCartWebController.addToCart();

        productModel = addProductToCartWebController.getProductModel();
    }
    @Cuando("el usuario suma una unidad del producto agregado")
    public void elUsuarioSumaUnaUnidadDelProductoAgregado() {
        AddProductUnitWebController addProductUnitWebController = new AddProductUnitWebController();
        addProductUnitWebController.setWebAction(webAction);
        addProductUnitWebController.addProductUnit();
    }
    @Entonces("el precio total sera el doble del precio por unidad")
    public void elPrecioTotalSeraElDobleDelPrecioPorUnidad() {
        CartWebController cartWebController = new CartWebController();
        cartWebController.setWebAction(webAction);
        cartWebController.getCartProductInfo();

        cartProductModel = cartWebController.getCartProductModel();

        Assert
                .Hard
                .thatDouble(cartProductModel.getProductTotalPrice())
                .isEqualTo(cartProductModel.getDoubleProductUnitPrice());
    }

    @After
    public void cerrarDriver() {
        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
