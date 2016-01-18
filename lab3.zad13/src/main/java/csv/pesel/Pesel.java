package csv.pesel;

import java.time.LocalDate;
import java.util.Random;

/**
 *
 * Created by 7_lol_000 on 2015-11-19.
 *
 */
public class Pesel {
    String number;

    public Pesel(String s) {
        number = s;
    }

    public Pesel(Boolean male) {
        generate(male);
    }

    public String get() {
        return number;
    }

    public void set(String number) {
        this.number = number;
    }

    private void generate(Boolean male) {
        Random generator = new Random();
        int minDay = (int) LocalDate.of(1915, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2010, 1, 1).toEpochDay();
        long randomDay = minDay + generator.nextInt(maxDay - minDay);
        String[] str = LocalDate.ofEpochDay(randomDay).toString().split("");
        int x = Integer.parseInt(str[5] + str[6]);
        if (Integer.parseInt(str[0]) == 2) {
            x += 20;
        }
        int sex = generator.nextInt(5) * 2;
        if (male) sex++;
        if (x < 10)
            number = str[2] + str[3] + 0 + x + str[8] + str[9] + generator.nextInt(10) + generator.nextInt(10) + generator.nextInt(10) + sex;
        else
            number = str[2] + str[3] + x + str[8] + str[9] + generator.nextInt(10) + generator.nextInt(10) + generator.nextInt(10) + sex;
        number = number + getLast();
    }

    public boolean validate(boolean male) {
        String str[] = number.split("");
        if (number.length() == 11) {
            if (getLast() == Integer.parseInt(str[str.length - 1])) {
                if (male && Integer.parseInt(str[str.length - 2]) % 2 > 0) return true;
                if (!male && Integer.parseInt(str[str.length - 2]) % 2 <= 0) return true;
            }
        }
        return false;
    }

    public boolean isMale() {
        String str[] = number.split("");
        return ((Integer.parseInt(str[str.length - 2]) % 2) > 0);
    }

    public boolean isFemale() {
        String str[] = number.split("");
        return ((Integer.parseInt(str[str.length - 2]) % 2) <= 0);
    }

    private int getLast() {
        String str[] = number.split("");
        Integer numb = (Integer.parseInt(str[0]) + 3 * Integer.parseInt(str[1]) + 7 * Integer.parseInt(str[2]) + 9 * Integer.parseInt(str[3]) + Integer.parseInt(str[4]) + 3 * Integer.parseInt(str[5]) + 7 * Integer.parseInt(str[6]) + 9 * Integer.parseInt(str[7]) + Integer.parseInt(str[8]) + 3 * Integer.parseInt(str[9]));
        String str2[] = numb.toString().split("");
        if (Integer.parseInt(str2[str2.length - 1]) == 0) return 0;
        return (10 - Integer.parseInt(str2[str2.length - 1]));
    }
}
