package databases.data;

import csv.data.CsvData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pawel on 07.12.15.
 */
@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    public List<CsvData> getAll() {
        return dataRepository.getAll();
    }

    public void save(CsvData u) {
        if (u.isValid()) dataRepository.add(u);
    }
    public void save(String u) {
        CsvData x =new CsvData(u);
        if (x.isValid()){
            dataRepository.add(u);}
    }
}
