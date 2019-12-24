package game.backend.models;

public class Obj {

    private int id;
    private String idObj;
    private String objName;
    private int objAttack;
    private int objDefense;
    private int price;
    private int healthPoints;

    public Obj (String idObj,String objName, int objAttack, int  objDefense, int price, int healthPoints){
        this.idObj = idObj;
        this.objName = objName;
        this.objAttack = objAttack;
        this.objDefense = objDefense;
        this.price = price;
        this.healthPoints = healthPoints;
    }
    public Obj(){
    }

    public String getIdObj() {return idObj;}
    public void setIdObj(String id){this.idObj = id;}
    public String getObjName() {
        return objName;
    }
    public void setObjName(String objName) {
        this.objName = objName;
    }

    public int getObjAttack() {
        return objAttack;
    }
    public void setObjAttack(int objAttack) {
        this.objAttack = objAttack;
    }

    public int getObjDefense() {
        return objDefense;
    }
    public void setObjDefense(int objDefense) {
        this.objDefense = objDefense;
    }

    public int getPrice() { return price; }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}