package sweets;

public class Chocolate extends Sweets {

    private static String type = "Chocolate";

    public Chocolate(String name, double cost, double weight) {
        super(name, cost, weight, type);
    }

    @Override
    public void eat() {
        System.out.println("Eat chocolates!");
    }

    @Override
    public String toString(){
        return super.getSweetsData();
    }

}