public class NoMoneyState implements State{
    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.printf("insert money: $%.2f%n", amount);
        machine.addToCurrentAmount(amount);
        System.out.printf("[NoMoneyState] Current amount = $%.2f. You may now select a product.%n", machine.getCurrentAmount());
        machine.setState(machine.getMoneyInsertedState());
    }

    @Override
    public void selectProduct(VendingMachine machine, int rackNumber) {
        System.out.println("[NoMoneyState] selectProduct: No money inserted. Please insert cash first.");
    }
}
