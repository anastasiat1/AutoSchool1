import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTask3 {

    public static void main(String[] args) {
        log("Введите размер грани:");
        int size = read();
        for (int i = 1; i <= size; i++) {
            draw(i, size);
            System.out.println();
        }
        for (int i = size - 1; i >= 1; i--) {
            draw(i, size);
            System.out.println();
        }
    }

    private static void draw(int i, int size) {
        for (int spaces = 0; spaces < size - i; spaces++) {
            System.out.print(' ');
        }
        log("*");
        if (i == 1) return;
        for (int spaces = 0; spaces < 2 * i - 3; spaces++) {
            log(" ");
        }
        log("*");
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
}