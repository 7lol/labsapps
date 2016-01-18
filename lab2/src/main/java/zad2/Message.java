package zad2;

/**
 * Created by 7_lol_000 on 2015-11-10.
 */
public class Message {
    public enum Priority{
        URGENT, NORMAL, LOW
    }
    Priority priority;
    Integer id;
    String name;
    String author;
    Message(Integer id,Priority priority,String name,String author){
        this.id=id;
        this.priority=priority;
        this.name=name;
        this.author=author;
    }
    String getMessage(){
        return priority+" "+" "+id+" "+name+" "+author;
    }
}
