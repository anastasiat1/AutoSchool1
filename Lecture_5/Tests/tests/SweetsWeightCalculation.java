package tests;

import exceptions.NullSumException;
import manipulationsWithSweets.Gift;
import org.testng.Assert;
import org.testng.annotations.Test;
import sweets.Sweets;
import utils.BeforeMetodExecutor;

public class SweetsWeightCalculation extends BeforeMetodExecutor {
    private Gift gift = new Gift();

    @Test(groups = "testSweets")
    public void testCalcWeightCanCalculateWeightOfBox () throws NullSumException {
        double result = 0;
        for (Sweets sweet : testSweets) {
            result += sweet.getWeight();
        }
        Assert.assertEquals(gift.calcWeight(testSweets), result);
    }
}
