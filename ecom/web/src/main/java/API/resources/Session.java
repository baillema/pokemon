package API.resources;

import database.session.StatefullSession;
import database.session.StatefullSessionInterface;
import database.session.testSession;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("Sess_test")
public class Session {
    testSession StatefullSession= new testSession();
}
