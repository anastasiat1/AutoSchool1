package manipulationsWithSweets;

import exceptions.NoSuchElementInCollectionException;
import exceptions.NullSumException;
import sweets.*;
import utils.ManipulationsWithFile;

import java.util.List;

public class Gift {
    private List<Sweets> sweets;

    public Gift() {
        sweets = ManipulationsWithFile.createListOfSweetsFromFile();
    }

    public Sweets findSweetByName(String name, double weight, List<Sweets> sweets) throws NoSuchElementInCollectionException {
        Sweets result = null;
        try {
            for (Sweets sweet : sweets) {
                if (sweet.getName().equals(name) && sweet.getWeight() == weight) {
                    result = sweet;
                    System.out.println(result);
                    return result;
                }
            }
            if (result == null) {
                throw new NoSuchElementInCollectionException("No such element in this list");
            }
        } catch (IllegalArgumentException illegalArgument) {
            System.out.println("Please, set valid parameters to search");
        }
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

    public void printListOfSweets() {
        for (Sweets mc : sweets) {
            System.out.print(mc);
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

