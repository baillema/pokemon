package API.resources.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
public class UserInputSignup {
    @XmlElement public String firstname;
    @XmlElement public String lastname;
    @XmlElement public LocalDate birthday;
    @XmlElement public String email;
    @XmlElement public String password;
    @XmlElement public String password_verify;
    @XmlElement public String handle;
    @XmlElement public String gender;
}
