package lab3.zad13.test;

import lab3.zad13.CsvData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 7_lol_000 on 2015-11-20.
 */
public class CsvDataTest {

    @Test
    public void shouldRandomValidData() throws Exception {
        List<String> name=new ArrayList<>();
        List<String> surname=new ArrayList<>();
        List<List<String>> cities=new ArrayList<>();
        List<String> city=new ArrayList<>();
        city.add("POLAND");
        city.add("WROCLAW");
        cities.add(city);
        name.add("JACEK");
        surname.add("PRO");
        CsvData data= new CsvData(name,name,surname,cities);
        System.out.println(data.getData());
        if (!data.getData().contains("POLAND")||!data.getData().contains("WROCLAW")||!data.getData().contains("JACEK")||!data.getData().contains("PRO")) throw new AssertionError();
    }
}