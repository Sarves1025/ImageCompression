package utils;

public class Quantization {

    public static int[][] quantize(double[][] input) {
        int N = input.length;
        int[][] quantized = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                quantized[i][j] = (int) Math.round(input[i][j]);  // Placeholder quantization
            }
        }

        return quantized;
    }

    public static double[][] inverseQuantize(int[][] quantized, int q) {
        int N = quantized.length;
        double[][] inverseQuantized = new double[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                inverseQuantized[i][j] = quantized[i][j] * q;  // Placeholder inverse quantization
            }
        }

        return inverseQuantized;
    }
}
