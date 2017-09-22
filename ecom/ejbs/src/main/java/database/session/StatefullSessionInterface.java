package database.session;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface StatefullSessionInterface {
    void addUser(String user);
    String getUser();
}
