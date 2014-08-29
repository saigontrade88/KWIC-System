package CS3213;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by junchao on 8/23/2014.
 */
public class Main {

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter movie titles (terminate input by entering empty line) ");

        StringBuilder builder = new StringBuilder();
        String userInput = sc.nextLine();
        String separator = System.lineSeparator();
        while (!userInput.isEmpty()) {
            builder.append(userInput).append(separator);
            userInput = sc.nextLine();
        }

        System.out.println("Enter words to ignore (terminate input by entering empty line) ");
        String inputWordToIgnore = sc.nextLine();
        WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
        while (!inputWordToIgnore.isEmpty()) {
            wordsToIgnore.addWordToIgnore(inputWordToIgnore);
            inputWordToIgnore = sc.nextLine();
        }

        System.out.print(Alphabetizer.alphabetize(
                IgnoreFilter.ignoreFilter(
                        CircularShift.circularShift(
                                builder.toString().toLowerCase()))));

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) );
        System.exit(0);
    }
}
