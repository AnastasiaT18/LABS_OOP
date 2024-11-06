package lab2.task2;


public class Main {
    public static void main(String[] args) {
        Cappuccino c = new Cappuccino("Cappuccino",200, Coffee.Intensity.STRONG);
        SyrupCappuccino sc = new SyrupCappuccino(250, Coffee.Intensity.LIGHT, SyrupCappuccino.SyrupType.VANILLA);
        PumpkinSpiceLatte p = new PumpkinSpiceLatte(300, Coffee.Intensity.NORMAL, 10);
        Americano a = new Americano(100, Coffee.Intensity.STRONG);

        c.printCoffeeDetails();
        System.out.println();
        sc.printCoffeeDetails();
        System.out.println();
        p.printCoffeeDetails();
        System.out.println();
        a.printCoffeeDetails();
    }
}
