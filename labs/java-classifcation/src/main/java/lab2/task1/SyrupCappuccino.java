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

    public static SyrupCappuccino makeSyrupCappuccino(int ml, Intensity intensity, SyrupType syrup){
//        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(ml, intensity, syrup);
//        syrupCappuccino.makeCappuccino( "Syrup Cappucino", ml, intensity);
        Cappuccino syrupCappuccino = makeCappuccino("Syrup Cappuccino", ml, intensity);
        SyrupCappuccino syrupCap = new SyrupCappuccino(syrupCappuccino.getMl(), syrupCappuccino.getIntensity(), syrup);
        System.out.println("Adding "+ syrupCap.syrup + " syrup.");
        return syrupCap;
    }
}
