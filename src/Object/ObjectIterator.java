package Object;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.Iterator;
import java.util.List;

public class ObjectIterator implements Iterator<GameObject> {

    int i=0;
    List<GameObject> list;

    public ObjectIterator(List<GameObject> List) {
        this.list = List;
    }

    @Override
    public boolean hasNext() {
        if (i < list.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public GameObject next() {
        return list.get(i++); 

    }

}