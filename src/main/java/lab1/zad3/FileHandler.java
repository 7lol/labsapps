package lab1.zad3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by 7_lol_000 on 2015-10-21.
 *
 */
public class FileHandler {

    public static List<String> readLines(String filename) {
        List<String> linesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            do {
                line = br.readLine();
                if (line != null) linesList.add(line);
            } while (line != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linesList;
    }
    public static void writeLines(String filename,List<String> list) throws IOException {
    BufferedWriter writer = null;
        writer = new BufferedWriter( new FileWriter(filename));
        final BufferedWriter finalWriter = writer;
        for (String line: list
             ) {
            finalWriter.write(line + "\n");
        }
        if ( writer != null) writer.close( );
    }
}

