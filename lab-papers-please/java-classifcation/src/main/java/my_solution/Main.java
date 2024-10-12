package my_solution;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.text.View;
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


            //creating each universe
            Universe starwars = new Universe("starwars");
            Universe marvel = new Universe("marvel");
            Universe hitchhiker = new Universe("hitchhiker");
            Universe rings = new Universe("rings");


            //start classification
            Classifier classifier = new Classifier(individuals,hitchhiker,marvel,rings,starwars);
            classifier.classify();

            //viewing the results
            Viewer viewer = new Viewer(hitchhiker,marvel,rings,starwars);
            viewer.viewResult();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

}





