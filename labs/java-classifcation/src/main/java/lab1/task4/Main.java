package lab1.task4;
import lab1.task2.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        FileReader fReader = new FileReader();
        Contents contents = new Contents();

        for (String arg : args) {
            contents.addContent(new TextData(fReader.readFileIntoString(arg), arg));
        }

        for(TextData content: contents.getContents()){
            content.displayTextData();
        }

    }
}
