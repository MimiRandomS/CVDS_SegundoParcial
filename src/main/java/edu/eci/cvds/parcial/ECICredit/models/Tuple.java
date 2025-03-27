package edu.eci.cvds.parcial.ECICredit.models;

public class Tuple <F, S, T>{
    public final F first;
    public final S second;
    public final T third;

    public Tuple(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public F getFirst() { return first; }
    public S getSecond() { return second; }
    public T getThird() { return third; }
}