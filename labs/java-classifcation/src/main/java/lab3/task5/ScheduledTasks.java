package lab3.task5;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
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


@Component
public class ScheduledTasks {

    ObjectMapper mapper = new ObjectMapper();
    FolderReader folderReader = new FolderReader();
    Semaphore semaphore = initialize();
    StatsTracker stats = new StatsTracker();


    @Scheduled(fixedRate = 5000)
    public void readCars() throws IOException {
        long startTime = System.nanoTime();
        File[] list = folderReader.readDir("src/main/java/lab-car-service/queue");
        for(File file: list){
            Car car = mapper.readValue(file,Car.class);
            stats.updateStats(car);
            semaphore.guideCar(car);
            file.delete();
        }

        long endTime = System.nanoTime();
        double elapsedTimeMs = (endTime - startTime) / 1_000_000.0;

        System.out.println("readCars task executed in: " + elapsedTimeMs + " ms");

    }


    @Scheduled(fixedRate = 7500)
    public void serveCars(){
        long startTime = System.nanoTime();
        System.out.println("-------Serving-------");
        semaphore.getGasRobots().serveCars();
        semaphore.getElecPeople().serveCars();
        semaphore.getElecRobots().serveCars();
        semaphore.getGasPeople().serveCars();

        long endTime = System.nanoTime(); // End timing
        double elapsedTimeMs = (endTime - startTime) / 1_000_000.0;

        System.out.println("serveCars task executed in: " + elapsedTimeMs + " ms");

    }

    public Semaphore initialize(){
        CarStation gasRobots = new CarStation(new ListImpl<>(), new RobotDinner(), new GasStation());
        CarStation elecRobots = new CarStation(new ArrayImpl<>(), new RobotDinner(), new ElectricStation());
        CarStation gasPeople = new CarStation(new TwoStacksImpl<>(), new PeopleDinner(), new GasStation());
        CarStation elecPeople = new CarStation(new TwoStacksImpl<>(), new PeopleDinner(), new ElectricStation());

        return new Semaphore(gasPeople,gasRobots,elecPeople,elecRobots);
    }

    @PreDestroy
    public void printStats(){
        stats.printStats();
//        System.out.println("ELECTRIC: " +semaphore.getElecPeople().getRefuelingService().getCountCars());
//        System.out.println("GAS: " +semaphore.getGasRobots().getRefuelingService().getCountCars());
//        System.out.println("PEOPLE: " +semaphore.getElecPeople().getDiningService().getCountCars());
//        System.out.println("ROBOTS: " +semaphore.getGasRobots().getDiningService().getCountCars());
//        System.out.println("DINING: " +(semaphore.getGasRobots().getDiningService().getCountDining() + semaphore.getElecPeople().getDiningService().getCountDining()));
//        System.out.println("NOT DINING: " + (semaphore.getElecPeople().getRefuelingService().getCountCars() + semaphore.getGasRobots().getRefuelingService().getCountCars() -semaphore.getGasRobots().getDiningService().getCountDining() - semaphore.getElecPeople().getDiningService().getCountDining()));
//        System.out.println("GAS(Consumption): " +semaphore.getGasRobots().getRefuelingService().getConsumption());
//        System.out.println("ELECTRIC(Consumption): " +semaphore.getElecRobots().getRefuelingService().getConsumption());
    }
}
