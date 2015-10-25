package lab1.zad2;

/**
 * Created by 7_lol_000 on 2015-10-19.
 */
public class Main {


    public static void main(String[] args) {
        NumbersReader reader = new NumbersReader();
        reader.splitTab(NumbersReader.getString());
        for (Number number : reader.getTab()) {
            System.out.println(number.getValue() + " " + number.getMaxValue());
        }

    }

}
