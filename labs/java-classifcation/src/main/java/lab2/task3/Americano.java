package lab2.task3;

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

    public static Americano makeAmericano(int ml, Intensity intensity){
        Americano americano = new Americano(ml, intensity);
        Americano.makeCoffee("Americano", intensity);
        System.out.println("Adding "+ americano.mlOfWater + "ml of water.");
        return americano;
    }
    }

