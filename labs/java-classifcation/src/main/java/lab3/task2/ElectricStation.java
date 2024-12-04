package lab3.task2;

import lab3.task3.Car;

public class ElectricStation implements Refuelable{

    private static int electricalCarsCount=0;
    private static int elecConsumption = 0;

    @Override
    public void refuel(int carID){
        System.out.println("Refueling electric car " + carID + ".");
        electricalCarsCount++;
    }

    @Override
    public int getCountCars(){
        return electricalCarsCount;
    }

    @Override
    public void addConsumption(Car car){
        elecConsumption+=car.getConsumption();
    }

    @Override
    public int getConsumption(){
        return elecConsumption;
    }
}
