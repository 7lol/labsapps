package zad1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 7_lol_000 on 2015-11-10.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("");
        String temp="mama";
        MySimpleList<String>list = new MySimpleList<>(5);
        System.out.println("Is Empty on start: "+list.isEmpty());
        for (int i = 0; i < 25; i++) {
            list.add(temp);
        }
        list.add("tata");
        System.out.println("Printing all elements before remove:");
        list.printAllElements();
        list.remove(temp);
        System.out.println("Printing all elements after remove element \"mama\":");
        list.printAllElements();
        List<String> list2= new ArrayList<>();
        list.add(temp);
        System.out.println("List contains \"tata\" before clear: "+list.contains("tata"));
        System.out.println("Is list Empty before clear: "+list.isEmpty());
        list.putOnPosition((temp+0),0);
        list.putOnPosition((temp+1),1);
        list.putOnPosition((temp+3),3);
        list.printAllElements();
        list.clear();
        System.out.println("Is list Empty after clear: "+list.isEmpty());
        System.out.println("List contains \"tata\" after clear: "+list.contains("tata"));
    }
}
