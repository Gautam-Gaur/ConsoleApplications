public class Rack {
    private final int rackNumber;
    private Product product;
    private int quantity;

    public Rack(int rackNumber) {
        this.rackNumber = rackNumber;
        quantity = 0;
    }

    public int getRackNumber(){
        return this.rackNumber;
    }
    public boolean isEmpty(){
        return quantity<=0;
    }

    public Product peekProduct() {
        return product;
    }

    public void loadProduct(Product product, int qty) {
        this.product = product;
        this.quantity += qty;
    }

    public void dispenseOne(){
        if(quantity>0) quantity--;
    }

    @Override
    public String toString() {
        if (product == null) return "Rack " + rackNumber + " [empty]";
        return String.format("Rack %d: %s ×%d", rackNumber, product.getName(), quantity);
    }

}
