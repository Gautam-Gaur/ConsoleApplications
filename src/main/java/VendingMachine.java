public class VendingMachine {
    private final State noMoneyState = new NoMoneyState();
    private final State moneyInsertedState = new MoneyInsertedState();
    private final State dispenseState = new DispenseState();

    private State currentState = noMoneyState;
    private double currentAmount = 0.0;
    private int selectedRack = -1;
    private final Inventory inventory = new Inventory();
    private static VendingMachine instance;


    private VendingMachine() {}
    public static VendingMachine getInstance(){
        if(instance == null)
             instance = new VendingMachine();
        return instance;
    }

    State getNoMoneyState(){ return noMoneyState; }
    State getMoneyInsertedState(){ return moneyInsertedState; }
    State getDispenseState(){ return dispenseState; }

    void setState(State state){

    }

    double getCurrentAmount(){ return this.currentAmount; }
    void addToCurrentAmount(double amount){ currentAmount += amount; }
    Inventory getInventory(){ return inventory; }
    void setSelectedRack(int rackNumber){ selectedRack = rackNumber; }


    // user operations
    public void insertMoney(double amount){
        currentState.insertMoney(this, amount);
    }
    public void selectProduct(int rackNumber){ currentState.selectProduct(this, rackNumber);}
    public void dispenseProduct(){
        System.out.println("Dispensing now...");
        Rack rack = inventory.getRack(selectedRack);
        Product product = rack.peekProduct();
        System.out.printf("Dispensing %s. Enjoy!%n", product.getName());
        rack.dispenseOne();
        double change = currentAmount - product.getPrice();
        if(change>0) System.out.printf("Returning change $%.2f%n", change);
        reset();
    }


    private void reset(){
        currentAmount = 0.0;
        selectedRack = -1;
        setState(noMoneyState);
    }
}
