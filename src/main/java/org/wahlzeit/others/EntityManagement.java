package org.wahlzeit.others;

import org.wahlzeit.model.CartesianCoordinate;
import org.wahlzeit.model.SphericCoordinate;
import org.wahlzeit.others.annotations.*;

import java.util.HashSet;

@Patterns({
        @Pattern(
                patternName = "Multiton",
                participants = {EntityManagement.class}
        ),
        @Pattern(
                patternName = "Servant",
                participants = {EntityManagement.class, CartesianCoordinate.class, SphericCoordinate.class}
        )
})
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
