package sweets;

public class Chocolate extends Sweets {

    public Chocolate(String name, double cost, double weight, String type){
        super(name, cost, weight, type);
    }

    @Override
    public void eat() {
        System.out.println("Eat chocolates!");
    }

    @Override
    public String toString(){
        return String.format("\nSweets type: %s ", type + super.toString());
    }

}