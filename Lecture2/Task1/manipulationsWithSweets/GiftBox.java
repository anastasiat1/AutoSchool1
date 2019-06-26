package manipulationsWithSweets;

import exceptions.NoSuchElementInCollectionException;
import exceptions.NullSumException;
import utils.ManipulationsWithFile;

import java.util.Collections;

public class GiftBox {

    public static void main(String[] args){
        Gift gift = new Gift();
        ManipulationsWithFile.printList();
        gift.log("\n");
        gift.log("His weight: ");
        try {
            gift.calcWeight();
        } catch (NullSumException e) {
            e.printStackTrace();
        }
        gift.log("\n");
        gift.log("Element by index is: ");
        try {
            gift.getElementByIndex(1);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        gift.log("\n");
        gift.log("Sorted sweets by cost: ");
        Collections.sort(gift.getSweets());
        gift.printListOfSweets();
        gift.log("\n");
        ManipulationsWithFile.writeListOfSweetsToFile(gift.getSweets());
        gift.log("\n");
        gift.log("Info about sweets with name MILKA and weight 50 is: ");
        try {
            gift.findSweetByName("Milka", 50);
        } catch (NoSuchElementInCollectionException noSuchElementInCollection) {
            noSuchElementInCollection.printStackTrace();
        }
    }
}
