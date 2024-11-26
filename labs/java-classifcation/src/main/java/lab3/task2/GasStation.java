package lab3.task2;

public class GasStation implements Refuelable{

    private static int gasCarsCount = 0;

    @Override
    public void refuel(int carID){
        System.out.println("Refueling gas car "+ carID +".");
        gasCarsCount++;
    }

    public int getGasCarsCount(){
        return gasCarsCount;
    }
}
