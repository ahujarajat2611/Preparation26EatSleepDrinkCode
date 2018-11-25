package PracticeOneWeek26;
import java.util.*;

public class ZigzagIterator {
    private HashMap<Integer, List<Integer>> map;
    private int length = 0;
    private int size = 0;
    private int index = 0;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        map = new HashMap<Integer, List<Integer>>();
        if (v1 != null && v1.size() > 0) {
        	map.put(size, v1);
        	length += v1.size();
        	size++;
        }
        if (v2 != null && v2.size() > 0) {
        	map.put(size, v2);
        	length += v2.size();
        	size++;
        }
        if (length == 0) {
        	return;
        }
    }

    public int next() {
        while(map.get(index).size() == 0) {
        	updateNextindex();
        }
        int rst = map.get(index).get(0);
        map.get(index).remove(0);
        length--;
        updateNextindex();
        return rst;
    }
    void updateNextindex(){
        index++;
        if (index == size) {
            index = 0;
        }
    }

    public boolean hasNext() {
        return length > 0;
    }	
}