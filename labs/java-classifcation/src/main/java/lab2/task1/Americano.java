package lab2.task1;

public class Americano extends Coffee {
    private int mlOfWater;

    public Americano(int ml, Intensity intensity){
        super(intensity);
        this.name="Americano";
        this.mlOfWater = ml;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

}
