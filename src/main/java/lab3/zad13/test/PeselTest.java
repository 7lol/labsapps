package lab3.zad13.test;

import lab3.zad13.Pesel;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 7_lol_000 on 2015-11-19.
 */
public class PeselTest {

    @Test
    public void shouldCheckIfValid() throws Exception {
        Pesel womanPsl = new Pesel("88121202329");
        Pesel manPsl = new Pesel("88121202435");
        assertFalse(!womanPsl.validate(false) || !manPsl.validate(true) || !womanPsl.isFemale() || !manPsl.isMale());
        ;
    }

    @Test
    public void shouldCheckIfNotValid() throws Exception {
        Pesel shortPsl = new Pesel("11111");
        Pesel femalePsl = new Pesel("88121202329");
        Pesel wrongLastNumberPsl = new Pesel("88121202322");
        assertFalse(shortPsl.validate(true) || femalePsl.validate(true) || wrongLastNumberPsl.validate(true));
    }

    @Test
    public void shouldGenerateValidPesel() throws Exception {
        Pesel womanPsl = new Pesel(false);
        Pesel manPsl = new Pesel(true);
        assertFalse(!womanPsl.validate(false) || !manPsl.validate(true));
    }

}