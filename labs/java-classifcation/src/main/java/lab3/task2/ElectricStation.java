package lab3.task2;

public class ElectricStation implements Refuelable{

    private static int electricalCarsCount=0;

    @Override
    public void refuel(String carID){
        System.out.println("Refueling electric car" + carID + ".");
        electricalCarsCount++;
    }



    public int getElectricCarsCount(){
        return electricalCarsCount;
    }
}
