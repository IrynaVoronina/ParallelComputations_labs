package org.example;


import java.util.Random;

public class DataGenerator {
    private final int size;

    private final double scale = Math.pow(10, 3);

    public DataGenerator(int size) {
        this.size = size;
    }

    public double[][] generateMatrix() {
        double[][] matrix = new double[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Math.ceil(random.nextDouble() * 100 * scale) / scale;
            }
        }
        return matrix;
    }

    public double[] generateVector() {
        double[] vector = new double[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            vector[i] = Math.ceil(random.nextDouble() * 100 * scale) / scale;
        }
        return vector;
    }
}