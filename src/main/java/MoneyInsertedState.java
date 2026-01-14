public class MoneyInsertedState implements State{
    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.printf("[MoneyInsertedState] insertMoney: adding $%.2f to current amount.%n", amount);
        machine.addToCurrentAmount(amount);
        System.out.printf("[MoneyInsertedState] Total amount = $%.2f.%n", machine.getCurrentAmount());
    }

    @Override
    public void selectProduct(VendingMachine machine, int rackNumber) {
        System.out.printf("[MoneyInsertedState] selectProduct: rack %d selected.%n", rackNumber);
        Rack rack = machine.getInventory().getRack(rackNumber);

        if(rack == null || rack.isEmpty()){
            System.out.println("Selected Rack is empty or does not exists. Refunding...");
            machine.refund();
            return;
        }
        Product product = rack.peekProduct();
        double price = product.getPrice();
        double paid = machine.getCurrentAmount();
        System.out.printf("[MoneyInsertedState] Product price = $%.2f, paid = $%.2f.%n", price, paid);

        if(paid<price){
            System.out.println("Insufficient money. Refunding...");
            machine.refund();
            return;
        }

        System.out.println("Sufficient money. Proceeding to dispense item");
        machine.setSelectedRack(rackNumber);
        machine.setState(machine.getMoneyInsertedState());
        machine.dispenseProduct();
    }
}
