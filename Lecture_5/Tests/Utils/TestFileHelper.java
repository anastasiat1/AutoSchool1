package Utils;

import manipulationsWithSweets.SweetsFactory;
import sweets.Sweets;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestFileHelper {

    private static final String SPLIT_BY = "\\s*(\\s|,)\\s*";
    private static final String WORD = "\\w*";
    private static final String DOUBLE_NUMBER = "\\d*\\.\\d*";
    private static final String FILE_PATH = System.getProperty("user.dir") + "/Data_for_collection.txt";

    public static List<Sweets> testCreateListOfSweetsFromFile() {
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
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
