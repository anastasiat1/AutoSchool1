package sweets;

public class Candy extends Sweets {

    public Candy(String name, double cost, double weight, String type){
        super(name, cost, weight, type);
    }

    @Override
    public void eat() {
        System.out.println("Eat candies!");
    }


    @Override
    public String toString(){
        return String.format("\nSweets type: %s ", type + super.toString());
    }

}