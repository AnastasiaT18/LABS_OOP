package lab1.task4;
import lab1.task2.TextData;
import java.util.List;
import java.util.ArrayList;

public class Contents {
    List<TextData> contents;

    public Contents(){
        contents = new ArrayList<TextData>();
    }

    public void addContent(TextData data){
        contents.add(data);
    }

    List<TextData> getContents(){
        return contents;
    }

}
