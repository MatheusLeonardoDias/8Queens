package pkg8queens;

public class Tuple extends Object {

    public int first;
    public int second;

    Tuple(int first, int second) {
        this.first = first;
        this.second = second;
    }

    void print() {
        System.out.println("first: " + first + "\nsecond: " + second);
    }

    @Override
    public boolean equals(Object tup) {
        if (tup == null) {
            return false;
        }
        final Tuple other = (Tuple) tup;
        return (this.first == other.first && this.second == other.second);
    }
}
