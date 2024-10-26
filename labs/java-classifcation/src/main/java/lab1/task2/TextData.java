package lab1.task2;

import java.util.ArrayList;

public class TextData {
    String fileName;
    String text;
    int numberOfVowels;
    int numberOfConsonants;
    int numberOfLetters;
    int numberOfSentences;
    String longestWord;

    public TextData(String text, String file){
        this.fileName = file;
        this.text = text;
        this.numberOfVowels = countVowels();
        this.numberOfConsonants = countConsonants();
        this.numberOfLetters = countLetters();
        this.numberOfSentences = countSentences();
        this.longestWord = longestWord();
    }

    String getFileName(){
        return fileName;
    }

    String getText(){
        return text;
    }

    int getNumberOfVowels(){
       return numberOfVowels;
    }

    int getNumberOfConsonants(){
        return numberOfConsonants;
    }

    int getNumberOfLetters(){
        return numberOfLetters;
    }

    int getNumberOfSentences(){
        return numberOfSentences;
    }

    String getLongestWord(){
        return longestWord;
    }

    public int countVowels(){
        int n=0;
        char[] vowels =new char[]{'a', 'e', 'i', 'o', 'u'};
        for(char ch:text.toLowerCase().toCharArray()){
            for(char v:vowels){
                if(ch==v){
                    n++;
                }
            }
        }
        return n;
    }

    public int countConsonants(){
        int n=0;
        String consonants = "bcdfghjklmnpqrstvwxyz";
        ArrayList<Character> c = new ArrayList<Character>();
        for(int i=0;i<consonants.length();i++){
            c.add(consonants.charAt(i));
        }
        for(char ch:text.toLowerCase().toCharArray()){
            if(c.contains(ch)){
                n++;
            }
        }
        return n;
    }

    public int countLetters(){
        int n=0;
        String letters = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<Character> l = new ArrayList<Character>();
        for(int i=0;i<letters.length();i++){
            l.add(letters.charAt(i));
        }
        for(char ch:text.toLowerCase().toCharArray()){
            if(l.contains(ch)){
                n++;
            }
        }
        return n;
    }

    public int countSentences(){
        int n=0;
        String regex = "[.!?]\\s*";
        String[] sentences = text.split(regex);
        for(String s:sentences){
            n++;
        }
        return n;
    }

    public String longestWord(){
        int n=0;
        String regex = "[\\s,.!?]+";
        String[] words = text.split(regex);

        int max=0;
        for(int i=1;i<words.length;i++){
            if(words[i].length()>words[max].length()){
                max=i;
            }
        }
        return words[max];
    }


    }
