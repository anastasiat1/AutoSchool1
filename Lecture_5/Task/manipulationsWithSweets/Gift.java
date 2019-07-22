package manipulationsWithSweets;

import exceptions.NoSuchElementInCollectionException;
import exceptions.NullSumException;
import sweets.*;
import utils.ManipulationsWithFile;

import java.util.ArrayList;
import java.util.List;

public class Gift {
    private List<Sweets> sweets;

    public Gift() {
        sweets = ManipulationsWithFile.createListOfSweetsFromFile();
    }

    public List<Sweets> findSweetByName(String name, double weight, List<Sweets> sweets) throws NoSuchElementInCollectionException {
        List <Sweets> result = new ArrayList<>();
        try {
            for (Sweets sweet : sweets) {
                if (sweet.getName().equals(name) && sweet.getWeight() == weight) {
                    result.add(sweet);
                }
            }
            if (result == null) {
                throw new NoSuchElementInCollectionException("No such element in this list");
            }
        } catch (IllegalArgumentException illegalArgument) {
            System.out.println("Please, set valid parameters to search");
        }
        printListOfSweets(result);
        return result;
    }

    public List<Sweets> getSweets(){
        return sweets;
    }

    public double calcWeight(List<Sweets> sweets) throws NullSumException {
        double result = 0;
        for (int i = 0; i < sweets.size(); i++) {
            Sweets sweet = sweets.get(i);
            result += sweet.getWeight();
        }
        System.out.println(result);
        if(result == 0){
            throw new NullSumException("You're trying to calculate weight of empty box");
        }
        return result;
    }

    public void printListOfSweets(List<Sweets> sweets) {
        for (Sweets mc : sweets) {
            System.out.println(mc);
        }
        System.out.println();
    }

    public void log(String message){
        System.out.println(message);
    }

    public void getElementByIndex(int index){
        System.out.println(sweets.get(index));
    }
}

