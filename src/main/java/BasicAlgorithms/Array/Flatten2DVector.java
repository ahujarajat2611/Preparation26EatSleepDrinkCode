package BasicAlgorithms.Array;

/**
 * Created by hadoop on 23/2/18.
 */
import java.util.*;
public class Flatten2DVector {
    public class Vector2D {

        Iterator<List<Integer>> listIter;
        Iterator<Integer> numberIter = Collections.EMPTY_LIST.iterator();

        public Vector2D(List<List<Integer>> vec2d) {
            listIter = vec2d.iterator();
        }

        public int next() {

            return numberIter.next();

        }

        public boolean hasNext() {

            while(numberIter == null || !numberIter.hasNext()){
                if(listIter != null && listIter.hasNext())
                    numberIter = listIter.next().iterator();
                else return false;
            }

            return true;
        }

        public boolean hasNextMine() {

            if (!numberIter.hasNext() && !listIter.hasNext()) {
                return false;
            }
            if (!listIter.hasNext()) {
                return numberIter.hasNext();
            }
            while (!numberIter.hasNext() && listIter.hasNext()) {
                numberIter = listIter.next().iterator();
            }
            return numberIter.hasNext();

//            while(numberIter == null || !numberIter.hasNext()){
//                if(listIter != null && listIter.hasNext())
//                    numberIter = listIter.next().iterator();
//                else return false;
//            }
//
//            return true;
        }
    }

}
