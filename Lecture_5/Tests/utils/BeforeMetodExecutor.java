package utils;

import exceptions.CantCreateObjectException;
import manipulationsWithSweets.SweetsFactory;
import org.testng.annotations.BeforeMethod;
import sweets.Sweets;

import java.util.ArrayList;
import java.util.List;

public class BeforeMetodExecutor {
    public List<Sweets> testSweets = new ArrayList<>();

    @BeforeMethod(groups = "testSweets")
    public void setUp(){
        try {
            testSweets.add(SweetsFactory.createSweet("Fooo", 3.0, 3.0, "Candy"));
            testSweets.add(SweetsFactory.createSweet("Fooo", 2.0, 3.0, "Marshmallow"));
        } catch (CantCreateObjectException e) {
            e.printStackTrace();
        }
    }
}
