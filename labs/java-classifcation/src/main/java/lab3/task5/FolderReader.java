package lab3.task5;

import java.io.File;

public class FolderReader {

    public File[] readDir(String path){
        File folder = new File(path);
        return folder.listFiles();
    }
}
