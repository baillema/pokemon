package database.session;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class testSession {
    BufferedReader brConsoleReader = null;
    Properties props;
    InitialContext ctx;
    {
        props = new Properties();
        try {
            props.load(new FileInputStream("jndi.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            ctx = new InitialContext(props);
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        brConsoleReader =
                new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {

        testSession test = new testSession();

        test.testStatelessEjb();
    }

    private void showGUI(){
        System.out.println("**********************");
        System.out.println("Welcome to User");
        System.out.println("**********************");
        System.out.print("Options \n1. Change user\n2. Exit \nEnter Choice: ");
    }

    private void testStatelessEjb(){

        try {
            int choice = 1;

            StatefullSessionInterface sessionBean =
                    (StatefullSessionInterface)ctx.lookup("StatefullSessionInterface/remote");

            while (choice != 2) {
                String user;
                showGUI();
                String strChoice = brConsoleReader.readLine();
                choice = Integer.parseInt(strChoice);
                if (choice == 1) {
                    System.out.print("Enter new user name: ");
                    user = brConsoleReader.readLine();
                    sessionBean.addUser(user);
                } else if (choice == 2) {
                    break;
                }
            }

            String user_res = sessionBean.getUser();

            System.out.println("User change complete: ");
            System.out.println("new user name:" + user_res);

            StatefullSessionInterface BeanStatefull =
                    (StatefullSessionInterface)ctx.lookup("StatefullSessionInterface/remote");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                if(brConsoleReader !=null){
                    brConsoleReader.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}