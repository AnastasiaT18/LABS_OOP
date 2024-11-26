package lab3.task3;

public class Car {
    private int id;
    private Types type;
    private Passengers passengers;
    private boolean isDining;
    private int consumption;

    public enum Types{
        ELECTRIC,
        GAS
    }

    public enum Passengers{
        PEOPLE,
        ROBOTS
    }

    public Car(int id, Types type, Passengers passengers, boolean isDining, int consumption) {
        this.id = id;
        this.type = type;
        this.passengers = passengers;
        this.isDining = isDining;
        this.consumption = consumption;
    }

    public boolean IsDining() {
        return isDining;
    }

    public int getId(){
        return id;
    }


}