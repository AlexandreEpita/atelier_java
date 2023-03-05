package fr.epita.assistants.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import java.io.*;

public class Json {
    public static void addToJson(String s1, String s2, String fileName) {

        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        final ObjectMapper mapper = new ObjectMapper();

        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(fileName));

                String line = bufferedReader.readLine();
                String mot = line == null ? "{" : "";

                if (line != null) {
                    mot += line.substring(0, line.length() - 1) + ",";
                }

                bufferedWriter = new BufferedWriter(new FileWriter(fileName));
                bufferedWriter.write(mot + "\"" + s1 + "\":\"" + s2 + "\"}");
            } finally {
                bufferedReader.close();
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
