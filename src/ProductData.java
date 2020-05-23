import java.io.Serializable;
import java.util.ArrayList;

public class ProductData implements Serializable {
    private String operationType;
    private Products products;
    private ArrayList<Products> product;

    public ProductData(String operationType, Products products) {
        this.operationType = operationType;
        this.products = products;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public ArrayList<Products> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Products> product) {
        this.product = product;
    }
}

