package game.backend.DAO;
import game.backend.models.FormReg;
import game.backend.models.Obj;
import game.backend.models.User;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.sql.*;

import static game.backend.DAO.ObjectHelper.setter;

public class SessionImpl implements Session {

    private final Connection conn;

    private Logger logger = Logger.getLogger(SessionImpl.class);

    public SessionImpl(Connection conn) {
        this.conn = conn;
    }

    /**
     * Method that save in the DB all the objects: User,Obj,Game...
     * @param entity The object that we want to insert into DB
     */
    public void save(Object entity) {
        String insertQuery = QueryHelper.createQueryINSERT(entity);

        logger.debug("insertQuery "+ insertQuery);

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            pstm.setObject(1, 0);
            int i = 2;
            Object value = null;
            for (String field: ObjectHelper.getFields(entity)) {
                if (!field.equals("ID")) {
                    value = ObjectHelper.getter(entity, field);
                    logger.debug("i: "+i+" field "+field+" value "+value);
                    pstm.setObject(i++, value);
                }
            }

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public  Object get(Object entity, String field) { //We put the object and the field with which one we want to find

        String selectQuery = QueryHelper.createQuerySELECT(entity,field);
        logger.debug("Select User Query:"+ selectQuery);
        Object returnObj = new Object();
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(selectQuery);
            int i = 1;
            Object value = null;

            value = ObjectHelper.getter(entity, field);
            pstm.setObject(i, value); //We set in the in the question symbol the value
            logger.debug("FINAL SELECT:"+pstm);
            ResultSet res =pstm.executeQuery(); // Execute the query in the database
            if(res.wasNull()){
                return returnObj;
            }
            res.next();
            ResultSetMetaData rsmd = res.getMetaData();

            for (i=1; i<=rsmd.getColumnCount(); i++) {
                ObjectHelper.setter(returnObj, rsmd.getColumnName(i), res.getObject(i));
            }
            logger.debug("RETURN OBJECT SELECT:"+returnObj.getClass().getDeclaredFields().length);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return returnObj;


    }
    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
