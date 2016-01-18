package csv;

import csv.data.CsvData;
import csv.data.CsvDataSet;
import csv.generator.BadValueInConfigFile;
import csv.generator.CsvGenerator;
import zad1.ConfigService;
import zad3.FileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Created by 7_lol_000 on 2015-11-19.
 *
 */
public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            switch (args[0].toUpperCase()) {
                case "G": {
                    try {
                        generate();
                    } catch (BadValueInConfigFile badValueInConfigFile) {
                        System.out.println("Wrong value in config file");
                    }
                }
                break;
                default: {
                    proceed();
                }
            }
        } else proceed();
    }

    private static void generate() throws BadValueInConfigFile {
        CsvGenerator generator = new CsvGenerator();
        generator.run();
    }

    private static void proceed() {
        proceed(KeysTable.PROPERTIES_FILE);
    }

    private static void proceed(String configName) {
        CsvDataSet data = new CsvDataSet();
        ConfigService config = new ConfigService(configName);
        List<String> list = FileHandler.readLines(config.getProperty(KeysTable.INPUT));
        List<CsvData> fails = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        list.remove(0);
        list.stream().forEach(obj -> {
            if (!data.add(new CsvData(obj))) fails.add(new CsvData(obj));
        });
        temp.add(CsvData.getHeader());
        temp.addAll(fails.stream().map(CsvData::getData).collect(Collectors.toList()));
        try {
            FileHandler.writeLines(config.getProperty(KeysTable.ERRORS) + ".csv", temp);
        } catch (IOException e) {
            System.out.println("Failed to save file " + (config.getProperty(KeysTable.ERRORS)) + ".csv");
        }
        int i = 0;
        for (List<String> file : data.getSplitedCsv(Integer.parseInt(config.getProperty(KeysTable.ROWS)))) {
            try {
                FileHandler.writeLines((config.getProperty(KeysTable.OUTPUT) + "_" + i + ".csv"), file);
            } catch (IOException e) {
                System.out.println("Failed to save file " + (config.getProperty(KeysTable.OUTPUT) + "_" + i + ".csv"));
            }
            i++;
        }
    }
}