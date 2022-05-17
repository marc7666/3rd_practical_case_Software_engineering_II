/**
 * @project: 3rd practical case Software engineering II.
 * @author: mcr99 on 16/05/2022.
 */
public class Main {
    public static void main(String[] args) {
        /* Pack */
        Pack p1 = new Pack(0.5f);

        /* Items */
        Item i1 = new Item(12.7f);
        Item i2 = new Item(10.13f);
        Item i3 = new Item(400.99f);

        /* Including items inside the pack */
        p1.addProduct(i1);
        p1.addProduct(i2);
        p1.addProduct(i3);

        System.out.println("---------- Composite pattern test part ----------");
        System.out.println("\n");
        System.out.println("---------- Pack with items ----------");
        System.out.println(p1);
        System.out.println("Final price after discount: " + (p1.getPrice()));

        /* Adding a pack inside a pack */
        Pack p2 = new Pack(0.1f);
        Item i4 = new Item(1.7f);
        Item i5 = new Item(123.45f);
        p2.addProduct(i4);
        p2.addProduct(i5);
        p1.addProduct(p2);

        System.out.println("\n");

        System.out.println("---------- Adding a pack inside a pack ----------");
        System.out.println(p1);
        System.out.println("Final price after discount: " + (p1.getPrice()));

        System.out.println("\n");

        System.out.println("---------- Observer test part ----------");
        /* Pack */
        Pack p3 = new Pack(0.6f);

        /* Items */
        Item i6 = new Item(121.7f);
        Item i7 = new Item(105.13f);
        Item i8 = new Item(4000.99f);

        p3.addProduct(i6);
        p3.addProduct(i7);
        p3.addProduct(i8);

        System.out.println(p3);
        System.out.println("Precio p3 anterior:"+p3.getPrice());
        i6.setPrice(200.0f);
        System.out.println(i6.getPrice());
        System.out.println(p3);
        System.out.println("Precio p3 actual:"+p3.getPrice());

    }
}
