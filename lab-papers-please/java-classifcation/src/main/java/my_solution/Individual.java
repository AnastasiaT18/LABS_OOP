package my_solution;

import java.util.Arrays;
import java.util.List;

public class Individual {
    private int id;
    private Boolean humanoid;
    private Planet planet;
    private Integer age;
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

    public Integer getAge() {
        return age;
    }

    public Boolean isHumanoid() {
        return humanoid;
    }

    public Planet getPlanet() {
        return planet;
    }

    public List<String> getTraits() {
        return traits;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHumanoid(Boolean humanoid) {
        this.humanoid = humanoid;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public void setTraits(List<String> traits) {
        this.traits = traits;
    }

}
