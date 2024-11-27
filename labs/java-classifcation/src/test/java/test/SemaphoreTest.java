package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab3.task1.ArrayImpl;
import lab3.task1.ListImpl;
import lab3.task1.Queue;
import lab3.task1.TwoStacksImpl;
import lab3.task2.*;
import lab3.task3.Car;
import lab3.task3.CarStation;
import lab3.task4.Semaphore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class SemaphoreTest {

    @Test
    public void testElectric() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String carsString1 = """
                [
                      {
                      "id": 1, 
                      "type": "ELECTRIC", 
                      "passengers": "ROBOTS", 
                      "isDining": false, 
                      "consumption": 11
                      },
                      
                      {
                      "id": 2, 
                      "type": "ELECTRIC", 
                      "passengers": "PEOPLE", 
                      "isDining": false, 
                      "consumption": 50
                      },
                      
                      {
                      "id": 3, 
                      "type": "ELECTRIC", 
                      "passengers": "ROBOTS", 
                      "isDining": false, 
                      "consumption": 47
                      }

                ]
                
                """;

        List<Car> toBeServed = mapper.readValue(carsString1, new TypeReference<>() {
        });
        Queue<Car> toBeServedQueue = new ListImpl<>();
        for(Car car : toBeServed){
            toBeServedQueue.enqueue(car);
        }

        initialize();

        Semaphore semaphore = initialize();

        while(!toBeServedQueue.isEmpty()){
            semaphore.guideCar(toBeServedQueue.peek());
            toBeServedQueue.dequeue();
        }
        System.out.println("All cars have been assigned.");

        Assertions.assertTrue(toBeServedQueue.isEmpty());
        Assertions.assertEquals(2,semaphore.getElecRobots().getQueue().size());
        Assertions.assertEquals(1, semaphore.getElecPeople().getQueue().size());

    }

    @Test
    public void testGas() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String carsString1 = """
                [
                      {"id": 8, "type": "GAS", "passengers": "PEOPLE", "isDining": true, "consumption": 46},
                      {"id": 10, "type": "GAS", "passengers": "ROBOTS", "isDining": true, "consumption": 24},
                      {"id": 11, "type": "GAS", "passengers": "PEOPLE", "isDining": true, "consumption": 45}
                ]
                """;

        List<Car> toBeServed = mapper.readValue(carsString1, new TypeReference<>() {
        });
        Queue<Car> toBeServedQueue = new ListImpl<>();
        for(Car car : toBeServed){
            toBeServedQueue.enqueue(car);
        }

        Semaphore semaphore = initialize();


        while(!toBeServedQueue.isEmpty()){
            semaphore.guideCar(toBeServedQueue.peek());
            toBeServedQueue.dequeue();
        }
        System.out.println("All cars have been assigned.");

        Assertions.assertTrue(toBeServedQueue.isEmpty());
        Assertions.assertEquals(2,semaphore.getGasPeople().getQueue().size());
        Assertions.assertEquals(1, semaphore.getGasRobots().getQueue().size());


    }

    public Semaphore initialize(){
        Dineable robotGasDiningService = new RobotDinner();
        Dineable peopleGasDiningService = new PeopleDinner();
        Dineable robotEDiningService = new RobotDinner();
        Dineable peopleEDiningService = new PeopleDinner();

        //4 refueling services for 4 stations
        Refuelable gasPeopleRefuelingService = new GasStation();
        Refuelable ePeopleRefuelingService = new ElectricStation();
        Refuelable gasRobotsRefuelingService = new GasStation();
        Refuelable eRobotsRefuelingService = new ElectricStation();

        //4 queues
        Queue<Car> queue1 = new ListImpl<>();
        Queue<Car> queue2 = new ArrayImpl<>();
        Queue<Car> queue3 = new TwoStacksImpl<>();
        Queue<Car> queue4 = new TwoStacksImpl<>();

        //the 4 stations
        CarStation gasRobots = new CarStation(queue1, robotGasDiningService, gasRobotsRefuelingService);
        CarStation elecRobots = new CarStation(queue2, robotEDiningService, eRobotsRefuelingService);
        CarStation gasPeople = new CarStation(queue3, peopleGasDiningService, gasPeopleRefuelingService);
        CarStation elecPeople = new CarStation(queue4, peopleEDiningService, ePeopleRefuelingService);

        Semaphore semaphore = new Semaphore(gasPeople,gasRobots,elecPeople,elecRobots);
        return semaphore;
    }
}
