package lab2.task4;
import lab2.task3.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Barista {
    private String name;
    private List<Coffee> coffeeOrders;

    Barista(String name){
        this.name = name;
        coffeeOrders = new ArrayList<Coffee>();
    }

    public String getName(){
        return name;
    }


    public void placeOrder(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What coffee would you like (Cappucino, Syrup Cappuccino, Pumpkin Spice Latte, Americano)? ");
        String name = scanner.nextLine();

        System.out.println("What Intensity (light, normal, strong) ?");
        String intense = scanner.nextLine();
        Coffee.Intensity intensity = Coffee.Intensity.valueOf(intense.toUpperCase());

        Integer milk=null;
        Integer mg=null;
        Integer water = null;
        SyrupCappuccino.SyrupType syrupType=null;

        if(!name.equalsIgnoreCase("Americano")) {
            System.out.println("How much milk?");
            milk = Integer.parseInt(scanner.nextLine());

            if (name.equalsIgnoreCase("Cappuccino")) {
                name="Cappuccino";
            }
            else if (name.equalsIgnoreCase("Syrup Cappuccino")) {
                name="Syrup Cappuccino";
                System.out.println("What syrup?");
                String syrup = scanner.nextLine();
                syrupType = SyrupCappuccino.SyrupType.valueOf(syrup.toUpperCase());

            } else if (name.equalsIgnoreCase("Pumpkin Spice Latte")) {
                name="Pumpkin Spice Latte";
                System.out.println("How many mg of pumpkin spice?");
                mg = Integer.parseInt(scanner.nextLine());
            }
        }else{
            name="Americano";
            System.out.println("How much water?");
            water = Integer.parseInt(scanner.nextLine());
        }

        addOrder(name, intensity, milk, syrupType, mg, water);

    }

    public void addOrder(String name, Coffee.Intensity intensity, Integer milk, SyrupCappuccino.SyrupType syrupType, Integer mg, Integer water){
        Coffee drink = null;

        switch(name){
            case "Cappuccino":
                drink = Cappuccino.makeCappuccino(name, milk, intensity);
                break;
            case "Americano":
                drink = Americano.makeAmericano(water, intensity);
                break;
            case "Syrup Cappuccino":
                drink = SyrupCappuccino.makeSyrupCappuccino(milk, intensity, syrupType);
                break;
            case "Pumpkin Spice Latte":
                drink = PumpkinSpiceLatte.makePumpkinSpiceLatte(milk,intensity, mg);
                break;
        }
        coffeeOrders.add(drink);
    }

    public void viewOrders(){
        for (Coffee order:coffeeOrders){
            switch(order.getName()){
                case("Cappuccino"):
                    if(order instanceof Cappuccino){
                        ((Cappuccino)order).printCoffeeDetails();
                    }
                    break;
                case("Americano"):
                    if(order instanceof Americano){
                        ((Americano)order).printCoffeeDetails();
                    }
                    break;
                case("Syrup Cappuccino"):
                    if(order instanceof SyrupCappuccino){
                        ((SyrupCappuccino)order).printCoffeeDetails();
                    }
                    break;
                case("Pumpkin Spice Latte"):
                    if(order instanceof PumpkinSpiceLatte){
                        ((PumpkinSpiceLatte)order).printCoffeeDetails();
                    }
                    break;
            }
            System.out.println();
        }
    }


}
