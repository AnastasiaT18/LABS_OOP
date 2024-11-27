package lab3.task5;

import lab3.task3.Car;

import java.util.HashMap;
import java.util.Map;

public class StatsTracker {
    Map<Car.Types, Integer> carStats;
    Map<Car.Passengers, Integer> passengerStats;
    Map<String, Integer> diningStats;
    Map<Car.Types, Integer> consumptionStats;

    public StatsTracker() {
        carStats = new HashMap<>();
        carStats.put(Car.Types.ELECTRIC,0);
        carStats.put(Car.Types.GAS,0);

        passengerStats = new HashMap<>();
        passengerStats.put(Car.Passengers.PEOPLE, 0);
        passengerStats.put(Car.Passengers.ROBOTS, 0);

        diningStats = new HashMap<>();
        diningStats.put("DINING", 0);
        diningStats.put("NOT_DINING", 0);

        consumptionStats = new HashMap<>();
        consumptionStats.put(Car.Types.ELECTRIC, 0);
        consumptionStats.put(Car.Types.GAS, 0);
    }

    public void updateStats(Car car){
        carStats.put(car.getType(), carStats.get(car.getType())+1);
        passengerStats.put(car.getPassengers(), passengerStats.get(car.getPassengers())+1);
        if(car.isIsDining()){
            diningStats.put("DINING", diningStats.get("DINING")+1);
        }
        else{
            diningStats.put("NOT_DINING", diningStats.get("NOT_DINING")+1);
        }
        consumptionStats.put(car.getType(), consumptionStats.get(car.getType())+car.getConsumption());
    }

    public void printStats(){
        carStats.forEach((k,v)-> System.out.println(k + ": " + v));
        passengerStats.forEach((k,v)-> System.out.println(k + ": " + v));
        diningStats.forEach((k,v)-> System.out.println(k + ": " + v));
        consumptionStats.forEach((k,v)-> System.out.println(k + "(consumption) : " + v));
    }
}
