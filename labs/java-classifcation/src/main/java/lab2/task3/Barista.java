package lab2.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Barista {
    private String name;
    private List<Coffee> coffeeOrders;

    public Barista(String name){
        this.name = name;
        coffeeOrders = new ArrayList<Coffee>();
    }

    public String getName(){
        return name;
    }


    public void placeOrder(Scanner scanner){
        String coffeeName = null;
        Integer milk=null;
        Integer mg=null;
        Integer water = null;
        SyrupCappuccino.SyrupType syrupType=null;
        Coffee.Intensity intensity = null;

        System.out.println("What coffee would you like (Cappuccino, Syrup Cappuccino, Pumpkin Spice Latte, Americano)? ");
        List<String> coffees = List.of("cappuccino", "syrup cappuccino", "pumpkin spice latte", "americano");

        while(coffeeName==null){
            coffeeName = scanner.nextLine();
            if(!coffees.contains(coffeeName.toLowerCase())){
                coffeeName = null;
                System.out.println("Invalid coffee option. Try again.");
            }

        }

        System.out.println("What Intensity (light, normal, strong) ?");
        while(intensity == null){
            String intense = scanner.nextLine();
            try{
                intensity = Coffee.Intensity.valueOf(intense.toUpperCase());
            }catch (IllegalArgumentException e){
                System.out.println("Invalid intensity option. Try again.");
            }
        }


        if(!coffeeName.equalsIgnoreCase("Americano")) {
            System.out.println("How much milk?");
            milk = Integer.parseInt(scanner.nextLine());

            if (coffeeName.equalsIgnoreCase("Cappuccino")) {
                coffeeName="Cappuccino";
            }
            else if (coffeeName.equalsIgnoreCase("Syrup Cappuccino")) {
                coffeeName="Syrup Cappuccino";
                System.out.println("What syrup (macadamia,vanilla,coconut,chocolate, popcorn)?");

                while(syrupType == null){
                    String syrup = scanner.nextLine();
                    try{
                        syrupType = SyrupCappuccino.SyrupType.valueOf(syrup.toUpperCase());
                    } catch(IllegalArgumentException e){
                        System.out.println("Invalid syrup option. Try again.");
                    }
                }

            } else if (coffeeName.equalsIgnoreCase("Pumpkin Spice Latte")) {
                coffeeName="Pumpkin Spice Latte";
                System.out.println("How many mg of pumpkin spice?");
                mg = Integer.parseInt(scanner.nextLine());
            }
        }else{
            coffeeName="Americano";
            System.out.println("How much water?");
            water = Integer.parseInt(scanner.nextLine());
        }

        addOrder(coffeeName, intensity, milk, syrupType, mg, water);

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
            order.printCoffeeDetails();
            System.out.println();
        }
    }


}
