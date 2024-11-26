package lab3.task2;

public class RobotDinner implements Dineable {

    private static int robotCarsCount = 0;

    @Override
    public void serveDinner(String carID){
        System.out.println("Robots in car " +carID + " are serving dinner.");
        robotCarsCount++;
    }

    public int getRobotCarsCount(){
        return robotCarsCount;
    }
}
