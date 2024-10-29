package lab1.task1;

public class Main {
    public static void main(String[] args) {

        Display m1 = new Display(1920,1080,96, "Monitor 1");
        Display m2 = new Display(2560,1440,109, "Monitor 2");
        Display m3 = new Display(1920,1080,90, "Monitor 3");

        System.out.println("Comparing monitor 1 and 2:");
        m1.compareWithMonitor(m2);

        System.out.println("Comparing monitor 2 and 3:");
        m2.compareWithMonitor(m3);

        System.out.println("Comparing monitor 1 and 3:");
        m1.compareWithMonitor(m3);


    }
}
