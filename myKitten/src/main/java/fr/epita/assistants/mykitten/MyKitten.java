package fr.epita.assistants.mykitten;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class MyKitten {
    /**
     * Initializer.
     *
     * @param srcPath Source file path.
     */

    public MyKitten(String srcPath) {
        try {
            streamContent = Files.lines(Paths.get(srcPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Use the streamContent to replace `wordToReplace` with "miaou". Don't forget
     * to add the line number beforehand for each line. Store the new
     * result directly in the streamContent field.
     *
     * @param wordToReplace The word to replace
     */
    public void replaceByMiaou(String wordToReplace) {

        AtomicInteger line = new AtomicInteger();
        this.streamContent = this.streamContent.map(i -> line.incrementAndGet() + " " + i.replaceAll(wordToReplace,"miaou"));
    }

    /**
     * Use the streamContent to write the content into the destination file.
     *
     * @param destPath Destination file path.
     */
    public void toFile(String destPath) throws IOException {
        Path file = Paths.get(destPath);
        Files.write(file, this.streamContent.toList(), StandardCharsets.UTF_8);
    }

    /**
     * Creates an instance of MyKitten and calls the above methods to do it
     * straightforwardly.
     *
     * @param srcPath       Source file path
     * @param destPath      Destination file path
     * @param wordToReplace Word to replace
     */
    public static void miaou(String srcPath, String destPath,
                             String wordToReplace) throws IOException {
        MyKitten res = new MyKitten(srcPath);
        res.replaceByMiaou(wordToReplace);
        res.toFile(destPath);
    }

    public Stream<String> streamContent;
}
