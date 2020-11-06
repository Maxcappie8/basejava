package com.urise.webapp;

import java.io.File;

public class MainFile {

    private final String rootPath;

    public MainFile(String rootPath) {
        this.rootPath = rootPath;
    }

    private void printFileName(File file) {
        System.out.println(file.getAbsolutePath());
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                System.out.println("\t - " + f.getName());
            } else {
                printFileName(f);
            }
        }
    }

    public static void main(String[] args) {
        MainFile mainFile = new MainFile(".\\");
        File file = new File(mainFile.rootPath);
        mainFile.printFileName(file);
    }
}
