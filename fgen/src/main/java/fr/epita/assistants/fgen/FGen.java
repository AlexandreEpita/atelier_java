package fr.epita.assistants.fgen;

import org.codehaus.plexus.util.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class FGen {
    public FGen(final String inputPath){

        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null)
            throw new RuntimeException("class loader failed!");
        InputStream inputStream = classLoader.getResourceAsStream(inputPath);
        if (inputStream == null)
            throw new RuntimeException("input failed!");

        try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);)
        {

            String path = "";
            String file_dir;
            File file;
            String line;
            while ((line = reader.readLine()) != null) {
                file_dir = new String(line.substring(2));
                switch (line.charAt(0)) {
                    case '+':
                        if (file_dir.contains("/")) {
                            if (file_dir.endsWith("/")) {
                                file = new File(path + file_dir);
                                file.mkdirs();
                            }
                            else{
                                int index = file_dir.lastIndexOf("/");
                                String direc = new String(file_dir.substring(0, index));

                                File f1 = new File(path + direc);
                                f1.mkdirs();
                                file = new File(path + file_dir);
                                file.createNewFile();

                            }
                        }
                        else
                        {
                            file = new File(path + file_dir);
                            file.createNewFile();
                        }
                        break;
                    case '>':
                        file = new File(path + file_dir);
                        if (!file.isDirectory())
                            throw new RuntimeException("no path");
                        path += file_dir + ((file_dir.endsWith("/")) ? "" : "/");
                        break;
                    case '-':
                        file = new File(path + file_dir);
                        deleteDirectory(file);
                        break;
                    default:
                        throw new RuntimeException("Command not found: " + line.charAt(0));
                }
            }
        }
        catch (Exception e) {
            throw new RuntimeException("RIP");
        }
    }

    void deleteDirectory(File file) {

        File [] contents = file.listFiles();
        if (contents == null) {
            file.delete();
            return;
        }
        for (File f : contents)
            deleteDirectory(f);
        file.delete();
    }
}
