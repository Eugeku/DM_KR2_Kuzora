package sample;

/**
 * Created by Eugene13 on 24.10.2016.
 * Class Simpson:
 * 1) Реализована логика вычисления интеграла методом Симпсона;
 */
class Simpson {
    private double a, b, h, res, d, f0, f1, s, s1, s2, x1, x2;
    private int n, i;

    //Constructor
    Simpson(double a, double b) {
        this.a = a;
        this.b = b;
    }

    void simpsonMethod() {
        f0 = Math.sin(a);
        f1 = Math.sin(b);
        s = f0 - f1;
        s1 = (b - a) * (f0 + f1 + 4 * Math.sin((a + b) / 2)) / 6;
        n = 100;
        do {
            h = (b - a) / n;
            x1 = a + h / 2;
            x2 = a + h;
            s2 = s;
            for (i = 1; i <= n; i++) {
                s2 = s2 + 4 * Math.sin(x1) + 2 * Math.sin(x2);
                x1 = x1 + h;
                x2 = x2 + h;
            }
            s2 = s2 * h / 6;
            d = Math.abs(s1 - s2) / 15;
            s1 = s2;
            n = n * 2;
        } while (d > h);
        res = s1;
    }

    //Getters
    double getRes() {
        return this.res;
    }

    double getA() {
        return this.a;
    }

    double getB() {
        return this.b;
    }

    double getD() {
        return this.d;
    }
}
