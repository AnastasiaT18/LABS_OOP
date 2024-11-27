package lab3.task5;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PreDestroy;
import lab3.task1.ArrayImpl;
import lab3.task1.ListImpl;
import lab3.task1.Queue;
import lab3.task1.TwoStacksImpl;
import lab3.task2.*;
import lab3.task3.Car;
import lab3.task3.CarStation;
import lab3.task4.Semaphore;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledTasks {

    ObjectMapper mapper = new ObjectMapper();
    FolderReader folderReader = new FolderReader();
    Semaphore semaphore = initialize();
    List<String> processed = new ArrayList<>();
    StatsTracker stats = new StatsTracker();

    @Scheduled(fixedRate = 5000)
    public void readCars() throws IOException {
        File[] list = folderReader.readDir("src/main/java/lab-car-service/queue");
        for(File file: list){
            if(processed.contains(file.getName())){
                continue;
            }
            Car car = mapper.readValue(file,Car.class);
            stats.updateStats(car);
            semaphore.guideCar(car);
            processed.add(file.getName());
        }
    }

    @Scheduled(fixedRate = 7500)
    public void serveCars(){
        System.out.println("-------Serving-------");
        semaphore.getGasRobots().serveCars();
        semaphore.getElecPeople().serveCars();
        semaphore.getElecRobots().serveCars();
        semaphore.getGasPeople().serveCars();

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

        return new Semaphore(gasPeople,gasRobots,elecPeople,elecRobots);
    }

    @PreDestroy
    public void printStats(){
        stats.printStats();
    }
}
