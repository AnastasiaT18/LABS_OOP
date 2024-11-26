package lab3.task2;

public class PeopleDinner implements Dineable{

    private static int peopleCarsCount = 0;

    @Override
    public void serveDinner(String carID){
        System.out.println("People in car " +carID + " are serving dinner.");
        peopleCarsCount++;
    }

    public int getPeopleCarsCount(){
        return peopleCarsCount;
    }
}
