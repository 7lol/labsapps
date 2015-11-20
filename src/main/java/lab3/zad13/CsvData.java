package lab3.zad13;

import java.util.List;
import java.util.Random;

/**
 * Created by 7_lol_000 on 2015-11-19.
 */
public class CsvData {
    Pesel peselnumber;
    boolean male;
    String name, surname, city, country;

    public CsvData(List<String> manNames,List<String> womanNames, List<String> surnames, List<List<String>> cities) {
        Random generator = new Random();
        List<String> oneCities = cities.get(generator.nextInt(cities.size()));
        city = oneCities.get(generator.nextInt(oneCities.size()-1)+1).toUpperCase();
        surname = surnames.get(generator.nextInt(surnames.size() ) ).toUpperCase();
        country = oneCities.get(0).toUpperCase();
        switch (generator.nextInt(2)) {
            case 0: {
                male=false;
                peselnumber = new Pesel(male);
                name = womanNames.get(generator.nextInt(womanNames.size())).toUpperCase();
                break;
            }
            case 1: {
                male=true;
                peselnumber = new Pesel(male);
                name = manNames.get(generator.nextInt(manNames.size())).toUpperCase();
            }
        }
    }

    public CsvData(String data){
        String[] str=data.split(";");
        if(str.length==6){
        peselnumber=new Pesel(str[0]);
        switch (str[1].toUpperCase()){
            case "MAN": {
                male = true;
                break;
            }
            case "WOMAN":{
                male=false;
                break;
            }
        }
        name=str[2].toUpperCase();
        surname=str[3].toUpperCase();
        city=str[4].toUpperCase();
        country=str[5].toUpperCase();}
    }

    public String getData(){
        String temp;
        if (male) temp="MAN"; else temp="WOMAN";
        return (peselnumber.get()+";"+temp+";"+name+";"+surname+";"+city+";"+country);
    }
    public boolean isMale(){return male;}
    public boolean isValid() {return (peselnumber.validate(peselnumber.isMale())&&peselnumber.isMale()==isMale());}
    public static String getHeader() {return ("pesel;sex;name;surname;city;country");}
}
