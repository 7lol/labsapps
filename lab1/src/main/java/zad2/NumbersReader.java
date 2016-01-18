package zad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by 7_lol_000 on 2015-10-19.
 *
 */

public class NumbersReader {
    private final List<Number> tab = new ArrayList<>();

    public void splitTab(String str) {
        String[] tempTab = str.split(",");
        for (String temp : tempTab) {
            double parsedDouble = parseToDouble(temp);
            if (parsedDouble != 0.0) {
                boolean duplicate = false;
                for (int i = 0; i < getTab().size(); i++)
                    if (getTab().get(i).getValue() == parsedDouble) {
                        duplicate = true;
                    }
                if (!duplicate)
                    getTab().add(new Number(parsedDouble));
            }

        }

    }

    private static Double parseToDouble(String s) {
        Double temp;
        try {
            temp = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            temp = 0.0;
            e.printStackTrace();
        }
        return temp;
    }

    public static String getString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number(you can use \",\" to enter more than one )");
        String s = "";
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public List<Number> getTab() {
        return tab;
    }

}
