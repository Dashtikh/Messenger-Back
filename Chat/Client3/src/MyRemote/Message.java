package MyRemote;

import java.util.ArrayList;
import java.util.List;

public class Message {
    int id;
    String message;

    public Message () {}

    public Message(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void makeList() {
        List <Message> messages = new ArrayList<Message>();
        Message m = new Message(1, "salam");
        messages.add(m);
    }

};
