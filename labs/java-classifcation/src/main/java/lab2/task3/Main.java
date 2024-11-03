package lab2.task3;
import lab2.task1.*;


public class Main {
    public static void main(String[] args) {

        Coffee drink = Cappuccino.makeCappuccino("Cappuccino", 200, Coffee.Intensity.STRONG);
        System.out.println("Coffee Done!\n");


        if (drink instanceof Cappuccino){
            ((Cappuccino)drink).printCoffeeDetails();
        }
        System.out.println();


        Coffee drink2 = SyrupCappuccino.makeSyrupCappuccino( 200, Coffee.Intensity.STRONG, SyrupCappuccino.SyrupType.VANILLA);
        System.out.println("Coffee Done!\n");

        if(drink2 instanceof SyrupCappuccino){
            ((SyrupCappuccino)drink2).printCoffeeDetails();
        }
        System.out.println();

        Coffee drink3 = PumpkinSpiceLatte.makePumpkinSpiceLatte( 200, Coffee.Intensity.STRONG, 10);
        System.out.println("Coffee Done!\n");

        if(drink3 instanceof PumpkinSpiceLatte){
            ((PumpkinSpiceLatte)drink3).printCoffeeDetails();
        }
        System.out.println();


        Coffee drink4 = Americano.makeAmericano(100, Coffee.Intensity.LIGHT);
        System.out.println("Coffee Done!\n");

        if(drink4 instanceof Americano){
            ((Americano)drink4).printCoffeeDetails();
        }
    }
}
