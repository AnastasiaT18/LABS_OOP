package my_solution;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {
//        Universe universe1 = new Universe("Moldova");
//        System.out.println("My new universe is " + universe1.getName());
//
//        Universe universe2 = new Universe("Mercury");
//        System.out.println("My second universe's name is " + universe2.getName());
//        System.out.println("My second universe's list: " + universe2.getCreatures());

        String pathToFile = "C:\\Users\\User\\Desktop\\Me\\Uni\\2nd Year\\OOP\\LAB1\\lab-papers-please\\java-classifcation\\src\\main\\resources\\test-input.json";

        JsonReader jsonReader = new JsonReader(pathToFile);
        JsonNode data = jsonReader.readFile();

        System.out.println("Data :" + data.toString());
        //System.out.println("JSON file read successfully.");

        for(JsonNode creature : data){
               System.out.println(creature.toString());
               //System.out.println(creature.get("traits"));
        }


    }
}
