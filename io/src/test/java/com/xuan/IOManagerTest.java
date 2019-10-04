package com.xuan;

import org.junit.Test;

public class IOManagerTest {

    @Test
    public void inputFile() {
        String s = IOManager.inputFile();
        System.out.println(s);
    }

    @Test
    public void readFile() {

        System.out.println(IOManager.readFile());
    }

    @Test
    public void outputFile() {
        IOManager.outputFile("output");
    }

    @Test
    public void writeFiles() {
        IOManager.writeFiles("write");
    }

    @Test
    public void printFiles() {
        IOManager.printFiles("print");
    }

    @Test
    public void bufferedRead() {
        System.out.println(IOManager.bufferedRead());
    }
}