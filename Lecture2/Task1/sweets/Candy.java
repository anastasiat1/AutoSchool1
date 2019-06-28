package sweets;

public class Candy extends Sweets {

    private static String type ="Candy";

    public Candy(String name, double cost, double weight){
        super(name, cost, weight, type);
    }

    public void eat() {
        System.out.println("Eat cookie!");}

    @Override
    public String toString(){
        return super.getSweetsData();
    }

}