package sweets;

import java.util.Objects;

public class Sweets implements Comparable  {

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

    public double getCost(){
        return cost;
    }

    public double getWeight(){
        return weight;
    }

    public String getType(){
        return type;
    }

    public String getSweetsData () {
        return String.format("Type: %s, Name: %s, Cost: %.1f, Weight: %.1f", type, name, cost, weight);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweets sweet = (Sweets) o;
        return cost == sweet.cost && weight == sweet.weight && Objects.equals(type, sweet.type) &&
                Objects.equals(name, sweet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, weight, type);
    }
}
