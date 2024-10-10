package my_solution;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;

public class Universe {
    private String name;
    private List<JsonNode> creatures;

    public Universe(String name) {
        this.name = name;
        this.creatures = new ArrayList<>();
    }

    //getter = method to get the universe's name
    public String getName(){
        return name;
    }

    //getter = method to see the creatures
    public List<JsonNode> getCreatures(){
        return creatures;
    }

}
