package manipulationsWithSweets;

import sweets.*;

import java.util.List;

public class Gift {
    private List<Sweets> sweets;

    public Gift() {
        sweets = RangeOfSweets.defineSweets();
    }

    public void findSweetByName(){
        for (Sweets sweet : sweets) {
            if(sweet.getName().equals("Milka") && sweet.getWeight() == 50){
                System.out.println(sweet);
            }
        }
    }

    public List<Sweets> getSweets(){
        return sweets;
    }

    public double calcWeight(){
        double result = 0;
        for (Sweets sweet : sweets) {
            result += sweet.getWeight();
        }
        System.out.println(result);
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
}
