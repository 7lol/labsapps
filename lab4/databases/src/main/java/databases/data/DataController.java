package databases.data;

import csv.data.CsvData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class DataController extends WebMvcConfigurerAdapter {

    @Autowired
    private DataService dataService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("data");
    }

    @RequestMapping(value = "/peoples", method = GET)
    public List<String> get() {
        List<String> dataList=new ArrayList<>();
        dataList.add(dataService.getAll().get(0).getHeader());
        for (CsvData singleData:  dataService.getAll()) {
            dataList.add(singleData.getData());
        }
        return dataList;
    }

    @RequestMapping(value = "/peoples/add", method = GET)
    public String add() {
        dataService.save(new CsvData("06242493091;MAN;DWIGHT;PERRY;AUBURN;USA"));
        return "redirect:/result";
    }

    @RequestMapping(value="/data", method= RequestMethod.GET)
    public String showForm(DataForm dataForm) {
        return "data.html";
    }

    @RequestMapping(value="/data", method=RequestMethod.POST)
    public String checkPersonInfo(@Valid DataForm personForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "data";
        }
        return "redirect:/result";
    }
/*
    @RequestMapping(value="/data", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute CsvData data, Model model) {
        model.addAttribute("data", data);
        return "result";
    }*/
}
