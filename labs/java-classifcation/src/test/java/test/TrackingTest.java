package test;

import lab3.task2.ElectricStation;
import lab3.task2.GasStation;
import lab3.task2.PeopleDinner;
import lab3.task2.RobotDinner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TrackingTest {

    @Test
    public void testRefueling() {
        GasStation gasStation = new GasStation();
        ElectricStation elecStation = new ElectricStation();

        gasStation.refuel(1);
        gasStation.refuel(2);

        GasStation gasStation2 = new GasStation();
        gasStation2.refuel(3);

        Assertions.assertEquals(3,gasStation.getCountCars());


        elecStation.refuel(4);
        elecStation.refuel(5);
        ElectricStation elecStation2 = new ElectricStation();
        elecStation2.refuel(6);

        Assertions.assertEquals(3,elecStation2.getCountCars());
    }

    @Test
    public void testDining(){
        PeopleDinner peopleDinner = new PeopleDinner();
        PeopleDinner peopleDinner2 = new PeopleDinner();
        RobotDinner robotDinner = new RobotDinner();
        RobotDinner robotDinner2 = new RobotDinner();

        peopleDinner.serveDinner(1);
        peopleDinner2.serveDinner(2);

        robotDinner.serveDinner(3);
        robotDinner2.serveDinner(4);

        Assertions.assertEquals(2,peopleDinner.getCountCars());
        Assertions.assertEquals(2,robotDinner2.getCountCars());

    }
}
