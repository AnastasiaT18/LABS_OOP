package lab2.task3;

    class PumpkinSpiceLatte extends Cappuccino {
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

    public static PumpkinSpiceLatte makePumpkinSpiceLatte(int ml, Intensity intensity, int mg){
        Cappuccino latte = makeCappuccino("Pumpkin Spice Latte", ml, intensity);
        PumpkinSpiceLatte spiceLatte = new PumpkinSpiceLatte(latte.getMl(), latte.coffeeIntensity, mg);
        System.out.println("Adding "+ spiceLatte.mgOfPumpkinSpice + "mg of pumpkin spice.");
        return spiceLatte;
    }
}
