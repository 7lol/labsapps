package zad3;

import java.io.*;

/**
 *
 * Created by 7_lol_000 on 2015-10-21.
 *
 */
public class Interface {
    final String filename;

    Interface(LinesCounter counter) {
        counter.setAllowEmptyLines(askYesNo("Do you want to count empty lines?"));
        counter.setAllowBrackets(askYesNo("Do you want to count lines with only Brackets"));
        filename = askForFile();
    }

    private String askForFile() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename;
        do try {
            System.out.println("Enter filename");
            filename = br.readLine();
            if (!filename.isEmpty()) {
                File f = new File(filename);
                if (f.exists()) {
                    return filename;
                } else
                    System.out.println("File doesn't exist");
            }
        } catch (IOException e) {
            System.out.println("File doesn't exist");
        } while (true);
    }

    private boolean askYesNo(String str) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String character;
        do try {
            System.out.println(str + " [Y/N]");
            character = br.readLine();
            if (!character.isEmpty()) {
                character = character.substring(0, 1);
                if (character.equalsIgnoreCase("y")) return true;
                if (character.equalsIgnoreCase("n")) return false;
            }
        } catch (IOException e) {
            character = "";
        }
        while (!character.equalsIgnoreCase("y") && !character.equalsIgnoreCase("n"));
        return false;
    }
}
