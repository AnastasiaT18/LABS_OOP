package my_solution;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Main {
    public static void main(String[] args) throws IOException {

        String pathToFile = "C:\\Users\\User\\Desktop\\Me\\Uni\\2nd Year\\OOP\\oop-course-repo\\lab-papers-please\\java-classifcation\\src\\main\\resources\\input.json";

        try {
            ObjectMapper map = new ObjectMapper();

            JsonReader jsonReader = new JsonReader(pathToFile);
            JsonNode data = jsonReader.readFile();
            String stringData = data.toString();


            //CREATED A CONTAINER FOR CLASS REPRESENTATIONS
            List<Individual> individuals = map.readValue(stringData, new TypeReference<List<Individual>>() {
            });


        //start classification
        //creating each universe
        Universe starwars = new Universe("starwars");
        Universe marvel = new Universe("marvel");
        Universe hitchhiker = new Universe("hitchhiker");
        Universe rings = new Universe("rings");

        //CHECK FOR ID=5 IN INPUT , CAN BE 2 UNIVERSES

        for(Individual individual : individuals) {
            if (individual.getPlanet() != null) {
                switch (individual.getPlanet()) {
                    case Earth:
                        rings.addIndividual(individual);
                        break;
                    case Asgard:
                        marvel.addIndividual(individual);
                        break;
                    case Betelgeuse, Vogsphere:
                        hitchhiker.addIndividual(individual);
                        break;
                    case Kashyyyk, Endor:
                        starwars.addIndividual(individual);
                        break;
                }
            } else {
                if (individual.isHumanoid() == null) {
                    if(individual.getAge()==null){
                        if(compareArrays(individual.getTraits(), Arrays.asList("BLONDE", "TALL"))){
                            marvel.addIndividual(individual);
                        }
                        else if(compareArrays(individual.getTraits(), Arrays.asList("EXTRA_ARMS", "EXTRA_HEAD", "GREEN", "BULKY"))){
                            hitchhiker.addIndividual(individual);
                        }
                        else if(compareArrays(individual.getTraits(), Arrays.asList("BLONDE", "POINTY_EARS", "SHORT", "BULKY"))){
                            rings.addIndividual(individual);
                        }
                        else if(compareArrays(individual.getTraits(), Arrays.asList("HAIRY","SHORT", "TALL"))){
                            starwars.addIndividual(individual);
                        }
                    }else{
                        if(individual.getAge()>=0 && individual.getAge()<=5000 && compareArrays(individual.getTraits(), Arrays.asList("BLONDE", "TALL"))){
                            marvel.addIndividual(individual);
                        }
                        else if(individual.getAge()>=0 && individual.getAge()<=200 && compareArrays(individual.getTraits(), Arrays.asList("EXTRA_ARMS", "EXTRA_HEAD", "GREEN", "BULKY"))){
                            hitchhiker.addIndividual(individual);
                        }
                        else if(((individual.getAge()>=0 && individual.getAge()<=200)||(individual.getAge() > 5000)) && compareArrays(individual.getTraits(), Arrays.asList("BLONDE", "POINTY_EARS", "SHORT", "BULKY"))){
                            rings.addIndividual(individual);
                        }
                        else if(individual.getAge()>=0 && individual.getAge()<=400 && compareArrays(individual.getTraits(), Arrays.asList("HAIRY","SHORT", "TALL"))){
                            starwars.addIndividual(individual);
                        }
                    }

                } else {
                    if (individual.isHumanoid()) {
                        if(individual.getAge()==null){
                            if(compareArrays(individual.getTraits(), Arrays.asList("BLONDE", "TALL"))){
                                marvel.addIndividual(individual);
                            }
                            else if(compareArrays(individual.getTraits(), Arrays.asList("EXTRA_ARMS", "EXTRA_HEAD", "GREEN", "BULKY"))){
                                hitchhiker.addIndividual(individual);
                            }
                            else if(compareArrays(individual.getTraits(), Arrays.asList("BLONDE", "POINTY_EARS", "SHORT", "BULKY"))){
                                rings.addIndividual(individual);
                            }
                        }
                        else{
                            if (individual.getAge() > 0 && individual.getAge() <= 5000 && compareArrays(individual.getTraits(), Arrays.asList("BLONDE", "TALL"))) {
                                marvel.addIndividual(individual);
                            } else if (individual.getAge() > 0 && individual.getAge() <= 200 && compareArrays(individual.getTraits(), Arrays.asList("EXTRA_ARMS", "EXTRA_HEAD", "GREEN", "BULKY"))) {
                                hitchhiker.addIndividual(individual);
                            } else if (((individual.getAge()>=0 && individual.getAge()<=200)||individual.getAge() > 5000)  && compareArrays(individual.getTraits(), Arrays.asList("BLONDE", "POINTY_EARS", "SHORT", "BULKY"))) {
                                rings.addIndividual(individual);
                            }
                        }

                    } else {
                        if(individual.getAge()==null){
                            if(compareArrays(individual.getTraits(), Arrays.asList("HAIRY", "TALL", "SHORT"))){
                                starwars.addIndividual(individual);
                            }
                            else if(compareArrays(individual.getTraits(), Arrays.asList("EXTRA_ARMS", "EXTRA_HEAD", "GREEN", "BULKY"))) {
                                hitchhiker.addIndividual(individual);
                            }
                        }
                        else{
                            if (individual.getAge() > 0 && individual.getAge() <= 400 && compareArrays(individual.getTraits(), Arrays.asList("HAIRY", "TALL", "SHORT"))) {
                                starwars.addIndividual(individual);
                            } else if (individual.getAge() > 0 && individual.getAge() <= 200 && compareArrays(individual.getTraits(), Arrays.asList("EXTRA_ARMS", "EXTRA_HEAD", "GREEN", "BULKY"))) {
                                hitchhiker.addIndividual(individual);
                            }
                        }

                    }
                }
            }
        }

        map.writeValue(new File("C:\\Users\\User\\Desktop\\Me\\Uni\\2nd Year\\OOP\\oop-course-repo\\lab-papers-please\\output\\starwars.json"), starwars);
        map.writeValue(new File("C:\\Users\\User\\Desktop\\Me\\Uni\\2nd Year\\OOP\\oop-course-repo\\lab-papers-please\\output\\marvel.json"),marvel);
        map.writeValue(new File("C:\\Users\\User\\Desktop\\Me\\Uni\\2nd Year\\OOP\\oop-course-repo\\lab-papers-please\\output\\hitchhiker.json"),hitchhiker);
        map.writeValue(new File("C:\\Users\\User\\Desktop\\Me\\Uni\\2nd Year\\OOP\\oop-course-repo\\lab-papers-please\\output\\rings.json"),rings);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean compareArrays(List<String> list1, List<String> list2){
        if (list1==null){
            return true;
        }
        for(String element : list1){
            if(!list2.contains(element)){
                return false;
            }
        }
        return true;
    }


}





