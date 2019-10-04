package com.xuan;

import java.io.*;
import java.util.Arrays;

/**
 * @author xuan
 */
public final class IOManager {
    public static String inputFile() {
        File file = getFile();
        try {
            InputStream fileInputStream = new FileInputStream(file);
            int index;
            byte[] binaryDate = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder();
            while ((index = fileInputStream.read(binaryDate)) > -1) {
                stringBuilder.append(new String(binaryDate, 0, index));
            }
            fileInputStream.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String readFile() {
        File file = getFile();
        try {
            FileReader fileReader = new FileReader(file);
            char[] date = new char[1024];
            int index;
            StringBuilder stringBuilder = new StringBuilder();
            while ((index = fileReader.read(date))>-1) {
                stringBuilder.append(new String(date,0,index));
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void outputFile(String str) {
        File file = getFile();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            byte[] bytes = str.getBytes();
            System.out.println(Arrays.toString(bytes));
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFiles(String str) {
        File file = getFile();
        try {
            FileWriter fileWriter = new FileWriter(file,true);
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void printFiles(String str) {
        File file = getFile();
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(str);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String bufferedRead() {
        File file = getFile();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String date;
            StringBuilder stringBuilder = new StringBuilder();
            while ((date = bufferedReader.readLine()) !=null) {
                stringBuilder.append(date);

            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static File getFile() {

        return new File("src/main/java/com/xuan/test.txt");
    }

}
