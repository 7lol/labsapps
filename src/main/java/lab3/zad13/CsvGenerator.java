package lab3.zad13;

import lab1.zad1.ConfigService;
import lab1.zad3.FileHandler;

import javax.management.BadAttributeValueExpException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Created by 7_lol_000 on 2015-11-20.
 */
public class CsvGenerator {
    int duplicateCount, failsCount, count;
    public ConfigService config;
    List<CsvData> list = new ArrayList<>();
    List<String> manNames;
    List<String> womanNames;
    List<String> surnames = FileHandler.readLines("SURNAMES.txt");
    List<List<String>> countries = new ArrayList<>();

    public CsvGenerator() throws BadValueInConfigFile {
        this(GeneratorKeysTable.PROPERTIES_FILE);
    }

    public CsvGenerator(String propertiesFile) throws BadValueInConfigFile {
        config = new ConfigService(propertiesFile);
        manNames = FileHandler.readLines(config.getProperty(GeneratorKeysTable.MALE_LIST));
        womanNames = FileHandler.readLines(config.getProperty(GeneratorKeysTable.FEMALE_LIST));
        surnames = FileHandler.readLines(config.getProperty(GeneratorKeysTable.SURNAMES_LIST));
        duplicateCount = Integer.parseInt(config.getProperty(GeneratorKeysTable.DUPES));
        failsCount = Integer.parseInt(config.getProperty(GeneratorKeysTable.FAILS));
        count = Integer.parseInt(config.getProperty(GeneratorKeysTable.COUNT));
        for (int i = 0; i < 100; i++) {
            if (config.getProperty((GeneratorKeysTable.CITES_LIST + i)) == null) break;
            countries.add(FileHandler.readLines(config.getProperty(GeneratorKeysTable.CITES_LIST + i)));
        }
        if (((count * duplicateCount) / 100) + ((count * failsCount) / 100) >= count) throw new BadValueInConfigFile();
    }

    public void run() {
        generateWithFailsAndDupes();
        saveToFile();
        //clearList();
    }

    private void generateWithFailsAndDupes() {
        HashSet<Integer> dupes = new HashSet<>();
        HashSet<Integer> fails = new HashSet<>();
        Random generator = new Random();
        for (int i = 0; i < ((count * duplicateCount) / 100); i++) {
            do {
                dupes.add(generator.nextInt(count));
            } while (dupes.size() <= i);
        }
        int temp;
        for (int i = 0; i < ((count * failsCount) / 100); i++) {
            do {
                do {
                    temp = generator.nextInt(count);
                } while (dupes.contains(temp));
                fails.add(temp);
            } while (fails.size() <= i);
        }
        generateList(count);
        fails.stream().forEach(x -> {
            Integer rand;
            String[] temp2;
            temp2 = list.get(x).getData().split("");
            Random gen = new Random();
            do {
                rand = gen.nextInt(10);
            } while (rand == Integer.parseInt(temp2[9]));
            temp2[9] = rand.toString();
            StringBuilder temp3 = new StringBuilder();
            for (int i = 0; i < temp2.length; i++) {
                temp3.append(temp2[i]);
            }
            set(x, new CsvData(temp3.toString()));
        });
        dupes.stream().forEach(x -> {
            if (x > 0) {
                set(x, list.get(x - 1));
            } else if (list.get(x + 1) != null)
                set(x, list.get(x + 1));
        });
    }

    private void set(int index, CsvData object) {
        list.set(index, object);
    }

    public List<CsvData> getList() {
        return list;
    }

    public void clearList() {
        list.clear();
    }

    public void saveToFile() {
        String filename = config.getProperty(GeneratorKeysTable.OUTPUT);
        List<String> dataToSave = new ArrayList<>();
        dataToSave.add(CsvData.getHeader());
        list.stream().forEach(line -> dataToSave.add(line.getData()));
        try {
            FileHandler.writeLines(filename, dataToSave);
        } catch (IOException e) {
            System.out.println("Failed to save file");
        }
    }

    public List<CsvData> generateList(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new CsvData(manNames, womanNames, surnames, countries));
        }
        return list;
    }

}
