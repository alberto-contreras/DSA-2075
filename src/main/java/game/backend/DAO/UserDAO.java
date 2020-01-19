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

    /**
     *  We search in the DB the user with the field and then in MangAuthenticationImpl we
     *  check if the password and username are the same in order to login
     * @param entity
     * @param field
     * @return User that we are searching after the SELECT * FROM Users WHERE username = "user.getUsername"
     */
    User getUserByUsername (User entity, String field);

    /**
     * Delete the user
     * @param user
     */
    void deleteUser(User user);

    /**
     * Delete the objects of a user
     * @param user
     */
    void deleteObjs(User user);
    /**
     * Delete the games of a user
     * @param user
     */
    void deleteGames(User user);

    /**
     * Update the money of the user that we send in the entity field
     * @param entity
     */
    void updateUserMoney(User entity);

    /**
     * Update the username of an existing user
     * @param entity
     */
    void updateUsername(User entity);
    /**
     * Update the password of an existing user
     * @param entity
     */
    void updateUserPassword(User entity);

    /**
     * Obtain the list of objects of a user
     * @param idUser
     * @return
     */
    List<Obj> getAllObj (String idUser);

    /**
     * Obtain the list of games of a user
     * @param idUser
     * @return
     */
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
