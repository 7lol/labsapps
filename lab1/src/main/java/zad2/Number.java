package zad2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Created by 7_lol_000 on 2015-10-20.
 *
 */
public class Number {
    private double value;

    public Number(double num) {
        setValue(num);
    }

    private List<Integer> shredNumbers() {
        List<Integer> tempList = new ArrayList<>();
        Double temp = getValue();
        int num;
        if (temp > 0) {
            tempList.add(0);
        }
        for (int i = 10; 1 < temp; i *= 10) {
            num = temp.intValue() % 10;
            tempList.add(num);
            temp = getValue() / i;
        }
        temp = getValue();
        for (int i = 10; (temp.intValue() != temp); i *= 10) {
            temp = getValue() * i;
            num = temp.intValue() % 10;
            tempList.add(num);
        }
        return tempList;
    }

    private List<Integer> sortNumbers() {
        List<Integer> list = shredNumbers();
        Collections.sort(list);
        Collections.reverse(list);
        return list;
    }

    public double getMaxValue() {
        List<Integer> list = sortNumbers();
        double maxValue = 0, tempValue = 0;
        int x = 1;
        for (int i = 10; getValue() / i >= 1; i *= 10) {
            x++;
        }
        for (int i = 0; i <= x - 1; i++) {
            if (tempValue != 0) {
                tempValue *= 10;
            }
            tempValue += list.get(i);
        }
        maxValue += tempValue;
        tempValue = 0;
        for (int i = list.size() - 1; i >= x; i--) {
            tempValue += list.get(i);
            if (tempValue != 0) {
                tempValue /= 10;
            }
        }
        maxValue += tempValue;
        return maxValue;
    }

    public double getValue() {
        return value;
    }

    private void setValue(double value) {
        this.value = value;
    }
}
