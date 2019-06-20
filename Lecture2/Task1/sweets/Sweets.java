package sweets;

public abstract class Sweets implements Comparable  {

    private	String name;
    private double cost;
    private double weight;
    protected String type;

    public Sweets(String name, double cost, double weight, String type){
        this.name = name;
        this.cost = cost;
        this.weight = weight;
        this.type = type;
    }

    public abstract void eat();

    public String getName() {
        return name;
        }

    public double getWeight(){
        return weight;
    }

    @Override
    public String toString() {
        return String.format("|Name: %s |Cost: %.1f |Weight: %.1f, %s", name, cost, weight, type);
    }

    public int compareTo(Object obj) {
        Sweets sw = (Sweets)obj;
        if(this.cost < sw.cost) {
            return -1;
        }
        else if(this.cost > sw.cost) {
            return 1;
        }
        return 0;
    }
}
