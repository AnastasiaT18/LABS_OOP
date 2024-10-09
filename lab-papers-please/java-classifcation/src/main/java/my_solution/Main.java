package my_solution;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Universe universe1 = new Universe("Moldova");
        System.out.println("My new universe is " + universe1.getName());

        Universe universe2 = new Universe("Mercury");
        System.out.println("My second universe's name is " + universe2.getName());
        System.out.println("My second universe's list: " + universe2.getCreatures());
    }
}

