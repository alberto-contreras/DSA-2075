package game.backend.DAO;
import game.backend.models.Obj;
import game.backend.models.User;

import java.util.HashMap;
import java.util.List;

/**
 * Interface that will manage all the DB operations
 * like get,save...(GENERIC QUERY)
 */

public interface Session <E> {
    void save(Object entity); //Save all objects --> In particular a User
    void close();

    //Object get(Object entity, String field); //Make a SELECT in the DB in order to check the credentials
    //void update(Object object);
    //void delete(Object object);
    //List<Object> findAll(Class theClass);
    //List<Object> query(String query, Class theClass, HashMap params);
}
