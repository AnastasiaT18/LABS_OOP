package my_solution;

import java.util.ArrayList;
import java.util.List;

//class for each universe
public class Universe {
    private String name;
    private List<Individual> individuals;

    public Universe(String name) {
        this.name = name;
        this.individuals = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Individual> getIndividuals() {
        return individuals;
    }

    public void addIndividual(Individual individual) {
        individuals.add(individual);
    }
}
