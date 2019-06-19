package manipulationsWithSweets;

import sweets.*;

import java.util.Collections;

public class GiftBox {

    public static void main(String[] args) {
        Gift gift = new Gift();

        gift.log("Your gift box contains: ");
        gift.printListOfSweets();
        gift.log("\n");
        gift.log("His weight: ");
        gift.calcWeight();
        gift.log("\n");
        gift.log("Sorted sweets by cost: ");
        Collections.sort(gift.getSweets());
        gift.printListOfSweets();
        gift.log("\n");
        gift.log("Info about sweets with name MILKA and weight 50 is: ");
        gift.findSweetByName();
    }
}
