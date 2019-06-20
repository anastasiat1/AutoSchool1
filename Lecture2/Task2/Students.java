public class Students implements Comparable{
    private String firstName;
    private final int id;
    private String lastName;
    private int age;


    public Students(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAge(){
        return age;
    }

    public String toString(){
        return String.format("Student: %d - %s %s with age %d", id, firstName, lastName, age);
    }

    public int compareTo(Object o) {
        Students tmp = (Students) o;
        if(this.age < tmp.age) {
            return -1;
        }
        else if(this.age > tmp.age) {
            return 1;
        }
        return 0;
    }

    public int getId() {
        return id;
    }

}
