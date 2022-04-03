package co.com.sofka.automationpractice.test.model.shoppingcart;

import static co.com.sofka.automationpractice.test.helpers.Numbers.TWO;

public class ProductModel {

    private String productName;
    private double productUnitPrice;
    private double productTotalPrice;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(double productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public double getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(double productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public double getDoubleProductUnitPrice() {
        return productUnitPrice * TWO.getValue();
    }
}
