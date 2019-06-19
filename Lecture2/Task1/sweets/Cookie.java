package sweets;

public class Cookie extends Sweets {

    public Cookie(String name, double cost, double weight, String type){
        super(name, cost, weight, type);
    }

    @Override
    public void eat() {
        System.out.println("Eat cookies!");
    }

    @Override
    public String toString(){
        return String.format("\nSweets type: %s ", type + super.toString());
    }

}