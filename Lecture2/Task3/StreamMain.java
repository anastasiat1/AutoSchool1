import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        List<StreamStudents> student = new ArrayList<>();
        StreamStudents studentOne = new StreamStudents(1, "Katya", "Katyeva", 17);
        student.add(studentOne);
        StreamStudents studentTwo = new StreamStudents(2, "Masha", "Masheva", 18);
        student.add(studentTwo);
        StreamStudents studentThree = new StreamStudents(3, "Sveta", "Svetova", 19);
        student.add(studentThree);
        StreamStudents studentFour = new StreamStudents(4, "Nastya", "Nastyeva", 20);
        student.add(studentFour);
        StreamStudents studentFive = new StreamStudents(5, "Lena", "Lenina", 21);
        student.add(studentFive);
        StreamStudents studentSix = new StreamStudents(6, "Tanya", "Tanina", 22);
        student.add(studentSix);
        StreamStudents studentSeven = new StreamStudents(7, "Vika", "Vikina", 17);
        student.add(studentSeven);
        StreamStudents studentEight = new StreamStudents(8, "Ksyusha", "Ksyushina", 18);
        student.add(studentEight);
        StreamStudents studentNine = new StreamStudents(900, "Zoya", "Zoina", 19);
        student.add(studentNine);
        StreamStudents studentTen = new StreamStudents(101, "Liza", "Lizina", 20);
        student.add(studentTen);
        printStream(student);
        log("\n");
        log("Sorted collection: ");
        List<StreamStudents> sortedList = sortCollectionByAge(student);
        printStream(sortedList);
        log("\n");
        log("Choose the letter that you will find as first in last names of students: ");
        String letterForSearch = readLetterForSearchFromKeyboard();
        log("There are students which last names starts with this letter: ");
        List<StreamStudents> findedList = findLastNameByLetter(student, letterForSearch);
        printStream(findedList);
        log("\n");
        log("Average age of students is: " + getAverageAge(student));
        Map<Integer, StreamStudents> hashmap = createMap(student);
        log("Map is: " + hashmap);
        log("Students with id more than 100 are: " + filterMapByIdMoreThen(student,  100));
    }

    private static void printStream(List<StreamStudents> students) {
        students.forEach((item) -> System.out.println(item));
    }

    private static List<StreamStudents> sortCollectionByAge(List<StreamStudents> students) {
        List<StreamStudents> sortedList = students.stream()
                .sorted(Comparator.comparingInt(StreamStudents::getAge))
                .collect(Collectors.toList());
        return sortedList;
    }

    private static List<StreamStudents> findLastNameByLetter(List<StreamStudents> students, String letterForSearch) {
        List<StreamStudents> findedList = students
                .stream().filter((p)-> p.getLastName().startsWith(letterForSearch)).collect(Collectors.toList());
        return findedList;
    }

    private static double getAverageAge(List<StreamStudents> students) {
        double averageAge = students.stream().mapToInt(p -> p.getAge()).average().getAsDouble();
        return averageAge;
    }

    private static Map<Integer, StreamStudents> createMap(List<StreamStudents> students) {
        Map<Integer, StreamStudents> map = students.stream().collect(Collectors.toMap(x -> x.getId(), x -> x));
        return map;
    }

    private static Map<Integer, StreamStudents> filterMapByIdMoreThen(List<StreamStudents> students, int filterCriteria) {
        Map<Integer, StreamStudents> filteredMap = createMap(students).entrySet().stream()
                .filter(map -> map.getKey() > filterCriteria)
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        return filteredMap;
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
