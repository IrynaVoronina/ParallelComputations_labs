package org.example;

import java.util.Arrays;

public class Task {

    private final double[][] MD;
    private final double[][] MT;
    private final double[][] MZ;
    private final double[] B;
    private final double[] D;

    private final int size;

    public Task(double[][] MD, double[][] MT, double[][] MZ, double[] B, double[] D) {
        this.MD = MD;
        this.MT = MT;
        this.MZ = MZ;
        this.B = B;
        this.D = D;
        this.size = MD.length;
    }

    public double[][] computeMA() {

        double[][] resultMA = new double[size][size];

        double maxMD = findMax(MD);
        double[][] multipliedMTMD = multiplyMTMD();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                resultMA[i][j] = (maxMD * (MT[i][j] + MZ[i][j])) - multipliedMTMD[i][j];
            }
        }
        return resultMA;
    }

    public double[] computeE() {
        double[] resultE = new double[size];
        double sum = 0.0;
        double c = 0.0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double x = (B[j] * MD[i][j]) + (D[j] * MT[i][j]);
                double y = x - c;
                double t = sum + y;
                c = (t - sum) - y;
                sum = t;
            }
            resultE[i] = sum;
        }
        return resultE;
    }

    private double findMax(double[][] matrix) {
        double max = Double.MIN_VALUE;
        for (double[] row : matrix) {
            for (double num : row) {
                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }

    private double[][] multiplyMTMD() {
        double[][] result = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double[] products = new double[size];
                for (int k = 0; k < size; k++) {
                    products[k] = MT[i][k] * MD[k][j];
                }
                Arrays.sort(products);
                double sum = Arrays.stream(products).sum();
                result[i][j] = sum;
            }
        }
        return result;
    }
}