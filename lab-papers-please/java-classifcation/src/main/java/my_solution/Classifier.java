package my_solution;

import java.util.Arrays;
import java.util.List;

//class for classifying the individuals
public class Classifier {
    private List<Individual> individuals;
    private Universe hitchhiker;
    private Universe marvel;
    private Universe rings;
    private Universe starwars;

    public Classifier(List<Individual> individuals, Universe hitchhiker, Universe marvel, Universe rings, Universe starwars) {
        this.individuals = individuals;
        this.hitchhiker = hitchhiker;
        this.marvel = marvel;
        this.rings = rings;
        this.starwars = starwars;
    }

    public static boolean compareArrays(List<String> list1, List<String> list2){
        if (list1==null){
            return true;
        }
        for(String element : list1){
            if(!list2.contains(element)){
                return false;
            }
        }
        return true;
    }

    public static boolean isWookie(Individual individual, String human, int age) {
        return ((human.equals("false") || human.equals("null"))
                &&(individual.getPlanet() == Individual.Planet.Kashyyyk || individual.getPlanet()==null)
                &&((age>=0 && age<=400)||age == -1 )
                && (individual.getTraits()==null || compareArrays(individual.getTraits(), Arrays.asList("HAIRY", "TALL"))));
    }

    public static boolean isEwok(Individual individual,String human, int age) {
        return ((human.equals("false") || human.equals("null"))
                &&(individual.getPlanet() == Individual.Planet.Endor || individual.getPlanet()==null)
                &&((age>=0 && age<=60)||age == -1 )
                && (individual.getTraits()==null || compareArrays(individual.getTraits(), Arrays.asList("HAIRY", "SHORT"))));
    }

    public static boolean isAsgardian(Individual individual, String human, int age) {
        return ((human.equals("true") ||human.equals("null"))
                &&(individual.getPlanet() == Individual.Planet.Asgard || individual.getPlanet()==null)
                &&((age>=0 && age<=5000)||age==-1 )
                && (individual.getTraits()==null || compareArrays(individual.getTraits(), Arrays.asList("BLONDE", "TALL"))));
    }

    public static boolean isBetelgeusian(Individual individual, String human, int age) {
        return ((human.equals("true") || human.equals("null"))
                &&(individual.getPlanet() == Individual.Planet.Betelgeuse || individual.getPlanet()==null)
                &&((age>=0 && age<=100)|| age==-1)
                && (individual.getTraits()==null || compareArrays(individual.getTraits(), Arrays.asList("EXTRA_ARMS", "EXTRA_HEAD"))));
    }

    public static boolean isVogons(Individual individual, String human, int age) {
        return ((human.equals("false") || human.equals("null"))
                &&(individual.getPlanet() == Individual.Planet.Vogsphere || individual.getPlanet()==null)
                &&((age>=0 && age<=200)||age==-1)
                && (individual.getTraits()==null || compareArrays(individual.getTraits(), Arrays.asList("GREEN", "BULKY"))));
    }

    public static boolean isElf(Individual individual, String human) {
        return ((human.equals("true") || human.equals("null"))
                &&(individual.getPlanet() == Individual.Planet.Earth || individual.getPlanet()==null)
                && (individual.getTraits()==null || compareArrays(individual.getTraits(), Arrays.asList("BLONDE", "POINTY_EARS"))));
    }

    public static boolean isDwarf(Individual individual, String human, int age) {
        return ((human.equals("true") || human.equals("null"))
                &&(individual.getPlanet() == Individual.Planet.Earth || individual.getPlanet()==null)
                &&((age>=0 && age<=200)||age ==-1 )
                && (individual.getTraits()==null || compareArrays(individual.getTraits(), Arrays.asList("SHORT", "BULKY"))));
    }

    public void classify(){
        String human="";
        int age=0;
      //handling NullPointerExceptions
        for(Individual individual : individuals) {
            if(individual.isHumanoid()==null){
                human="null";
            } else if(individual.isHumanoid()){
                human="true";
            } else{
                human="false";
            }

            if(individual.getAge()==null){
                age=-1;
            } else{
                age=individual.getAge();
            }

            //classification begins
            if(isWookie(individual, human, age) || isEwok(individual, human, age)){
                starwars.addIndividual(individual);
            }
            else if(isAsgardian(individual, human, age)){
                marvel.addIndividual(individual);
            }
            else if(isBetelgeusian(individual, human, age)||isVogons(individual, human, age)){
                hitchhiker.addIndividual(individual);
            }
            else if(isElf(individual, human)||isDwarf(individual, human, age)){
                rings.addIndividual(individual);
            }
        }
    }




}
