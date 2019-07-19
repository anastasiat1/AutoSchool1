package sweets;

public class Cookie extends Sweets {

    private static String type = "Cookie";

    public Cookie(String name, double cost, double weight) {
        super(name, cost, weight, type);
    }

    @Override
    public String toString(){
        return super.getSweetsData();
    }

}