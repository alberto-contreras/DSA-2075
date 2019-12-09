package game.backend.DAO;

import game.backend.models.User;

import java.util.List;
/**
 * Interface that will manage all the DB operations
 * like get,save...(Specific  QUERY) for USERS
 */

public interface UserDAO {

    User getUserByUsername (User entity, String field);
    //public void updateUser(int employeeID, String name, String surname, double salary);
    //public void deleteUser(int employeeID);

    void deleteUser(User user); // 0 DELETE OKEY 1 DELETE WRONG
}
