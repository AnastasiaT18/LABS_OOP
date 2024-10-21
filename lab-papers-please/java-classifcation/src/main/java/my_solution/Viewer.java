package my_solution;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

//class for viewing/outputting the results
public class Viewer {
    private Universe hitchhiker;
    private Universe marvel;
    private Universe rings;
    private Universe starwars;

    public Viewer(Universe hitchhiker, Universe marvel, Universe rings, Universe starwars) {
        this.hitchhiker = hitchhiker;
        this.marvel = marvel;
        this.rings = rings;
        this.starwars = starwars;
    }

    public void viewResult() throws IOException {
        ObjectMapper map = new ObjectMapper();

        String outputFolderPath = "C:\\Users\\User\\Desktop\\Me\\Uni\\2nd Year\\OOP\\oop-course-repo\\lab-papers-please\\my_output";
        File outputFolder = new File(outputFolderPath);

        if(!outputFolder.exists()){
            outputFolder.mkdir();
        }

        map.writeValue(new File(outputFolder,"hitchhiker.json"), hitchhiker);
        map.writeValue(new File(outputFolder,"marvel.json"), marvel);
        map.writeValue(new File(outputFolder,"rings.json"), rings);
        map.writeValue(new File(outputFolder,"starwars.json"), starwars);

    }
}
