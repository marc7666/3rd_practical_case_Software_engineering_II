import java.util.ArrayList;
import java.util.List;

/**
 * @project: 3rd practical case Software engineering II.
 * @author: mcr99 on 16/05/2022.
 */
public class Pack implements Product {

    private float discount;

    private List<Product> products;

    public Pack(float discount) {
        this.discount = discount;
        this.products = new ArrayList<Product>();
    }

    public void removeProd(Product p) {
        this.products.remove(p);
    }

    @Override
    public float getPrice() {
        float price = 0f;
        for (Product p : products) {
            price += p.getPrice();
        }
        price = (1f - getDiscount()) * price;
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        if (discount < 0f || discount > 1f) {
            throw new IllegalArgumentException("Not valid discount");
        } else {
            this.discount = discount;
        }
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        return "Pack {" +
                "discount = " + discount +
                ", products = " + products +
                '}';
    }
}
