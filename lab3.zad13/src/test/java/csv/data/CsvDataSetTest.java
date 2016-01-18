package csv.data;

import csv.generator.CsvGenerator;
import org.junit.*;
import zad3.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 *
 * Created by 7_lol_000 on 2015-11-21.
 *
 */
public class CsvDataSetTest {


    @BeforeClass
    public static void setUp() {
        List<String> file = new ArrayList<>();
        file.add("melanameslist=../MAN-NAMES.txt");
        file.add("femalenameslist=../WOMAN-NAMES.txt");
        file.add("surnameslist=../SURNAMES.TXT");
        file.add("citieslist0=../CITIES_POLAND.TXT");
        file.add("citieslist1=../CITIES_USA.TXT");
        file.add("outputfile=../TEST.CSV");
        file.add("dupesper100=10");
        file.add("failedper100=20");
        file.add("count=10");
        try {
            FileHandler.writeLines("temp.conf",file);
        } catch (IOException e) {
            System.out.println("Failed to prepere temp file");
        }
    }

    @AfterClass
    public static void tearDown() {
        File file = new File("temp.conf");
        file.deleteOnExit();
    }


    @Test
    public void shuouldAddRow() throws Exception {
        CsvGenerator generator = new CsvGenerator("temp.conf");
        CsvDataSet set = new CsvDataSet();
        set.add(generator.generateList(1).get(0));
        assertEquals(1, set.size());
    }

    @Test
    public void shuouldGiveAllRows() throws Exception {
        CsvGenerator generator = new CsvGenerator("temp.conf");
        CsvDataSet set = new CsvDataSet();
        set.add(generator.generateList(2).get(0));
        set.add(generator.getList().get(1));
        assertEquals(2, set.getAllCsv().size());
    }

    @Test
    public void shuouldntAddSameRowTwice() throws Exception {
        CsvGenerator generator = new CsvGenerator("temp.conf");
        CsvDataSet set = new CsvDataSet();
        CsvData data = generator.generateList(1).get(0);
        set.add(data);
        set.add(data);
        assertEquals(1, set.size());
    }

    @Test
    public void shuouldntAddBadRow() throws Exception {
        CsvDataSet set = new CsvDataSet();
        CsvData data = new CsvData("badData");
        set.add(data);
        assertEquals(0, set.size());
    }


}