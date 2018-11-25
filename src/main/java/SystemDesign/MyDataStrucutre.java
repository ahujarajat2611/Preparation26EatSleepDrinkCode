package SystemDesign;

import java.util.*;
public class MyDataStrucutre{
List<Integer> nums;
Map<Integer, Integer> locs;
java.util.Random rand = new java.util.Random();
public MyDataStrucutre() {
nums = new ArrayList<>();
locs = new HashMap<Integer, Integer>();
}

boolean insert(int val) {
boolean contain = locs.containsKey(val);
if ( contain ) return false;
locs.put( val, nums.size());
nums.add(val);
return true;
}

boolean remove(int val) {
boolean contain = locs.containsKey(val);
if ( ! contain ) return false;
int loc = locs.get(val);
if (loc < nums.size() - 1 ) { 
int lastone = nums.get(nums.size() - 1 );
nums.set( loc , lastone );
locs.put(lastone, loc);
}
locs.remove(val);
nums.remove(nums.size() - 1);
return true;
}

int getRandom() {
return nums.get( rand.nextInt(nums.size()) );
}
}