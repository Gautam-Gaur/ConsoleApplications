public class Driver {
    public static void main(String[] args) {
        VendingMachine vm = VendingMachine.getInstance();

        // Setup
        vm.addRack(new Rack(1)); vm.addRack(new Rack(2)); vm.addRack(new Rack(3));
        Product choc = new Product(101, "Chocolate Bar", ProductType.CHOCOLATE, 100);
        Product snack= new Product(102, "Potato Chips", ProductType.SNACK, 200);
        Product bev  = new Product(103, "Soda Can", ProductType.BEVERAGE, 250);
        vm.loadProduct(1, choc, 5);
        vm.loadProduct(2, snack, 3);
        vm.loadProduct(3, bev,   2);
        vm.showInventory();

        // Scenario 1: Exact payment
        System.out.println("========== Scenario 1: Exact Payment ==========");
        vm.insertMoney(100);
        vm.selectProduct(1);

        // Scenario 2: Overpayment & Change
        System.out.println("========== Scenario 2: Overpayment & Change ==========");
        vm.insertMoney(300);
        vm.selectProduct(2);

        // Scenario 3: Underpayment & Refund
        System.out.println("========== Scenario 3: Underpayment & Refund ==========");
        vm.insertMoney(50);
        vm.selectProduct(3);

        // Scenario 4: Deplete Rack & Retry
        System.out.println("========== Scenario 4: Deplete Rack 3 & Retry ==========");
        vm.insertMoney(500); vm.selectProduct(3);
        vm.insertMoney(250); vm.selectProduct(3);
        vm.insertMoney(250); vm.selectProduct(3);

        vm.showInventory();
    }
}