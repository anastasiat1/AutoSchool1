package utils;

import manipulationsWithSweets.SweetsFactory;
import sweets.Sweets;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManipulationsWithFile {

    private static final String SPLIT_BY = "\\s*(\\s|,)\\s*";
    private static final String WORD = "\\w*";
    private static final String DOUBLE_NUMBER = "\\d*\\.\\d*";
    private static final String FILE_PATH = System.getProperty("user.dir") + "/Data_for_collection.txt";

    public static void writeListOfSweetsToFile(List<Sweets> sweets){
        File file = new File(FILE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Sweets sweet : sweets) {
                writer.write((sweet.toString()));
            }
            System.out.println("Your list of sweets is written to " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Something went wrong while file writing");
        }
    }

    public static List<Sweets> createListOfSweetsFromFile() {
        String line;
        System.out.println(FILE_PATH);
        List<Sweets> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH)));
            while ((line = br.readLine()) != null) {
                String[] inputSweetsArray = line.split(SPLIT_BY);
                if (inputSweetsArray[1].matches(WORD) && inputSweetsArray[2].matches(DOUBLE_NUMBER)
                        && inputSweetsArray[3].matches(DOUBLE_NUMBER)) {
                    list.add(SweetsFactory.createSweet(inputSweetsArray[1], Double.parseDouble(inputSweetsArray[2]),
                            Double.parseDouble(inputSweetsArray[3]), inputSweetsArray[0]));
                } else System.out.println("Parameters are incorrect");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void printList() {
        List sweetList = createListOfSweetsFromFile();
        System.out.println("Your giftbox contains: ");
        for (Object mc : sweetList) {
            System.out.print(mc);
        }
        System.out.println();
    }
}