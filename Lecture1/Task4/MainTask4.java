import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainTask4 {
    public static void main(String[] args){
        String[] names = new String[]{"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        int[] times = new int[]{341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        int n = names.length;
        Runner[] runners = new Runner[n];
        for(int i = 0; i < n; i++) {
            runners[i] = new Runner(names[i], times[i]);
        }
        Arrays.sort(runners);
        for (int i = 0; i < runners.length; i++) {
            log(runners[i].getName() + " " + runners[i].getTime() + "\n");
        }
        log("\n" + "Please, enter the place: ");
        int placeFromMethod = read();
        placeFromMethod = placeFromMethod - 1;
        Runner runner = runners[placeFromMethod];
        log(runner.getName() + " " + runner.getTime());
        log("\n" + "This runner was first: ");
        showResults(0, runners);
        log("\n" + "This runner was second: ");
        showResults(1, runners);
    }

    private static void log(String message){
        System.out.print(message);
    }

    private static Integer read(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int parsedInt = 0;
        try {
            parsedInt = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parsedInt;
    }

    private static void showResults(int place, Runner[] runner){
        log(runner[place].getName() + " " + runner[place].getTime());
    }
}