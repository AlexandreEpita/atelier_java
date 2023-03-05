package fr.epita.assistants.embedfiles;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.io.*;
import java.util.stream.Stream;

public class DisplayEmbedFile {
    private final String filename;

    public DisplayEmbedFile(String filename) {
        this.filename = filename;
    }

    public Optional<String> display() {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filename);
        if (inputStream == null)
            return Optional.empty();

        String all = "";
        try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader);)
        {
            String line;
            while ((line = reader.readLine()) != null) {
                all +=  line + "\n";
            }
        }
        catch (Exception e) {
            return Optional.empty();
        }

        return Optional.ofNullable(all);
    }
}
