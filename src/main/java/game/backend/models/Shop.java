package game.backend.models;

import java.util.LinkedList;
import java.util.List;

public class Shop {

    private List<Object> objects = new LinkedList<Object>();

    public class shop {
    }

    public List<Object> getObjects() {
        return objects;
    }
    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }
}