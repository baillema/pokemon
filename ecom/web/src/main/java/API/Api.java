package API;

import API.resources.SearchFromElastic;
import API.resources.Session;
import database.session.StatefullSession;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class Api extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(SearchFromElastic.class);
        classes.add(Session.class);
        return classes;
    }
}
