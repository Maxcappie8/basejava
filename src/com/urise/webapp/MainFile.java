package com.urise.webapp;

import java.io.File;

public class MainFile {

    private final String rootPath;

    public MainFile(String rootPath) {
        this.rootPath = rootPath;
    }

    public static void main(String[] args) {
        File file = new File(".\\");
        printFileName(file, "");
    }

    private static void printFileName(File file, String initialIndent) {

        System.out.println(initialIndent + "|" + file.getName());
        File[] files = file.listFiles();
        if(files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(initialIndent + "|--" + f.getName());
                } else {
                    printFileName(f,initialIndent + "  ");
                }
            }
        }
    }
}