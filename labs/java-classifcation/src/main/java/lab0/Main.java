package lab0;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        //path to json file to be read
        String pathToFile = "C:\\Users\\User\\Desktop\\Me\\Uni\\2nd Year\\OOP\\labs\\java-classifcation\\src\\main\\resources\\input.json";

        try {
            ObjectMapper map = new ObjectMapper();

            //reading and parsing the json data
            JsonReader jsonReader = new JsonReader(pathToFile);
            JsonNode data = jsonReader.readFile(new File(pathToFile), "data");
            String stringData = data.toString();

            //creating list of java objects of each individual(alien)
            List<Individual> individuals = map.readValue(stringData, new TypeReference<List<Individual>>() {});

            //creating each universe
            Universe starwars = new Universe("starwars");
            Universe marvel = new Universe("marvel");
            Universe hitchhiker = new Universe("hitchhiker");
            Universe rings = new Universe("rings");

            //classifying the individuals
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





