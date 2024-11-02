package lab2.task1;

public class Coffee {
    protected Intensity coffeeIntensity;
    protected final String name;

    public enum Intensity{
        LIGHT,
        NORMAL,
        STRONG
    }

    public Coffee(String name, Intensity intensity){
        this.name = name;
        this.coffeeIntensity = intensity;
    }

    public Intensity getIntensity(){
        return coffeeIntensity;
    }

    public String getName(){
        return name;
    }

    public void printCoffeeDetails(){
        System.out.println("Coffee: " + this.name);
        System.out.println( this.name + " Intensity: " + this.coffeeIntensity);
    }

}
