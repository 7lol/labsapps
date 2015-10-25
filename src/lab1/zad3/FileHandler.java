package lab1.zad3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by 7_lol_000 on 2015-10-21.
 *
 */
public class FileHandler {

    public List<String> readLines(String filename) {
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
}

