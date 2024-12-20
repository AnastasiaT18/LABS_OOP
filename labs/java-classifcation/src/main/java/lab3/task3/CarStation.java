package lab3.task3;

import lab3.task2.Dineable;
import lab3.task1.Queue;
import lab3.task2.PeopleDinner;
import lab3.task2.Refuelable;
import lab3.task2.RobotDinner;

public class CarStation {
    private Dineable diningService;
    private Refuelable refuelingService;
    private Queue<Car> queue;

    public CarStation(Queue<Car> queue, Dineable diningService, Refuelable refuelingService) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = queue;
    }

    public void addCar(Car car){
        queue.enqueue(car);
    }

    public void serveCars(){
        Car car =  null;
        while(!queue.isEmpty()){
            car = queue.peek();
            System.out.println("Serving car " + car.getId()+"...");

            if(car.isIsDining()){
                diningService.serveDinner(car.getId());
            }
            diningService.countCars();
            refuelingService.refuel(car.getId());
            refuelingService.addConsumption(car);
            System.out.println("Car " + car.getId() +" served.");
            System.out.println("---------------------------");
            queue.dequeue();
        }
        System.out.println("Station is empty");
    }

    public Queue<Car> getQueue() {
        return queue;
    }

    public Dineable getDiningService() {
        return diningService;
    }

    public Refuelable getRefuelingService() {
        return refuelingService;
    }
}
