package lab3.task2;

public class PeopleDinner implements Dineable{

//    private static int peopleCarsCount = 0;

    @Override
    public void serveDinner(int carID){
        System.out.println("People in car " +carID + " are serving dinner.");
    }

//    public int getPeopleCarsCount(){
//        return peopleCarsCount;
//    }

//    public void setPeopleCarsCount(){
//        peopleCarsCount++;
//    }
}
