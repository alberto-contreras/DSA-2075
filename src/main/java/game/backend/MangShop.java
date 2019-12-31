package game.backend;
import game.backend.models.Obj;
import java.util.List;

public interface MangShop {
    /**Add list of objects that the user have buy
     * @param myList we add it to the DB
     * @return 0-Okey 1-Wrong
     */
    public int addPurchase (List <Obj> myList);
}
