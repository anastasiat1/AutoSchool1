import java.util.Scanner;

class MainTask1 {

    public static void main(String[] args) {
        String input = readTextFromConsole();
        reverseString(input);
        everyWordOnNewLine(input);
        replaced(input);
        certainElements(input);
        upperCase(input);
    }

    private static String readTextFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input string: ");
        String scannedString = scanner.nextLine();
        scanner.close();
        return scannedString;
    }

    private static void reverseString(String line) {
        String reverse = new StringBuffer(line).reverse().toString();
        log("Reverse input: ");
        System.out.println(reverse + "\n");
    }

    private static void everyWordOnNewLine(String line) {
        String[] subStr;
        String divider = " ";
        subStr = line.split(divider);
        log("Every word on new line input: ");
        for (int i = 0; i < subStr.length; i++) {
            System.out.println(subStr[i]);
        }
    }

    private static void replaced(String line) {
        log("Replaced input: ");
        System.out.println(line.replaceAll(" ", "*") + "\n");
    }

    private static void upperCase(String line) {
        String strUpper = line.toUpperCase();
        log("Upper Case input: ");
        System.out.println(strUpper + "\n");
    }

    private static void certainElements(String line) {
        log("From 5th to 10th elements input: ");
        System.out.println(line.substring(5,10));
    }

    private static void log(String message){
        System.out.print(message + "\n");
    }
}