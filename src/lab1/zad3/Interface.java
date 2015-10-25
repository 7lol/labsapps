package lab1.zad3;

import java.io.*;

/**
 * Created by 7_lol_000 on 2015-10-21.
 */
public class Interface {
    boolean allowEmptyLines, allowBrackets;
    String filename;

    Interface(boolean lines, boolean breckets, String filename,LinesCounter counter) {
        counter.setAllowEmptyLines(lines);
        counter.setAllowBrackets(breckets);
        this.filename=filename;
    }

    Interface(LinesCounter counter) {
        counter.setAllowEmptyLines(askYesNo("Czy chcesz by zliczac puste linie"));
        counter.setAllowBrackets(askYesNo("Czy chcesz by zliczac linie z klamrami"));
        filename = askForFile();
    }

    private String askForFile() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename;
        do try {
            System.out.println("Podaj nazwe pliku");
            filename = br.readLine();
            if (!filename.isEmpty()) {
                File f = new File(filename);
                if (f.exists()) {
                    return filename;
                } else
                    System.out.println("Plik nie istnieje");
            }
        } catch (IOException e) {
            System.out.println("Plik nie istnieje");
        } while (true);
    }

    private boolean askYesNo(String str) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String character;
        do try {
            System.out.println(str + " [T/N]");
            character = br.readLine();
            if (!character.isEmpty()) {
                character = character.substring(0, 1);
                if (character.equalsIgnoreCase("t")) return true;
                if (character.equalsIgnoreCase("n")) return false;
            }
        } catch (IOException e) {
            character = "";
        }
        while (!character.equalsIgnoreCase("t") && !character.equalsIgnoreCase("n"));
        return false;
    }
}
