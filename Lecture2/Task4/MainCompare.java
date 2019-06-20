import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.random;

public class MainCompare {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        addToListRandomNumbers(arrayList, 10000000);
        addToListRandomNumbers(linkedList, 10000000);
        log("***ArrayList***\n");
        log ("Time for adding 1000 elements to list is " + calculateTimeToAdd(arrayList) + " nanoseconds\n");
        log("***LinkedList***\n");
        log ("Time for adding 1000 elements to list is " + calculateTimeToAdd(linkedList) + " nanoseconds\n");
        log("\n");
        log("***ArrayList***\n");
        log ("Time for removing 1000 elements from list is " + calculateTimeToRemove(arrayList) + " nanoseconds\n");
        log("***LinkedList***\n");
        log ("Time for removing 1000 elements from list is " + calculateTimeToRemove(linkedList) + " nanoseconds\n");
        log("\n");
        log("***ArrayList***\n");
        log ("Time for finding 1000 elements from list is " + calculateTimeToFind(arrayList) + " nanoseconds\n");
        log("***LinkedList***\n");
        log ("Time for finding 1000 elements from list is " + calculateTimeToFind(linkedList) + " nanoseconds\n");
        log("\n");
        log("Time for adding 1000 elements to list (ARRAY - LINKED) " + (calculateTimeToAdd(arrayList)
                - calculateTimeToAdd(linkedList)));
        log("\n Time for removing 1000 elements from list (ARRAY - LINKED) " + (calculateTimeToRemove(arrayList)
                - calculateTimeToRemove(linkedList)));
        log("\n Time for finding 1000 elements from list (ARRAY - LINKED) " + (calculateTimeToFind(arrayList)
                - calculateTimeToFind(linkedList)));
    }

    private static List<Integer> addToListRandomNumbers (List<Integer> elements, int numberOfElements){
        for(int i = 0; i < numberOfElements; i++) {
            elements.add((int)(random()*100));
        }
        return elements;
    }

    private static void log(String message){
        System.out.print(message);
    }

    private static long measureTime (){
        long time = System.nanoTime();
        return time;
    }

    private static long calculateTimeToAdd (List<Integer> elements){
        long startTimeOfAdd = measureTime();
        addToListRandomNumbers(elements, 1000);
        return measureTime() - startTimeOfAdd;
    }

    private static List<Integer> removeFromList (List<Integer> elements, int numberOfElements){
        for(int i = 0; i < numberOfElements; i++) {
            elements.remove ((Integer) i);
        }
        return elements;
    }

    private static long calculateTimeToRemove (List<Integer> elements){
        long startTimeOfRemove = measureTime();
        removeFromList(elements, 1000);
        return measureTime() - startTimeOfRemove;
    }

    private static List<Integer> findElementsFromList (List<Integer> elements, int criteriaOfFilter, int limit) {
        List<Integer> findedList = elements
                .stream().filter((s) -> s > criteriaOfFilter).limit(limit).collect(Collectors.toList());
        return findedList;
    }

    private static long calculateTimeToFind (List<Integer> elements){
        long startTimeOfFind = measureTime();
        findElementsFromList(elements, 20, 1000);
        return measureTime() - startTimeOfFind;
    }
}
