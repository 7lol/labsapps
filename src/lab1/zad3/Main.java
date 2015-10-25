package lab1.zad3;

import java.util.List;

/**
 * Created by 7_lol_000 on 2015-10-21.
 */
public class Main {

    public static void main(String[] args) {
        LineChecker checker=new LineChecker();
        LinesCounter counter=new LinesCounter();
        Interface inter=new Interface(counter);
        FileHandler fh= new FileHandler();
        List<String> Lines = fh.readLines(inter.filename);
        for (String line : Lines) {
            checker.checkLine(line);
            counter.checkIfCounts(checker);
        }
        System.out.println("Number of lines "+counter.sum());
    }
}
