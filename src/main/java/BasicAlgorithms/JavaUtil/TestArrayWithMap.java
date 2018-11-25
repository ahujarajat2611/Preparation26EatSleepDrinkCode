package BasicAlgorithms.JavaUtil;

/**
 * Created by hadoop on 23/2/18.
 */
import java.util.*;
public class TestArrayWithMap {
    public static void main(String[] args) {
        Map<int[], Integer>  map = new HashMap<>();
        int [] array = new int[]{1,2};
        map.put(array, 1);
        System.out.print(map.get(array));

        int []newarray = new int[]{1,2};
        System.out.println(map.get(newarray));
        map.put(array,map.getOrDefault(array,0)+1);
        System.out.println(map.get(array));
        System.out.println(map.get(newarray));
    }
}
