package BasicAlgorithms.Stack;

import java.util.LinkedList;

/**
 * Created by hadoop on 1/3/18.
 */
public class AsteroidMine {
    // this problem is exact copy  of
    // balancing parehteiss // and keep things in stack
    // whatever you could not balance !!!
    // it is as simple as that
    // thik that aserooid at rest and new asetroid gets added to stack !!!
    public int[] asteroidCollisionAgain(int[] a) {
        LinkedList<Integer> s = new LinkedList<>();
        for (int i : a) {
            // if positive push to stack !!!
            if (i > 0)
                s.add(i);
            else {
                // if negative then if abs value of currtne is more than
                // peek value of stack then poll it
                // if negative is more than polled positive values
                while (!s.isEmpty() && s.getLast() > 0 && s.getLast() < -i)
                    s.pollLast();
                // if equal then also poll but dont put
                // if equal then then destory the last element as well
                if (!s.isEmpty() && s.getLast() == -i)
                    s.pollLast();
                    // if last value on stack is positive it means negative aseriod finised by
                    // position dont push value
                    // if last value is negative then push ....
                    // if stack is empty then also push ..
                else if (s.isEmpty() || s.getLast() < 0)
                    s.add(i);
            }
        }
        return s.stream().mapToInt(i->i).toArray();
    }
    public int[] asteroidCollision(int[] a) {
        LinkedList<Integer> s = new LinkedList<>();
        for (int i : a) {
            if (i > 0)
                s.add(i);
            else {
                boolean destorycurrentvlaue = false;
                while (!s.isEmpty() && s.getLast() > 0 && Math.abs(s.getLast()) <= Math.abs(i)){
                    int element = s.getLast();
                    s.pollLast();

                    if(Math.abs(element) == Math.abs(i)){
                        destorycurrentvlaue = true;
                        break;
                    }
                }
                if(destorycurrentvlaue == true){
                    continue;
                }
                if (!s.isEmpty() && s.getLast()>0){
                    continue;
                }
                s.add(i);
            }
        }
        return s.stream().mapToInt(i->i).toArray();
    }
}
