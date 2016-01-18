package csv.generator;

import csv.data.CsvData;
import csv.data.CsvDataSet;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import zad3.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * Created by 7_lol_000 on 2015-11-20.
 *
 */
public class CsvGeneratorTest {

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
    public void shouldGenerateGoodNumberOfData() throws Exception {
        CsvGenerator generator = new CsvGenerator("temp.conf");
        generator.generateList(5);
        assertEquals(5,generator.getList().size());
    }

    @Test
    public void savingData() throws Exception {
        CsvGenerator generator = new CsvGenerator("temp.conf");
        List<CsvData> list1 = generator.generateList(5);
        List<CsvData> list2 = new ArrayList<>();
        generator.saveToFile();
        List<String> list = FileHandler.readLines(generator.config.getProperty(GeneratorKeysTable.OUTPUT));
        list.remove(0);
        list.stream().forEach(line -> list2.add(new CsvData(line)));
        boolean throwIt = false;
        for (int i = 0; i < list1.size(); i++) {
            throwIt = list1.get(i) == list2.get(i);
            if (throwIt) break;
        }
        tearDown();
        assertFalse(throwIt);
    }

    @Test
    public void shouldGenerateDupesAndFails() throws Exception {
        CsvGenerator generator = new CsvGenerator("temp.conf");
        generator.run();
        CsvDataSet data= new CsvDataSet();
        List<CsvData> fails = new ArrayList<>();
        generator.getList().stream().forEach(obj -> {
            if (!data.add(obj)) fails.add(obj);
        });
        assertTrue(7==data.size()&&3==fails.size());
    }
}