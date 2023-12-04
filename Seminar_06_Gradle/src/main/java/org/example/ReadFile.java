package org.example;

import java.io.IOException;
import java.io.InputStream;

public class ReadFile {
    public static void main(String[] args) {
        System.out.println(new ReadFile().readFile());
    }
    public String readFile(){
        // Чтение файла из папки resource.
        // Провалились в папку resource и там ищем файл Test.txt
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Test.txt")){
            String result = new String(inputStream.readAllBytes());
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
