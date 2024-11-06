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
        super(ml, intensity);
        this.syrup = syrup;
        this.name = "SyrupCappuccino"; //method overriding
    }

    public SyrupType getSyrup(){
        return syrup;
    }
}