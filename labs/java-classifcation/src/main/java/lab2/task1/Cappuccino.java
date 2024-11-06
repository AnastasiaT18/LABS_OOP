package lab2.task1;

public class Cappuccino extends Coffee{
    private int mlOfMilk;

    public Cappuccino(int ml, Intensity intensity){
        super(intensity);
        this.name="Cappuccino";
        this.mlOfMilk = ml;
    }

    public int getMl(){
        return mlOfMilk;
    }
}