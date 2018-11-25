package smallmomentsmakeitbigger26;
import java.util.*;

public class TwoSum {

    // Add the number to an internal data structure.
    // keep map and its frquence to take care of dulicate casees
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    // keep addding number of hashmap and increment freuence
    public void add(int number) {
        map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // check all keys in the map
        // itera and check diff
        // value -key exist in map
        // alddo is value -key == key then its frquecney should be more than 2
        for (int key: map.keySet()){
            if (value - key == key) {
                 if (map.get(key) >= 2) return true;
            }
            else {
                if (map.containsKey(value - key)) return true;
            }
        }
        return false;
    }
}