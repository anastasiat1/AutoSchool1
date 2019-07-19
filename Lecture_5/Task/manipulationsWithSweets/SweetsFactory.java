package manipulationsWithSweets;

import exceptions.CantCreateObjectException;
import sweets.*;

public class SweetsFactory {

    public static Sweets createSweet(String name, double cost, double weight, String type) throws CantCreateObjectException {
//да - создаётся конфета, у которой класс шоколад -- возможно, проверить вес и др параметры
        switch (type) {
            case "Chocolate":
                return new Chocolate(name, cost, weight);
            case "Candy":
                return new Candy(name, cost, weight);
            case "Cookie":
                return new Cookie(name, cost, weight);
            case "Marshmallow":
                return new Marshmallow(name, cost, weight);
            default:
                throw new CantCreateObjectException("I can't create sweet of this type");
        }
    }
}
