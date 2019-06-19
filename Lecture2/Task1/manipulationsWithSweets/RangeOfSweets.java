package manipulationsWithSweets;

import sweets.*;

import java.util.ArrayList;

public class RangeOfSweets {
    public static ArrayList<Sweets> defineSweets(){
        ArrayList<Sweets> list = new ArrayList();
        Chocolate chocolateOne = new Chocolate("Milka", 1.99, 50, "Chocolate");
        list.add(chocolateOne);
        Chocolate chocolateTwo = new Chocolate("Nestle", 2.51, 45, "Chocolate");
        list.add(chocolateTwo);
        Marshmallow marshmallowOne = new Marshmallow("Haribo", 6.10, 80.1, "Marshmallow");
        list.add(marshmallowOne);
        Marshmallow marshmallowTwo = new Marshmallow("Mega", 8.50, 95.5, "Marshmallow");
        list.add(marshmallowTwo);
        Cookie cookieOne = new Cookie("Slodich", 1.99, 30, "Cookie");
        list.add(cookieOne);
        Cookie cookieTwo = new Cookie("Komunarka", 3.99, 50, "Cookie");
        list.add(cookieTwo);
        Candy candyOne = new Candy("Toptizhka", 0.99, 20, "Candy");
        list.add(candyOne);
        Candy candyTwo = new Candy("Barbaris", 0.89, 10, "Candy");
        list.add(candyTwo);
        return list;
    }
}
