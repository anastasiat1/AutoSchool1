public class Runner implements Comparable {
    private final String name;
    private final int time;

    Runner(String name, int time) {
        this.name = name;
        this.time = time;
    }

    String getName() {
        return name;
    }

    int getTime() {
        return time;
    }

    public int compareTo(Object obj) {
        Runner tmp = (Runner)obj;
        if(this.time < tmp.time)
        {
            return -1;
        }
        else if(this.time > tmp.time)
        {
            return 1;
        }
        return 0;
    }
}
