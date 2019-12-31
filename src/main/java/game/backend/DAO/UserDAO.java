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

    /**
     * This it's a particular save because if we save with the generic save method there are problems
     * with the foreign keys and the database, this is prepared to be use with the method
     * createQueryINSERTModified() because it works when the atribute it's id not ID
     * In the future will be upgraded to work also with the generic
     * @param myObj
     */
    void saveMyObj(Obj myObj);


}
