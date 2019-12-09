package game.backend.DAO;

import game.backend.models.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAO{

    private final Connection conn;

    private Logger logger = Logger.getLogger(SessionImpl.class);

    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }


    /**
     *  We search in the DB the user with the field and then in MangAuthenticationImpl we
     *  check if the password and username are the same in order to login
     * @param user
     * @param field
     * @return User that we are searching after the SELECT * FROM Users WHERE username = "user.getUsername"
     */


    public  User getUserByUsername(User user, String field) {
        String selectQuery = QueryHelper.createQuerySELECT(user,field);
        logger.debug("Select User Query:"+ selectQuery);
        User returnUser = new User();
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(selectQuery);
            int i = 1;
            Object value = null;
            value = ObjectHelper.getter(user, field); //Here we get the username of the user that we put as parmeters
            pstm.setObject(i, value); //We set in the in the question symbol the value
            logger.debug("FINAL SELECT:"+pstm);
            ResultSet res =pstm.executeQuery(); // Execute the query in the database
            while(res.next()){
                returnUser.setUsername(res.getString("username"));//We fill the return User with
                returnUser.setPassword(res.getString("password"));//what we obtain from the DB
                returnUser.setName(res.getString("name"));
                returnUser.setID(res.getInt("ID"));
                returnUser.setAttack(res.getInt("attack"));
                returnUser.setDefense(res.getInt("defense"));
                returnUser.setHealthPoints(res.getInt("healthpoints"));
                returnUser.setMoney(res.getInt("money"));
                returnUser.setID(res.getInt("ID"));
            }
            //logger.debug("FINAL User to return:"+returnUser.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnUser;
    }

    public void deleteUser(User user){

        String selectQuery = QueryHelper.createQueryDELETE(user,"username","password");
        logger.debug("DELETE User Query:"+ selectQuery);
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(selectQuery);
            Object value = null;
            int i = 1;
            value = ObjectHelper.getter(user, "username");//We get the value of the username
            pstm.setObject(i, value); //We set in the in the question symbol the value
            value = ObjectHelper.getter(user, "password");//We get the value of the password
            i=i+1;
            pstm.setObject(i, value);
            logger.debug("FINAL DELETE:"+pstm);
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
