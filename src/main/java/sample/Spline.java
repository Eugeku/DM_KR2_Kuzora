package sample;

/**
 * Created by Eugene13 on 24.10.2016.
 * Class Spline:
 * 1) Реализована логика дифференцирования с помощью метода сплайнов
 */

class Spline {
    private double a, b, x;
    private double y_1, y_2;
    private double h, h1, h2, aa;
    private int i, n;
    private double[] y;

    //Constructor
    Spline(double a, double b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
        y = new double[n];
    }

    void splineMethod() {
        x = (a + b) / 2;
        h = (b - a) / n;
        aa = a;
        for (i = 0; i <= n - 2; i++) {
            y[i] = (aa) / (Math.sqrt((1 + aa * aa)));
            aa += h;
        }
        i = (int) ((x - a) / h + h / 2);
        h1 = 2 * h;
        h2 = h * h;
        if (i == 0) {
            y_1 = (-3 * y[0] + 4 * y[1] - y[2] / h1);
            y_2 = (2 * y[0] - 5 * y[1] + 4 * y[2] - y[3]) / h2;
        } else if (i > 0 & i < n) {
            y_1 = (-y[i - 1] + y[i + 1]) / h1;
            y_2 = (y[i - 1] - 2 * y[i] + y[i + 1]) / h2;
        } else if (i == n) {
            y_1 = (y[n - 2] - 4 * y[n - 1] + 3 * y[n]) / h1;
            y_2 = (-y[n - 3] + 4 * y[n - 2] - 5 * y[n - 1] + 2 * y[n]) / h2;
        }
    }

    //Getters
    double getX() {
        return this.x;
    }

    double getY_1() {
        return this.y_1;
    }

    double getY_2() {
        return this.y_2;
    }
}
