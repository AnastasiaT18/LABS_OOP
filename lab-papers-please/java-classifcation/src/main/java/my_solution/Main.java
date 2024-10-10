package my_solution;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) throws IOException {

        String pathToFile = "C:\\Users\\User\\Desktop\\Me\\Uni\\2nd Year\\OOP\\LAB1\\lab-papers-please\\java-classifcation\\src\\main\\resources\\test-input.json";

        try {
        ObjectMapper map = new ObjectMapper();

        JsonReader jsonReader = new JsonReader(pathToFile);
        JsonNode data = jsonReader.readFile();
        String stringData = data.toString();

        //CREATED A CONTAINER FOR CLASS REPRESENTATIONS
        List<Individual> individuals = map.readValue(stringData, new TypeReference<List<Individual>>(){});

        //playing around
//        for(Individual individual : individuals) {
//            System.out.println("Individual " + individual.getId());
//            System.out.println(individual.getAge());
//            System.out.println(individual.isHumanoid());
//            System.out.println(individual.getPlanet());
//            System.out.println(individual.getTraits());
//
//        }
            System.out.println("Individuals who are humanoids:");
            for (Individual individual: individuals) {
            if(individual.isHumanoid()) {
                System.out.println("Individual " + individual.getId());
            }
            }
            System.out.println("Individuals who have planets listed:");
            for (Individual individual: individuals) {
                if(individual.getPlanet()!=null) {
                    System.out.println("Individual " + individual.getId());
                }
            }

            System.out.println("Individuals who have traits listed:");
            for (Individual individual: individuals) {
                if(individual.getTraits()!=null) {
                    System.out.println("Individual " + individual.getId());
                }
            }
            System.out.println("Individuals who have age listed:");
            for (Individual individual: individuals) {
                if(individual.getAge()!=0) {
                    System.out.println("Individual " + individual.getId());
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }




