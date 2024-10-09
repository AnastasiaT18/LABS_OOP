package my_solution;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class JsonReader {
    private String path;

    public JsonReader(String path) {

        this.path = path;
    }

    JsonNode readFile() throws IOException {
        ObjectMapper map = new ObjectMapper();
        File inputFile = new File("C:\\Users\\User\\Desktop\\Me\\Uni\\2nd Year\\OOP\\oop-course-repo\\lab-papers-please\\java-classifcation\\src\\main\\resources\\test-input.json");
        JsonNode data = map.readTree(inputFile).get("data");
        return data;
    }
}
