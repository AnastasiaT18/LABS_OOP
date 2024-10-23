package my_solution;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

//class for reading the json file
public class JsonReader {
    private static ObjectMapper map = new ObjectMapper();

    private File path;

    public JsonReader(String path) {
        this.path = new File(path);
    }

    JsonNode readFile(File path, String data) throws IOException {
        return map.readTree(path).get(data);
    }
}
