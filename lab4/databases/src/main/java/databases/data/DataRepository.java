package databases.data;

import csv.data.CsvData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */

@Repository
public class DataRepository {

    private static List<CsvData> peoples = new ArrayList<>();

    static {
        peoples.add(new CsvData("22071129130;MAN;CLARENCE;ALLISON;MARICOPA_COUNTY;USA"));
        peoples.add(new CsvData("20011243588;WOMAN;KATRINA;ELLIOTT;SLAWKOW;POLAND"));
        peoples.add(new CsvData("36032037518;MAN;TYLER;NICHOLS;CHAMPAIGN;USA"));
    }

    public List<CsvData> getAll() {
        return peoples;
    }

    public void add(CsvData u) {
        peoples.add(u);
    }
    public void add(String u) {
        peoples.add(new CsvData(u));
    }
}
