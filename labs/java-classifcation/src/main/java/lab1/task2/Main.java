package lab1.task2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fReader = new FileReader();

        String content = null;
        content = fReader.readFileIntoString(args[0]);

        TextData data = new TextData(content, args[0]);
        data.displayTextData();
    }
}
