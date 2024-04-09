package org.example;


public enum FileName {
    MD("data/MD.txt"),
    MT("data/MT.txt"),
    MZ("data/MZ.txt"),
    B("data/B.txt"),
    D("data/D.txt");

    private final String fileName;

    FileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
