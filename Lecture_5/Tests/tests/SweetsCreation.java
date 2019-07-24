package tests;

import exceptions.CantCreateObjectException;
import manipulationsWithSweets.SweetsFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sweets.Sweets;
import utils.ManipulationsWithFile;
import utils.TestFileHelper;

import java.util.List;

public class SweetsCreation {
    @DataProvider(name="sweetsData")
    public Object[][] getSweetsData() {
        return new Object[][]
                {
                        { "Booboo", 34.0, 44.80, "Candy" },
                        { "Moomoo", 33.80, 44.70, "Chocolate" },
                        { "Woowoo", 32.60, 44.0, "Cookie" },
                        { "RooRoo", 31.8, 42.0, "Marshmallow" },
                };
    }

    @Test(dataProvider="sweetsData", groups = "other")
    public void testCreateSweetHasCorrectParams (String name, double cost, double weight, String type) throws CantCreateObjectException {
        Sweets sweet = SweetsFactory.createSweet(name, cost, weight, type);
        Assert.assertEquals(name, sweet.getName());
        Assert.assertEquals(weight, sweet.getWeight());
        Assert.assertEquals(cost, sweet.getCost());
        Assert.assertEquals(type, sweet.getType());
    }

    @Test(groups = "other")
    public void testCreateSweetFromFileHasCorrectParams (){
        List listOfSweets = ManipulationsWithFile.createListOfSweetsFromFile();
        List testListOfSweets = TestFileHelper.testCreateListOfSweetsFromFile();
        Assert.assertTrue(listOfSweets.containsAll(testListOfSweets) && testListOfSweets.containsAll(listOfSweets));
    }
}
