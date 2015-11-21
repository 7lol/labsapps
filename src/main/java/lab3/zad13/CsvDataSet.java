package lab3.zad13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by 7_lol_000 on 2015-11-21.
 */
public class CsvDataSet {
    HashSet<CsvData> dataSet = new HashSet<>();

    public boolean add(CsvData data) {
        if (data.isValid()) {
            if (dataSet.add(data)) {
                return true;
            } else
                return false;
        } else
            return false;
    }

    public List<List<String>> getSplitedCsv(int number) {
        List<String> temp = new ArrayList<>();
        int i = 0;
        List<List<String>> splittedList = new ArrayList<>();
        temp.add(CsvData.getHeader());
        for (String lane : getAllCsv()) {
            if (i >= number) {
                i = 0;
                splittedList.add(temp);
                temp = new ArrayList<>();
                temp.add(CsvData.getHeader());
            }
            temp.add(lane);
            i++;
        }
        if (temp.size() > 0) {
            splittedList.add(temp);
        }
        return splittedList;
    }

    public List<String> getAllCsv() {
        List<String> list = new ArrayList<>();
        dataSet.stream().forEach(x -> list.add(x.getData()));
        return list;
    }

    public int size() {
        return dataSet.size();
    }
}
