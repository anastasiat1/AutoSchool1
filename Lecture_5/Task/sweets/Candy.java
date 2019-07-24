package sweets;

public class Candy extends Sweets {

    private static String type ="Candy";

    public Candy(String name, double cost, double weight){
        super(name, cost, weight, type);
    }

    @Override
    public String toString(){
        return super.getSweetsData();
    }

}