package fr.epita.assistants.mykitten;

import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try {
            MyKitten.miaou("./input.txt", "./output.txt", "test");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
