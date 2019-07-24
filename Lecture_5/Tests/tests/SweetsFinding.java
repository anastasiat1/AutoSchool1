package tests;

import exceptions.NoSuchElementInCollectionException;
import manipulationsWithSweets.Gift;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sweets.Sweets;
import utils.BeforeMetodExecutor;

import java.util.ArrayList;
import java.util.List;

public class SweetsFinding extends BeforeMetodExecutor {
    private Gift gift = new Gift();

    @Parameters({ "name", "weight" })
    @Test(groups = "testSweets")
    public void testFindSweetCanFindCertainSweet (String name, double weight) throws NoSuchElementInCollectionException {
        List<Sweets> result = new ArrayList<>();
        for (Sweets sweet : testSweets) {
            if(sweet.getName().equals(name) && sweet.getWeight() == weight) {
                result.add(sweet);
            }
        }
        Assert.assertEquals(gift.findSweetByName(name, weight, testSweets), result);
    }
}
