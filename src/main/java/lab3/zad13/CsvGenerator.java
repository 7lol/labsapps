package lab3.zad13;

import lab1.zad1.ConfigService;
import lab1.zad3.FileHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 7_lol_000 on 2015-11-20.
 */
public class CsvGenerator {
    int duplicateCount;
    ConfigService config=new ConfigService(GeneratorKeysTable.PROPERTIES_FILE);
    List<CsvData> list= new ArrayList<>();
    List<String> manNames;
    List<String> womanNames;
    List<String> surnames = FileHandler.readLines("SURNAMES.txt");
    List<List<String>> countries = new ArrayList<>();

    public CsvGenerator(){
        manNames = FileHandler.readLines(config.getProperty(GeneratorKeysTable.MALE_LIST));
        womanNames = FileHandler.readLines(config.getProperty(GeneratorKeysTable.FEMALE_LIST));
        surnames = FileHandler.readLines(config.getProperty(GeneratorKeysTable.SURNAMES_LIST));
        for (int i = 0; i <100 ; i++) {
            if(config.getProperty((GeneratorKeysTable.CITES_LIST+i))==null) break;
            countries.add(FileHandler.readLines(config.getProperty(GeneratorKeysTable.CITES_LIST+i)));
        }
    }

    public List<CsvData> getList(){
        return list;
    }

    public void clearList(){
        list.clear();
    }

    public List<CsvData> generateList(int count){
        for (int i = 0; i < count; i++) {
            list.add(new CsvData(manNames,womanNames,surnames,countries));
        }
        return list;
    }

    public static String getHeader(){
        return CsvData.getHeader();
    }

}
