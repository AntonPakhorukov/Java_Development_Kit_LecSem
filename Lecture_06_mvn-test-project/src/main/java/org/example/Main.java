package org.example;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public void printFile() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("hello.txt");
        System.out.println(new String(inputStream.readAllBytes()));
    }
//    public static void printFile2() throws Exception{
//        InputStream inputStream = Main.class.getResourceAsStream("Hello.txt");
//        System.out.println(new String(inputStream.readAllBytes()));
//    }
    public static void main(String[] args) throws IOException {
        new Main().printFile(); // Вызов файла происходит через вызов класса Main
//        printFile2(); // Вызов метода через статический метод, обращаясь к основному классу Main

    }
}
