import java.io.Serializable;

public class Products implements Serializable {
    private int customer_id;
    private Integer product_id;
    private int num;
    private int price;

    public Products() {

    }

    public Products(int customer_id, Integer product_id, int num, int price) {
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.num = num;
        this.price = price;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return customer_id + " " + product_id + " " + num + " " + price;
    }
}

