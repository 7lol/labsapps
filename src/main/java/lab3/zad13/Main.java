package lab3.zad13;

import lab1.zad3.FileHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 7_lol_000 on 2015-11-19.
 */
public class Main {
    public static void main(String[] args) {
        List<String> manNames =FileHandler.readLines("MAN-NAMES.txt");
        List<String> womanNames = FileHandler.readLines("WOMAN-NAMES.txt");
        List<String> surnames = FileHandler.readLines("SURNAMES.txt");
        List<List<String>> countries = new ArrayList<>();
        countries.add(FileHandler.readLines("CITIES_USA.txt"));
        countries.add(FileHandler.readLines("CITIES_POLAND.txt"));
        List<CsvData> lista=new ArrayList<>();
        lista.add(new CsvData(manNames,womanNames,surnames,countries));
        System.out.println(lista.get(0).getData());

    }
}
