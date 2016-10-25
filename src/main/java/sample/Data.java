package sample;

/**
 * Created by Eugene13 on 24.10.2016.
 * Class Data:
 * 1) Класс для хранения a,b,n;
 */

class Data {
    private double a, b;
    private int n;
    private int value = 0;

    //Setters and Getters
    double getA() {
        return a;
    }

    void setA(double a) {
        this.a = a;
    }

    double getB() {
        return b;
    }

    void setB(double b) {
        this.b = b;
    }

    int getN() {
        return n;
    }

    void setN(int n) {
        this.n = n;
    }

    int getValue() {
        return value;
    }

    void incValue() {
        this.value++;
    }

    void setValue(int value) {
        this.value = value;
    }
}
