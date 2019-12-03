package game.backend.models;

public class Obj {

    private String objName;
    private int objAttack;
    private int objDefense;
    private int price;
    //private int healthPoints;

    public Obj (String objName, int objAttack, int  objDefense, int price){
        this.objName = objName;
        this.objAttack = objAttack;
        this.objDefense = objDefense;
        this.price = price;
    }
    public Obj(){
        //RandomUtils ¿?¿
    }

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
}