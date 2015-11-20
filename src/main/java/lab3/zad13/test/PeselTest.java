package lab3.zad13.test;

import lab3.zad13.Pesel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by 7_lol_000 on 2015-11-19.
 */
public class PeselTest {

    @Test
    public void shouldCheckIfValid() throws Exception {
        Pesel womanPsl=new Pesel("88121202329");
        Pesel manPsl=new Pesel("88121202435");
        if (!womanPsl.validate(false)||!manPsl.validate(true)||!womanPsl.isFemale()||!manPsl.isMale()) throw new AssertionError();
    }

    @Test
    public void shouldCheckIfNotValid() throws Exception {
        Pesel shortPsl=new Pesel("11111");
        Pesel femalePsl=new Pesel("88121202329");
        Pesel wrongLastNumberPsl=new Pesel("88121202322");
        if (shortPsl.validate(true)||femalePsl.validate(true)||wrongLastNumberPsl.validate(true)) throw new AssertionError();
    }

    @Test
    public void shouldGenerateValidPesel() throws Exception {
        Pesel womanPsl=new Pesel(false);
        Pesel manPsl=new Pesel(true);
        if (!womanPsl.validate(false)||!manPsl.validate(true)) throw new AssertionError();
    }

}