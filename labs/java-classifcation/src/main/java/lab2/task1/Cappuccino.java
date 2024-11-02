package lab2.task1;

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
}
