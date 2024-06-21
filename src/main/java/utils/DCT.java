package utils;

public class DCT {

    public static double[][] applyDCT(double[][] input) {
        int N = input.length;

        double[][] output = new double[N][N];

        for (int u = 0; u < N; u++) {
            for (int v = 0; v < N; v++) {
                double sum = 0.0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        sum += Math.cos(((2 * i + 1) * u * Math.PI) / (2.0 * N))
                                * Math.cos(((2 * j + 1) * v * Math.PI) / (2.0 * N))
                                * input[i][j];
                    }
                }

                double alphaU = (u == 0) ? 1.0 / Math.sqrt(N) : Math.sqrt(2.0 / N);
                double alphaV = (v == 0) ? 1.0 / Math.sqrt(N) : Math.sqrt(2.0 / N);

                output[u][v] = alphaU * alphaV * sum;
            }
        }

        return output;
    }

    public static double[][] inverseDCT(double[][] input) {
        int N = input.length;

        double[][] output = new double[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                double sum = 0.0;

                for (int u = 0; u < N; u++) {
                    for (int v = 0; v < N; v++) {
                        double alphaU = (u == 0) ? 1.0 / Math.sqrt(N) : Math.sqrt(2.0 / N);
                        double alphaV = (v == 0) ? 1.0 / Math.sqrt(N) : Math.sqrt(2.0 / N);

                        sum += alphaU * alphaV * input[u][v]
                                * Math.cos(((2 * i + 1) * u * Math.PI) / (2.0 * N))
                                * Math.cos(((2 * j + 1) * v * Math.PI) / (2.0 * N));
                    }
                }

                output[i][j] = sum;
            }
        }

        return output;
    }
}
