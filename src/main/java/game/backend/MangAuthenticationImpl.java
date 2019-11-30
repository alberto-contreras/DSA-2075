package game.backend;
import game.backend.*;
import game.backend.DAO.FactorySession;
import game.backend.DAO.Session;
import game.backend.DAO.SessionImpl;
import game.backend.models.User;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.sql.Connection;


public class MangAuthenticationImpl implements MangAuthentication {

    private static Logger logger = Logger.getLogger(MangAuthenticationImpl.class);

    public int addUser(User u) {
        //We make the querry to the DB
        Session session = null;
        int employeeID = 0;
        try {
            session = FactorySession.openSession();
            User aux =  session.getUserByUsername(u,"username");
            if((aux.getID() == 0 )){ //If what we get from the database it's empty we insert it
                session.save(u);
                return 0;
        }
        }catch (Exception e) {
            // LOG
            return 1;
        } finally {
            session.close();
        }
        return 1;
    }

    public int checkUser(User u) { // check the user by username and return the user to show initial stats
        Session session = null;
        try {
            session = FactorySession.openSession();
            User a =  session.getUserByUsername(u,"username");// Here we get the user from the database from username
            String username = a.getUsername();
            String password = a.getPassword();
            if((username.equals(u.getUsername()))&&(password.equals(u.getPassword()))){
                u.equals(a); //DUDA
                u.setName(a.getName());
            return 0; //The user exist and we send in the POST the user in the structure UserTO
            }
            return 1;
        } catch (Exception e) {
            // LOG
            return 1;
        } finally {
            session.close();
        }
    }
}

