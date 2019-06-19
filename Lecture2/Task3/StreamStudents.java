public class StreamStudents{
    private String firstName;
    private final int id;
    private String lastName;
    private int age;

    public StreamStudents(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return String.format("Student: %d - %s %s with age %d", id, firstName, lastName, age);
    }
}