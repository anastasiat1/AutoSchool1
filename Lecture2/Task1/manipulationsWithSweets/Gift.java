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

    public void findSweetByName(String name, double weight) throws NoSuchElementInCollectionException {
        try {
            Sweets result = null;
            for (Sweets sweet : sweets) {
                if(sweet.getName().equals(name) && sweet.getWeight() == weight) {
                    result = sweet;
                    System.out.println(result);
                }
            }
            if(result == null){
                throw new NoSuchElementInCollectionException("No such element in this list");}
        }catch (IllegalArgumentException illegalArgument) {
            System.out.println("Please, set valid parameters to search");
        }
    }

    public List<Sweets> getSweets(){
        return sweets;
    }

    public double calcWeight() throws NullSumException {
        double result = 0;
        for (Sweets sweet : sweets) {
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

