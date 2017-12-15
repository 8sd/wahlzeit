package org.wahlzeit.others;

import java.util.HashSet;

public class EntityManagement<T> {
    private HashSet<T> entities;

    public EntityManagement (){
        entities = new HashSet<T>();
    }

    public T getEntitiy (T obj){
        if(entities.contains(obj)){
            for (T ret : entities) {
                if (ret.equals(obj))
                    return ret;
            }
        }
        entities.add(obj);
        return obj;
    }
}
