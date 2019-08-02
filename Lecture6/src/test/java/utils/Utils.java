package utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Utils {

    public static int chooseRandomElement(List<WebElement> category){
        int index = (int) (Math.random() * category.size());
        return index;
    }
}