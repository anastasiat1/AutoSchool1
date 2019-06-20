import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        HashMap hashmap;
        List<Students> student = new ArrayList<>();
        Students studentOne = new Students(1, "Vanya", "Ivanov", 17);
        student.add(studentOne);
        Students studentTwo = new Students(2, "Petya", "Petrov", 18);
        student.add(studentTwo);
        Students studentThree = new Students(3, "Sidor", "Sidorov", 19);
        student.add(studentThree);
        Students studentFour = new Students(4, "Andrei", "Andreikin", 20);
        student.add(studentFour);
        Students studentFive = new Students(5, "Zhenya", "Zhenin", 21);
        student.add(studentFive);
        Students studentSix = new Students(6, "Pasha", "Pashin", 22);
        student.add(studentSix);
        Students studentSeven = new Students(7, "Yura", "Yurin", 17);
        student.add(studentSeven);
        Students studentEight = new Students(8, "Misha", "Mihailov", 18);
        student.add(studentEight);
        Students studentNine = new Students(900, "Igor", "DIgorev", 19);
        student.add(studentNine);
        Students studentTen = new Students(101, "Dima", "Dmitriev", 20);
        student.add(studentTen);
        log("Choose the letter that you will find as first in last names of students: ");
        String letterForSearch = readLetterForSearchFromKeyboard();
        log("There are students which last names starts with this letter: ");
        findLastNameByLetter(student, letterForSearch);
        log("Sorted collection by age: ");
        Collections.sort(student);
        printCollection (student);
        log("Average age of students is: " + findAverageAge(student));
        hashmap = createHashMap(student);
        log("HashMap is: " + hashmap);
        log("Students with id more than 100 are: ");
        filterHashMapByIdMoreThen(hashmap, 100);
    }

    private static void printCollection(List<Students> students) {
        for (Students mc : students) {
            System.out.println(mc);
        }
        log("\n");
    }

    private static void findLastNameByLetter(List<Students> students, String letterForSearch) {
        for (Students item : students) {
            if (item.getLastName().startsWith(letterForSearch)){
                System.out.println(item);
            }
        }
        log("\n");
    }

    private static double findAverageAge(List<Students> students) {
        double result = 0;
        for (Students item : students) {
                result += item.getAge();
        }
        result = result/students.size();
        return result;
    }

    private static HashMap<Integer, Students> createHashMap(List<Students> studentsList) {
        HashMap<Integer, Students> studentsMap = new HashMap();
        for(Students item : studentsList) {
            studentsMap.put(item.getId(), item);
        }
        return studentsMap;
    }

    private static void filterHashMapByIdMoreThen(HashMap<Integer, List<String>> studentsMap,  int filterCriteria) {
        for (HashMap.Entry<Integer, List<String>> me : studentsMap.entrySet()) {
            if (me.getKey() > filterCriteria) {
                System.out.println(me);
            }
        }
    }

    private static String readLetterForSearchFromKeyboard(){
        String parsedLetter = null;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            parsedLetter = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return parsedLetter;
    }

    private static void log(String message){
        System.out.println(message);
    }
}

