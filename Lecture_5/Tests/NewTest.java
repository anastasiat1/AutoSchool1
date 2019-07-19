import Utils.TestFileHelper;
import exceptions.CantCreateObjectException;
import exceptions.NoSuchElementInCollectionException;
import exceptions.NullSumException;
import manipulationsWithSweets.Gift;
import manipulationsWithSweets.SweetsFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import sweets.Sweets;
import utils.ManipulationsWithFile;

import java.util.ArrayList;
import java.util.List;

public class NewTest {
    private Gift gift = new Gift();
    private List<Sweets> testSweets = new ArrayList<>();

    @Test(groups = "testSweets")
    public void testCalcWeight () throws NullSumException {
        double result = 0;
        for (Sweets sweet : testSweets) {
            result += sweet.getWeight();
        }
        Assert.assertEquals(gift.calcWeight(testSweets), result);
    }

    @Parameters({ "name", "weight" })
    @Test(groups = "testSweets")
    public void testFindSweet (String name, double weight) throws NoSuchElementInCollectionException {
        Sweets result = null;
        for (Sweets sweet : testSweets) {
            if(sweet.getName().equals(name) && sweet.getWeight() == weight) {
                result = sweet;
            }
        }
        Assert.assertEquals(gift.findSweetByName(name, weight, testSweets), result);
    }

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
    public void testCreateSweet (String name, double cost, double weight, String type) throws CantCreateObjectException {
        Sweets sweet = SweetsFactory.createSweet(name, cost, weight, type);
        Assert.assertEquals(name, sweet.getName());
        Assert.assertEquals(weight, sweet.getWeight());
        Assert.assertEquals(cost, sweet.getCost());
        Assert.assertEquals(type, sweet.getType());
    }

    @Test(groups = "other")
    public void testCreateSweetFromFile (){
        List listOfSweets = ManipulationsWithFile.createListOfSweetsFromFile();
        List testListOfSweets = TestFileHelper.testCreateListOfSweetsFromFile();
        Assert.assertEquals(listOfSweets, testListOfSweets);
    }

    @BeforeMethod(groups = "testSweets")
    public void createSweet(){
        try {
            testSweets.add(SweetsFactory.createSweet("Booboo", 3.0, 4.0, "Candy"));
            testSweets.add(SweetsFactory.createSweet("Fooo", 2.0, 3.0, "Marshmallow"));
        } catch (CantCreateObjectException e) {
            e.printStackTrace();
        }
    }
}