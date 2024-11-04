package lab2.task4;
import lab2.task3.Barista;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean accept=true;
        String response = null;

        Barista barista = new Barista("Chloe");
        System.out.println("Hey, " + barista.getName()+"! Let's get to work!");

        System.out.println("Let's take orders.");
        while (accept){
            barista.placeOrder(scanner);
            System.out.println("Place new order? (yes/no)");
            response=null;

            while(response == null) {
                response = scanner.nextLine();
                if (response.equalsIgnoreCase("no")) {
                    accept = false;
                } else if (response.equalsIgnoreCase("yes")) {
                    accept = true;
                } else {
                    System.out.println("Invalid answer. Answer yes or no.");
                    response = null;
                }
            }
        }

        System.out.println("Coffees made:\n");
        barista.viewOrders();

    }


}
