package test;
import lab3.task1.ArrayImpl;
import lab3.task1.ListImpl;
import lab3.task1.Queue;
import lab3.task1.TwoStacksImpl;
import lab3.task2.*;
import lab3.task3.Car;
import lab3.task3.CarStation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Serving {

    @Test
    public void testNewStation() {
        Car car1 = new Car(1, Car.Types.ELECTRIC, Car.Passengers.PEOPLE, true, 40);
        Car car2 = new Car(2, Car.Types.ELECTRIC, Car.Passengers.ROBOTS, true, 30);
        Car car3 = new Car(3, Car.Types.GAS, Car.Passengers.ROBOTS, false, 30);
        Car car4 = new Car(4, Car.Types.GAS, Car.Passengers.ROBOTS, true, 30);

        CarStation carStation = new CarStation(new ListImpl<>(), new PeopleDinner(), new ElectricStation());
        CarStation carStation2 = new CarStation(new ArrayImpl<>(), new RobotDinner(), new ElectricStation());
        CarStation carStation3 = new CarStation(new TwoStacksImpl<>(), new RobotDinner(), new GasStation());

        carStation.addCar(car1);
        carStation2.addCar(car2);
        carStation3.addCar(car3);
        carStation3.addCar(car4);

        Assertions.assertEquals(2,carStation3.getQueue().size());

        carStation.serveCars();
        carStation2.serveCars();
        carStation3.serveCars();

        Assertions.assertTrue(carStation.getQueue().isEmpty());
        Assertions.assertTrue(carStation2.getQueue().isEmpty());
        Assertions.assertTrue(carStation3.getQueue().isEmpty());

        carStation3.serveCars();

        Assertions.assertEquals(2, (carStation2.getDiningService().getCountDining()));
        Assertions.assertEquals(2, (carStation3.getRefuelingService().getCountCars()));

        Assertions.assertEquals(70, carStation2.getRefuelingService().getConsumption());
        Assertions.assertEquals(60, carStation3.getRefuelingService().getConsumption());


    }
}
