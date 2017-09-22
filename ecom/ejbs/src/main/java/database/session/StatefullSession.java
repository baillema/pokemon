package database.session;

import database.session.StatefullSessionInterface;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import javax.ejb.Stateful;

@Stateful
public class StatefullSession implements StatefullSessionInterface {

    String user;

    public StatefullSession(){
        user = new String();
    }

    public void addUser(String u) {
        user=u;
    }

    public String getUser() {
        return user;
    }
}