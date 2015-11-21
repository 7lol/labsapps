package lab3.zad13.test;

import lab3.zad13.CsvData;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 7_lol_000 on 2015-11-20.
 */
public class CsvDataTest {
    CsvData data;

    private void prepere(String name, String surname, String city, String country) {
        List<String> names = new ArrayList<>();
        List<String> surnames = new ArrayList<>();
        List<List<String>> cities1 = new ArrayList<>();
        List<String> cities = new ArrayList<>();
        cities.add(country);
        cities.add(city);
        cities1.add(cities);
        names.add(name);
        surnames.add(surname);
        data = new CsvData(names, names, surnames, cities1);
    }

    @Test
    public void shouldRandomValidData() throws Exception {
        prepere("JACEK", "PRO", "WROCLAW", "POLAND");
        assertTrue(data.getData().contains("POLAND") && data.getData().contains("WROCLAW") && data.getData().contains("JACEK") && data.getData().contains("PRO"));
    }

    @Test
    public void shouldHaveSameNumberOfDataAsHeaderHas() throws Exception {
        prepere("JACEK", "PRO", "WROCLAW", "POLAND");
        assertEquals(data.getData().split(";").length, CsvData.getHeader().split(";").length);
    }

    @Test
    public void shouldValidProperData() throws Exception {
        data = new CsvData("77051667126;WOMAN;JACEK;PRO;WROCLAW;POLAND");
        assertTrue(data.isValid());
    }

    @Test
    public void shouldntValidNotProperData() throws Exception {
        data = new CsvData("77051667126;MAN;JACEK;PRO;WROCLAW;POLAND");
        assertFalse(data.isValid());
    }

}