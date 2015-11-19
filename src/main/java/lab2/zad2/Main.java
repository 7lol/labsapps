package lab2.zad2;

import java.io.IOException;

/**
 * Created by 7_lol_000 on 2015-11-10.
 */

public class Main {

    public static void main(String[] args) throws IOException{
        AbstractList<Message> messageList;
        if (UserInterface.ask("What kind of queue u want to use FIFO OR LIFO","F".charAt(0),"L".charAt(0))){
            messageList=new FifoList<Message>();
        }else messageList=new LifoList<Message>();
        do{
            if (messageList.getSize()==0||UserInterface.ask("You want to add or read Message?", "W".charAt(0), "R".charAt(0))){
                UserInterface.writeMessage(messageList);
            }else{
                UserInterface.readMessage(messageList);
            }
        }while(UserInterface.ask("Do you want to Continue?","Y".charAt(0),"N".charAt(0)));
    }
}
