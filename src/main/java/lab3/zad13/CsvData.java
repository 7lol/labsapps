package lab3.zad13;

import java.util.List;
import java.util.Random;

/**
 * Created by 7_lol_000 on 2015-11-19.
 */
public class CsvData {
    Pesel peselnumber;
    String name, surname, city, country;

    CsvData(List<String> manNames,List<String> womanNames, List<String> surnames, List<List<String>> cities) {
        Random generator = new Random();
        List<String> oneCities = cities.get(generator.nextInt(cities.size()));
        city = oneCities.get(generator.nextInt(oneCities.size())).toUpperCase();
        surname = surnames.get(generator.nextInt(surnames.size() - 1) + 1);
        country = oneCities.get(0);
        switch (generator.nextInt(2)) {
            case 0: {
                peselnumber = new Pesel(false);
                name = womanNames.get(generator.nextInt(womanNames.size()));
                break;
            }
            case 1: {
                peselnumber = new Pesel(true);
                name = manNames.get(generator.nextInt(manNames.size()));
            }
        }
    }
    public String getData(){
        return (peselnumber.get()+";"+name+";"+surname+";"+city+";"+country);
    }
}
