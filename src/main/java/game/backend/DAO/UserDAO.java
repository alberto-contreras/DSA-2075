package game.backend.DAO;

import game.backend.models.Obj;
import game.backend.models.User;
import game.backend.models.Game;

import java.util.List;
/**
 * Interface that will manage all the DB operations
 * like get,save...(Specific  QUERY) for USERS
 */

public interface UserDAO {

    User getUserByUsername (User entity, String field);
    void deleteUser(User user);
    void updateUser(User entity, String field); //
    List<Obj> getAllObj (String idUser);
    List<Game> getAllGame (String idUser);
}
