package lab3.task4;

import lab3.task3.Car;
import lab3.task3.CarStation;


public class Semaphore {
    private CarStation gasRobots, gasPeople, elecRobots, elecPeople;

    public Semaphore(CarStation gasPeople,CarStation gasRobots,CarStation elecPeople,CarStation elecRobots) {
        this.elecPeople = elecPeople;
        this.gasPeople = gasPeople;
        this.gasRobots = gasRobots;
        this.elecRobots = elecRobots;
    }

    public void guideCar(Car  car){
        if(car.getPassengers() == Car.Passengers.ROBOTS && car.getType() == Car.Types.ELECTRIC){
            elecRobots.addCar(car);
            System.out.println("Car " + car.getId() + " assigned to Robots & Electric Station.");
        }
        else if(car.getPassengers() == Car.Passengers.ROBOTS && car.getType() == Car.Types.GAS){
            gasRobots.addCar(car);
            System.out.println("Car " + car.getId() + " assigned to Robots & Gas Station.");
        }
        else if(car.getPassengers() == Car.Passengers.PEOPLE && car.getType() == Car.Types.GAS){
            gasPeople.addCar(car);
            System.out.println("Car " + car.getId() + " assigned to People & Gas Station.");
        }
        else if(car.getPassengers() == Car.Passengers.PEOPLE && car.getType() == Car.Types.ELECTRIC){
            elecPeople.addCar(car);
            System.out.println("Car " + car.getId() + " assigned to People & Electric Station.");
        }
    }

    public CarStation getGasRobots() {
        return gasRobots;
    }

    public CarStation getGasPeople() {
        return gasPeople;
    }

    public CarStation getElecRobots() {
        return elecRobots;
    }

    public CarStation getElecPeople() {
        return elecPeople;
    }
}
