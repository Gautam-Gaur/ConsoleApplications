public class Product {
    private final int id;
    private final String name;
    private final ProductType productType;
    private final double price;

    public Product(int id, String name, ProductType productType, double price) {
        this.name = name;
        this.id = id;
        this.productType = productType;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
