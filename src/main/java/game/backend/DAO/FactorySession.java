package game.backend.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactorySession {
    public static Session openSession() {


        Connection conn = getConnection();

        Session session = new SessionImpl(conn);


        return session;
    }
    public static UserDAO openUserDAO() {


        Connection conn = getConnection();

        UserDAO userDAO = new UserDAOImpl(conn);


        return userDAO;
    }



    private static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/2075DB?" +
                            "user=root&password=tor1234567");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
