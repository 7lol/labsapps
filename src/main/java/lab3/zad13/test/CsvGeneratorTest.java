package lab3.zad13.test;

import lab3.zad13.CsvGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 7_lol_000 on 2015-11-20.
 */
public class CsvGeneratorTest {
    @Test
    public void shouldGenerateGoodNumberOfData() throws Exception {
        CsvGenerator generator=new CsvGenerator();
        if (generator.generateList(5).size()!=5) throw new AssertionError();
    }

}