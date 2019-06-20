package sweets;

public class Marshmallow extends Sweets {

    public Marshmallow(String name, double cost, double weight, String type){
        super(name, cost, weight, type);
    }

    @Override
    public void eat() {
        System.out.println("Eat marshmallows!");
    }

    @Override
    public String toString(){
        return String.format("\nSweets type: %s ", type + super.toString());
    }

}