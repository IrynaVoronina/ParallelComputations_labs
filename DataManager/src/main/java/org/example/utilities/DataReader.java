package org.example.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {
    public double[] readVectorFromFile(String filename) throws IOException {
        double[] vector = new double[getLineCount(filename)];
        int index = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                vector[index++] = Double.parseDouble(line);
            }
            return vector;
        }
    }

    public double[][] readMatrixFromFile(String filename) throws IOException {
        int rank = getLineCount(filename);
        double[][] matrix = new double[rank][rank];
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            for (int i = 0; i < rank; i++) {
                String[] values = reader.readLine().split("\t");
                for (int j = 0; j < rank; j++) {
                    matrix[i][j] = Double.parseDouble(values[j]);
                }
            }
        }
        return matrix;
    }

    private int getLineCount(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return (int) reader.lines().count();
        }
    }
}
