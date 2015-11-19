package lab2.zad2;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by 7_lol_000 on 2015-11-10.
 */
public class UserInterface {
    public static boolean ask(String ask, Character option1, Character option2) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String character = "";
        do {
            try {
                System.out.println(ask + " [" + option1 + "/" + option2 + "]");
                character = br.readLine();
                if (!character.isEmpty()) {
                    character = character.substring(0, 1);
                    if (character.equalsIgnoreCase(option1.toString())) return true;
                    if (character.equalsIgnoreCase(option2.toString())) return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (!character.equalsIgnoreCase(option1.toString()) && !character.equalsIgnoreCase(option2.toString()));
        throw new IOError(new IOException());
    }

    public static int ask(String ask, Character option1, Character option2, Character option3) throws IOError {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String character = "";
        do {
            try {
                System.out.println(ask + " [" + option1 + "/" + option2 + "]");
                character = br.readLine();
                if (!character.isEmpty()) {
                    character = character.substring(0, 1);
                    if (character.equalsIgnoreCase(option1.toString())) return 1;
                    if (character.equalsIgnoreCase(option2.toString())) return 2;
                    if (character.equalsIgnoreCase(option3.toString())) return 3;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (!character.equalsIgnoreCase(option1.toString()) && !character.equalsIgnoreCase(option2.toString()) && !character.equalsIgnoreCase(option3.toString()));
        throw new IOError(new IOException());
    }

    public static void writeMessage(AbstractList<Message> messageList) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer;
        System.out.println("Type ID of message(non negative number)");
        Integer id,priority = null;
        String name,author;
        do {
            answer = br.readLine();
            id = Integer.parseInt(answer);
        } while (answer.isEmpty() && !(id >= 0));
        System.out.println("Type Priority of message(1=Urgent 2=Normal 3=Low)");
        do {
            answer = br.readLine();
            try {
                priority=Integer.parseInt(answer);
            }
            catch(NumberFormatException e){
                System.out.println("You need to write number 1 or 2 or 3");
                answer=null;
            }
        } while (answer.isEmpty() || !(priority >= 1 && priority <= 3));
        System.out.println("Type text of message");
        do {
            name = br.readLine();
        } while (name.isEmpty());
        System.out.println("Type your name");
        do {
            author = br.readLine();
        } while (name.isEmpty());
        Message message;
        switch (priority){
            case 1:{
                message = new Message(id, Message.Priority.URGENT, name, author);
                break;
            }
            case 2:{
                message = new Message(id, Message.Priority.NORMAL, name, author);
                break;
            }
            case 3:{
                message = new Message(id, Message.Priority.LOW, name, author);
                break;
            }
            default:{
                message = new Message(id, Message.Priority.LOW, name, author);
            }
        }
        messageList.putElement(message);
    }

    public static void readMessage(AbstractList<Message> messageList) {
        System.out.println(messageList.getElement().getMessage());
    }

}
