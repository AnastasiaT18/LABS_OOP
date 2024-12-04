package lab3.task2;

import lab3.task3.Car;

public class GasStation implements Refuelable{

    private static int gasCarsCount = 0;
    private static int gasConsumption = 0;

    @Override
    public void refuel(int carID){
        System.out.println("Refueling gas car "+ carID +".");
        gasCarsCount++;
    }

    @Override
    public int getCountCars(){
        return gasCarsCount;
    }

    @Override
    public void addConsumption(Car car){
        gasConsumption+=car.getConsumption();
    }

    @Override
    public int getConsumption(){
        return gasConsumption;
    }
}
