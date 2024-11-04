package lab2.task4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean accept=true;

        Barista barista = new Barista("Chloe");
        System.out.println("Hey, "+barista.getName()+"! Let's get to work!");

        System.out.println("Let's take orders.");
        while (accept){
            barista.placeOrder();
            System.out.println("Place new order?");
            if(scanner.nextLine().equalsIgnoreCase("no")){
                accept=false;
            }
        }

        System.out.println("Coffees made:\n");
        barista.viewOrders();



    }


}
