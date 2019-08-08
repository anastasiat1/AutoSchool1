package utils;

public class Utils {

    public static int getRandomIndex(int min, int max){
        int index = min + (int)(Math.random() * ((max - min) + 1));
        return index;
    }
}