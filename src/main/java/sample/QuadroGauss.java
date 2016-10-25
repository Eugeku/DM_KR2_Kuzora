package sample;

/**
 * Created by Eugene13 on 24.10.2016.
 * Class QuadroGauss:
 * 1) Реализована логика вычсления интеграла квадратурной формулой Гаусса;
 */

class QuadroGauss {
    private double a, b, res, d, c, h, h1, c1, x1, x2, x3, f1, f3, s1, s2;
    private int i, n;

    //Constructor
    QuadroGauss(double a, double b) {
        this.a = a;
        this.b = b;
    }

    void gaussMethod() {
        c = Math.sqrt(3 / 5);
        h1 = (b - a) / 2;
        c1 = c * h1;
        x2 = (b + a) / 2;
        f1 = Math.sin(x2 - c1);
        f3 = Math.sin(x2 + c1);
        s1 = h1 * (5 * f1 + 8 * Math.sin(x2) + 5 * f3) / 9;
        n = 100;
        do {
            h = (b - a) / n;
            h1 = h / 2;
            c1 = c * h1;
            x2 = a + h1;
            x1 = x2 - c1;
            x3 = x2 + c1;
            s2 = 0;
            for (i = 0; i < n; i++) {
                s2 = s2 + 5 * Math.sin(x1) + 8 * Math.sin(x2) + 5 * Math.sin(x3);
                x1 = x1 + h;
                x2 = x2 + h;
                x3 = x3 + h;
            }
            s2 = s2 * h1 / 9;
            d = Math.abs(s1 - s2) / 63;
            s1 = s2;
            n = 2 * n;
        } while (d > h);
        res = s2;
    }

    //getters
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
