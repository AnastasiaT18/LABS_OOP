package lab2.task3;

public class Cappuccino extends Coffee{
    private int mlOfMilk;

    public Cappuccino(String name, int ml, Intensity intensity){
        super(name, intensity);
        this.mlOfMilk = ml;
    }

    public int getMl(){
        return mlOfMilk;
    }

    @Override
    public void printCoffeeDetails(){
        super.printCoffeeDetails();
        System.out.println("Ml of Milk in " + this.name + ": " + mlOfMilk);
    }

    public static Cappuccino makeCappuccino(String name, int ml, Intensity intensity){
        Cappuccino cappuccino = new Cappuccino(name, ml, intensity);
        Cappuccino.makeCoffee(cappuccino.name, cappuccino.coffeeIntensity);
        System.out.println("Adding "+ cappuccino.mlOfMilk + "ml of milk.");
        return cappuccino;
    }


}
