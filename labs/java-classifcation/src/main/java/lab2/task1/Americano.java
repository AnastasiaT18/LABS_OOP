package lab2.task1;

public class Americano extends Coffee {
    private int mlOfWater;

    public Americano(int ml, Intensity intensity){
        super("Americano", intensity);
        this.mlOfWater = ml;
    }

    public int getMlOfWater() {

        return mlOfWater;
    }

    @Override
    public void printCoffeeDetails(){
        super.printCoffeeDetails();
        System.out.println("Ml of Water in " + this.name + ": " + mlOfWater);
    }

}
