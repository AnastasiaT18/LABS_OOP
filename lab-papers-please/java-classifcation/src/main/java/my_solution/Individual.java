package my_solution;

import java.util.List;

public class Individual {
    private int id;
    private boolean humanoid;
    private Planet planet;
    private int age;
    public List<String> traits;


    public enum Planet{
        Earth,
        Asgard,
        Betelgeuse,
        Vogsphere,
        Kashyyyk,
        Endor
    }

    public Individual() {
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public boolean isHumanoid() {
        return humanoid;
    }

    public Planet getPlanet() {
        return planet;
    }

    public List<String> getTraits() {
        return traits;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHumanoid(boolean humanoid) {
        this.humanoid = humanoid;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public void setTraits(List<String> traits) {
        this.traits = traits;
    }
}
