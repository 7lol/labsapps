package csv.data;

import csv.pesel.Pesel;

import java.util.List;
import java.util.Random;

/**
 *
 * Created by 7_lol_000 on 2015-11-19.
 *
 */
public class CsvData {
    Pesel peselnumber;
    boolean male, valid;
    String name, surname, city, country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        CsvData csvData = (CsvData) o;
        return !(o == null || getClass() != o.getClass()) && male == csvData.male &&
                peselnumber.equals(csvData.peselnumber) && name.equals(csvData.name) &&
                surname.equals(csvData.surname) && city.equals(csvData.city) &&
                country.equals(csvData.country);
    }

    @Override
    public int hashCode() {
        int result = peselnumber.hashCode();
        result = 31 * result + (male ? 1 : 0);
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    public CsvData(List<String> manNames, List<String> womanNames, List<String> surnames, List<List<String>> cities) {
        Random generator = new Random();
        List<String> oneCities = cities.get(generator.nextInt(cities.size()));
        city = oneCities.get(generator.nextInt(oneCities.size() - 1) + 1).toUpperCase();
        surname = surnames.get(generator.nextInt(surnames.size())).toUpperCase();
        country = oneCities.get(0).toUpperCase();
        switch (generator.nextInt(2)) {
            case 0: {
                male = false;
                peselnumber = new Pesel(false);
                name = womanNames.get(generator.nextInt(womanNames.size())).toUpperCase();
                break;
            }
            case 1: {
                male = true;
                peselnumber = new Pesel(true);
                name = manNames.get(generator.nextInt(manNames.size())).toUpperCase();
            }
        }
        valid = true;
    }

    public CsvData(String name,Boolean male,String surname, String city,String country,String pesel){
        this.name=name.toUpperCase();
        this.peselnumber=new Pesel(pesel);
        this.surname=surname.toUpperCase();
        this.city=city.toUpperCase();
        this.country=country.toUpperCase();
        this.male=male;
        valid=isValid();
    }

    public CsvData() {
        this.setName("");
        this.setSurname("");
        this.setCity("");
        this.setCountry("");
        this.setMale(true);
        this.setPesel("");
        valid=isValid();
    }

    public CsvData(String data) {
        String[] str = data.split(";");
        if (str.length == 6) {
            peselnumber = new Pesel(str[0]);
            switch (str[1].toUpperCase()) {
                case "MAN": {
                    male = true;
                    break;
                }
                case "WOMAN": {
                    male = false;
                    break;
                }
            }
            name = str[2].toUpperCase();
            surname = str[3].toUpperCase();
            city = str[4].toUpperCase();
            country = str[5].toUpperCase();
            valid = true;
        } else
            valid = false;
    }

    public String getData() {
        String temp;
        if (male) temp = "MAN";
        else temp = "WOMAN";
        return (peselnumber.get() + ";" + temp + ";" + name + ";" + surname + ";" + city + ";" + country);
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public Pesel getPeselnumber() {
        return peselnumber;
    }

    public void setPeselnumber(Pesel peselnumber) {
        this.peselnumber = peselnumber;
    }

    public String getPesel() {
        return peselnumber.get();
    }

    public void setPesel(String peselnumber) {
        this.peselnumber = new Pesel(peselnumber);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isValid() {
        return (valid && (peselnumber.validate(peselnumber.isMale()) && peselnumber.isMale() == isMale()));
    }

    public static String getHeader() {
        return ("pesel;sex;name;surname;city;country");
    }
}
