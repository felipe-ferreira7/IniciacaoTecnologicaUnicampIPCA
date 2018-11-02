package util;

public class RegressaoLinear {

    public static double trend(double[] known_y, double[] known_x, double new_x) {
        double[] values = LeastSquaresFitLinear(known_y, known_x);
        return (values[0] * new_x) + values[1];
    }

    public static double[] LeastSquaresFitLinear(double[] known_y, double[] known_x) {
        double M, B;
        if (known_y.length != known_x.length) {
            return new double[]{0, 0};
        }

        int numPoints = known_y.length;

        double x1, y1, xy, x2, J;

        x1 = y1 = xy = x2 = 0.0;
        for (int i = 0; i < numPoints; i++) {
            x1 = x1 + known_x[i];
            y1 = y1 + known_y[i];
            xy = xy + known_x[i] * known_y[i];
            x2 = x2 + known_x[i] * known_x[i];
        }

        M = B = 0;
        J = ((double) numPoints * x2) - (x1 * x1);

        if (J != 0.0) {
            M = (((double) numPoints * xy) - (x1 * y1)) / J;
            B = ((y1 * x2) - (x1 * xy)) / J;
        }
        return new double[]{M, B};
    }

}
