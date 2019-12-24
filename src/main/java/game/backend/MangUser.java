package game.backend;

import game.backend.models.Game;
import game.backend.models.Obj;
import game.backend.models.User;

import java.util.List;

/**
 * This interface provide information about user, the games that have play and the objects
 */
public interface MangUser {
    public List<Obj> getAllMyObjects(String idPlayer);
    public List<Game> getAllMyGames(String idPlayer);
}
