package lab3.zad13.test;

import lab3.zad13.CsvData;
import lab3.zad13.CsvDataSet;
import lab3.zad13.CsvGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 *
 * Created by 7_lol_000 on 2015-11-21.
 *
 */
public class CsvDataSetTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shuouldAddRow() throws Exception {
        CsvGenerator generator = new CsvGenerator();
        CsvDataSet set = new CsvDataSet();
        set.add(generator.generateList(1).get(0));
        assertEquals(1, set.size());
    }

    @Test
    public void shuouldGiveAllRows() throws Exception {
        CsvGenerator generator = new CsvGenerator();
        CsvDataSet set = new CsvDataSet();
        set.add(generator.generateList(2).get(0));
        set.add(generator.getList().get(1));
        assertEquals(2, set.getAllCsv().size());
    }

    @Test
    public void shuouldntAddSameRowTwice() throws Exception {
        CsvGenerator generator = new CsvGenerator();
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