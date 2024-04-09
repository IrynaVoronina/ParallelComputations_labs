package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        DataGenerator dg = new DataGenerator(200);
        double[][] MD = dg.generateMatrix();
        double[][] MT = dg.generateMatrix();
        double[][] MZ = dg.generateMatrix();
        double[] B = dg.generateVector();
        double[] D = dg.generateVector();

        try {
            DataFileWriter writer = new DataFileWriter();
            writer.writeMatrixToFile(MD, FileName.MD.getFileName());
            writer.writeMatrixToFile(MT, FileName.MT.getFileName());
            writer.writeMatrixToFile(MZ, FileName.MZ.getFileName());
            writer.writeVectorToFile(B, FileName.B.getFileName());
            writer.writeVectorToFile(D, FileName.D.getFileName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}