package sweets;

public class Marshmallow extends Sweets {

    private static String type = "Marshmallow";

    public Marshmallow(String name, double cost, double weight){
        super(name, cost, weight, type);
    }

    @Override
    public String toString(){
        return super.getSweetsData();
    }

}