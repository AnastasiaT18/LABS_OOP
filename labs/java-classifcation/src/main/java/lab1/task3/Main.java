package lab1.task3;

import lab1.task1.Display;

public class Main {
    public static void main(String[] args) {

        Display m1 = new Display(1920, 1080, 96, "Monitor 1");
        Display m2 = new Display(2560, 1440, 109, "Monitor 2");
        Display m3 = new Display(1920, 1080, 90, "Monitor 3");

        Assistant assistant = new Assistant("Chloe");

        assistant.assignDisplay(m1);
        assistant.assignDisplay(m2);
        assistant.assignDisplay(m3);

        assistant.assist();

        Display bought = new Display();
        System.out.println("\nI bought this monitor:");
        bought = assistant.buyDisplay(m2);
        bought.displayMonitor();

        System.out.println("\nRemaining monitors: ");
        for (Display d : assistant.getList()) {
            d.displayMonitor();
        }
    }

}

