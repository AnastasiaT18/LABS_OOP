package lab3.task2;

import lab3.task3.Car;

public interface Refuelable {
    void refuel(int carID);
    int getCountCars();
    void addConsumption(Car car);
    int getConsumption();

}
