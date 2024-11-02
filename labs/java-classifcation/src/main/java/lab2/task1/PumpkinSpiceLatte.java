package lab2.task1;

public class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(int ml, Intensity intensity, int mg) {
        super("Pumpkin Spice Latte", ml, intensity);
        this.mgOfPumpkinSpice = mg;
    }

    public int getSpice(){
        return mgOfPumpkinSpice;
    }

    @Override
    public void printCoffeeDetails(){
        super.printCoffeeDetails();
        System.out.println("Mg of Pumpkin Spice: " + mgOfPumpkinSpice);
    }
}
