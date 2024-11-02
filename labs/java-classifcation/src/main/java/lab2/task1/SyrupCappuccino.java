package lab2.task1;

public class SyrupCappuccino extends Cappuccino{
    private SyrupType syrup;

    public enum SyrupType{
        MACADAMIA,
        VANILLA,
        COCONUT,
        CARAMEL,
        CHOCOLATE,
        POPCORN
    }

    public SyrupCappuccino(int ml, Intensity intensity, SyrupType syrup){
        super("Syrup Cappuccino", ml, intensity);
        this.syrup = syrup;
    }

    public SyrupType getSyrup(){
        return syrup;
    }

    @Override
    public void printCoffeeDetails(){
        super.printCoffeeDetails();
        System.out.println("Syrup: " + syrup);
    }
}
