import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MainTask2 {

    public static void main(String[] args){

        log("Введите номер дня недели:");
        int day = readLineFromKeyboard();
        switch (day) {
            case 1:
                log("Понедельник");
                break;
            case 2:
                log("Вторник");
                break;
            case 3:
                log("Среда");
                break;
            case 4:
                log("Четверг");
                break;
            case 5:
                log("Пятница");
                break;
            case 6:
                log("Суббота");
                break;
            case 7:
                log("Воскресенье");
                break;
            default:
                log("Ошибка! Такого дня недели не существует");
                break;
        }
    }

    private static Integer readLineFromKeyboard(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int parsedInt = 0;
        try{
            parsedInt = Integer.parseInt(reader.readLine());
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return parsedInt;
    }
    private static void log(String message){
        System.out.println(message);
    }
}