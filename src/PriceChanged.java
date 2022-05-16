/**
 * @project: untitled.
 * @author: mcr99 on 16/05/2022.
 */
public final class PriceChanged {
    private final float oldPrice;
    private final float newPrice;

    public PriceChanged(float oldPrice, float newPrice) {
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public float getOldPrice() {
        return oldPrice;
    }

    public float getNewPrice() {
        return newPrice;
    }
}
