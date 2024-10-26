package lab1.task2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fReader = new FileReader();

        String content = null;
        content = fReader.readFileIntoString(args[0]);

        TextData data = new TextData(content, args[0]);

        System.out.println("File name: " + data.getFileName());
        System.out.println("Text in file: " + data.getText());
        System.out.println("Number of vowels: " + data.getNumberOfVowels());
        System.out.println("Number of consonants: " + data.getNumberOfConsonants());
        System.out.println("Number of letters: " + data.getNumberOfLetters());
        System.out.println("Number of sentences: " + data.getNumberOfSentences());
        System.out.println("Longest word: " + data.getLongestWord());
    }
}
