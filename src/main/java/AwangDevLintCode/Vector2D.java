package AwangDevLintCode;
import java.util.*;
public class Vector2D implements Iterator<Integer> {
            Iterator<List<Integer>> listByListIterator;
        Iterator<Integer> localListIterator;


    public Vector2D(List<List<Integer>> vec2d) {
        listByListIterator = vec2d.iterator();
        localListIterator = Collections.EMPTY_LIST.iterator();
      //  hasNext();
    }

    @Override
    public Integer next() {
              if(hasNext()){
                    return localListIterator.next();
              }
              return null;  
    }

    @Override
    public boolean hasNext() {
             // if(localListIterator == null){
             //     if(listByListIterator.hasNext()){
             //        localListIterator = listByListIterator.next().iterator();
             //        return true; 
             //     }
             //     return false;
             // }
             if (!localListIterator.hasNext() && !listByListIterator.hasNext()) {
                return false;
            }
            if (!listByListIterator.hasNext()) {
                return localListIterator.hasNext();
            }
            while (!localListIterator.hasNext() && listByListIterator.hasNext()) {
                localListIterator = listByListIterator.next().iterator();
            }
            return localListIterator.hasNext();
        
    }
}