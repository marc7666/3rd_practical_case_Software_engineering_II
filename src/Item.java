/**
 * @project: 3rd practical case Software engineering II.
 * @author: mcr99 on 16/05/2022.
 */
public class Item implements Product {
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
        } else {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "Item {" +
                "price = " + price +
                '}';
    }
}
