package lab1.task3;
import lab1.task1.Display;

import java.util.ArrayList;
import java.util.List;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    Assistant(String name){
        this.assistantName = name;
        assignedDisplays = new ArrayList<Display>();
    }

    public List<Display> getList(){
        return assignedDisplays;
    }

    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
    }

    public void assist(){
        for(int i=0;i<assignedDisplays.size()-1;i++){
            for(int j=i+1;j<assignedDisplays.size();j++){
                assignedDisplays.get(i).compareWithMonitor(assignedDisplays.get(j));
            }
        }
    }

    public Display buyDisplay(Display d){
        assignedDisplays.remove(d);
        return d;
    }
}
