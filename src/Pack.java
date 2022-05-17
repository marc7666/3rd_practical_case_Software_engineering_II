import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


/**
 * @project: 3rd practical case Software engineering II.
 * @author: mcr99 on 16/05/2022.
 */
public class Pack extends Product implements Observer {

    private float discount;

    private boolean hasChanged;

    private float price;

    private List<Product> products;

    public Pack(float discount) {
        this.discount = discount;
        this.products = new ArrayList<Product>();
        this.hasChanged = false;
    }

    public void removeProd(Product p) {
        this.products.remove(p);
    }

    @Override
    public float getPrice() {
        if (!this.hasChanged) {
            return this.price * (1f - getDiscount());
        }
        this.price = 0;
        for (Product p : products) {
            this.price += p.getPrice();
        }
        this.hasChanged = false;
        return this.price * (1f - getDiscount());
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        if (discount < 0f || discount > 1f) {
            throw new IllegalArgumentException("Not valid discount");
        }
        if (this.discount != discount) {
            float olD = this.discount;
            this.discount = discount;

        }
    }

    public void addProduct(Product product) {
        this.products.add(product);
        float oldP = this.price;
        product.addObserver((Observer) this);
        this.price += product.getPrice();
        setChanged();
        notifyObservers(new PriceChanged(oldP, this.price));
    }

    @Override
    public String toString() {
        return "Pack {" +
                "discount = " + discount +
                ", products = " + products +
                '}';
    }

    @Override
    public void update(Observable o, Object arg) {
        PriceChanged pC = (PriceChanged) arg;
        float oldP = this.price;
        if (pC.getNewPrice() != pC.getOldPrice()) {
            this.hasChanged = true;
            setChanged();
            notifyObservers(new PriceChanged(oldP, this.getPrice()));
        }
    }
}
