package sweets;

public abstract class Sweets implements Comparable  {

    private	String name;
    private double cost;
    private double weight;
    public String type;

    public Sweets(String name, double cost, double weight, String type) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
        this.type = type;
    }

    public String getName() {
        return name;
        }

    public double getWeight(){
        return weight;
    }

    public abstract void eat();

    public String getSweetsData () {
        return String.format("\nType: %s, Name: %s, Cost: %.1f, Weight: %.1f", type, name, cost, weight);
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
