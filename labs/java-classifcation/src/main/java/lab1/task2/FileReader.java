package lab1.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    public String readFileIntoString(String path) throws IOException {
        Path filePath = Path.of(path);
        String content = null;
        try {
            content = Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content;
    }

}
