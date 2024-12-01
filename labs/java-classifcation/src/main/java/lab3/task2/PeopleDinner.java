package lab3.task2;

public class PeopleDinner implements Dineable{

    private static int peopleCarsCount = 0;
    private static int diningPeopleCount = 0;

    @Override
    public void serveDinner(int carID){
        System.out.println("People in car " +carID + " are serving dinner.");
        diningPeopleCount++;
    }

    @Override
    public int getCountCars(){
        return peopleCarsCount;
    }

    @Override
    public void countCars(){
        peopleCarsCount++;
    }

    @Override
    public int getCountDining(){
        return diningPeopleCount;
    }
}
