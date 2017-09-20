package API.resources.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserLog {
    @XmlElement public String email;
    @XmlElement public String password;
}


