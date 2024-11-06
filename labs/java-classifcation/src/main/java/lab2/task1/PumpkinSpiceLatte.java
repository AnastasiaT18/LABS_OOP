package lab2.task1;

public class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(int ml, Intensity intensity, int mg) {
        super(ml, intensity);
        this.name="Pumpkin Spice Latte";
        this.mgOfPumpkinSpice = mg;
    }

    public int getSpice(){
        return mgOfPumpkinSpice;
    }
}