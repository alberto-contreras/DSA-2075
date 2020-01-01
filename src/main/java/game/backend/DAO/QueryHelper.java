package game.backend.DAO;

public class QueryHelper {

    public static String createQueryINSERT(Object entity) {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String [] fields = ObjectHelper.getFields(entity);

        sb.append("ID");
        for (String field: fields) {
            if (!field.equals("ID")) sb.append(", ").append(field);
        }

        sb.append(") VALUES (?");

        for (String field: fields) {
            if (!field.equals("ID")) sb.append(", ?");
        }

        sb.append(")");

        return sb.toString();
    }

    public static String createQuerySELECT(Object entity,String field) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE "+field+" = ?");

        return sb.toString();
    }
    public static String createQueryDELETE(Object entity,String field, String field2){
        StringBuffer sb = new StringBuffer();
        sb.append("DELETE FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE "+field+" = ?");
        sb.append(" AND "+field2+" = ?");


        return sb.toString();
    }
    public static String createQueryUPDATE(Object entity,String fieldSet, String fieldSearch) {
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE ").append(entity.getClass().getSimpleName());
        sb.append(" SET "+fieldSet+" = ? WHERE "+fieldSearch+" = ?");//Then we will append which parameter it's the one that give us the reference
        return sb.toString();
    }
    public static String createQueryINSERTModified(Object entity) {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String [] fields = ObjectHelper.getFields(entity);

        sb.append("id");
        for (String field: fields) {
            if (!field.equals("id")) sb.append(", ").append(field);
        }

        sb.append(") VALUES (?");

        for (String field: fields) {
            if (!field.equals("id")) sb.append(", ?");
        }

        sb.append(")");

        return sb.toString();
    }


}
