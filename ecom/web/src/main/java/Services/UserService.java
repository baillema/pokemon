package Services;

public class UserService {

    public static Boolean samePassword(String firstPassword, String secondPasword) {
        return firstPassword.equals(secondPasword);
    }
}
