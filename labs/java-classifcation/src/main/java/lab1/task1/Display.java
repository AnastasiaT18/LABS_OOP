package lab1.task1;

public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    public Display(){};

    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    public void compareSize(Display m){
      if((this.height * this.width)>(m.height*m.width)){
          System.out.println(this.model + " is greater in size (" + this.height + " x " + this.width + ") than " + m.model + "(" + m.height + " x " + m.width + ")");
      }
      else if((this.height * this.width)<(m.height*m.width)){
          System.out.println(this.model + " is smaller in size (" + this.height + " x " + this.width + ") than " + m.model + "(" + m.height + " x " + m.width + ")");
      }
      else{
          System.out.println(this.model + " and " + m.model + " are equal in size.");
      }
    }

    public void compareSharpness(Display m){
        if(this.ppi>m.ppi){
            System.out.println(this.model + " is greater in sharpness (" + this.ppi + ") than " + m.model + "(" + m.ppi + ")");
        }
        else if(this.ppi<m.ppi){
            System.out.println(this.model + " is lower in sharpness (" + this.ppi + ") than " + m.model + "(" + m.ppi + ")");
        }
        else{
            System.out.println(this.model + " and " + m.model + " are equal in sharpness.");
        }
    }

    public void compareWithMonitor(Display m){
        compareSize(m);
        compareSharpness(m);
    }

    public void displayMonitor(){
        System.out.println("Width: " + this.width);
        System.out.println("Height: " + this.height);
        System.out.println("PPI: " + this.ppi);
        System.out.println("Model: " + this.model + "\n");
    }
}
