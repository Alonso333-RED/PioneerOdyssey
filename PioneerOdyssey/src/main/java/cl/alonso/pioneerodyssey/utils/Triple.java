package cl.alonso.pioneerodyssey.utils;

public class Triple<X, Y, Z> {
    public final X first;
    public final Y second;
    public final Z third;

    public Triple(X first, Y second, Z third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public X getFirst() { return first; }
    public Y getSecond() { return second; }
    public Z getThird() { return third; }

}
