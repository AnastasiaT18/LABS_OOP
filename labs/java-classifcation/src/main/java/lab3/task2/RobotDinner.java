package lab3.task2;

public class RobotDinner implements Dineable {

    private static int robotCarsCount = 0;
    private static int diningRobotsCount = 0;

    @Override
    public void serveDinner(int carID) {
        System.out.println("Robots in car " + carID + " are serving dinner.");
        diningRobotsCount++;
    }

    @Override
    public int getCountCars() {
        return robotCarsCount;
    }


    @Override
    public void countCars(){
        robotCarsCount++;
    }

    @Override
    public int getCountDining(){
        return diningRobotsCount;
    }
}

