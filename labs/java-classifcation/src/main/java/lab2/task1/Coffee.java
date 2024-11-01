package lab2.task1;

public class Coffee {
    protected Intensity coffeeIntensity;
    protected String name;

    public enum Intensity{
        LIGHT,
        NORMAL,
        STRONG
    }

    public Coffee(Intensity intensity){
        this.coffeeIntensity = intensity;
    }

    public Intensity getIntensity(){
        return coffeeIntensity;
    }

    public String getName(){
        return name;
    }
}
