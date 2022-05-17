/**
 * @project: 3rd practical case Software engineering II.
 * @author: mcr99 on 16/05/2022.
 */
public class Item extends Product {
    private float price;

    public Item(float price) {
        this.price = price;
    }

    @Override
    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        if (price < 0) {
            throw new IllegalArgumentException("Negative price");
        }
        if (this.price != price) {
            float oldP = this.price;
            this.price = price;
            setChanged();
            notifyObservers(new PriceChanged(oldP, this.price));
        }
    }

    @Override
    public String toString() {
        return "Item {" +
                "price = " + price +
                '}';
    }
}
