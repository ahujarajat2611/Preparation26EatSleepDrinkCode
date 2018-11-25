package BasicAlgorithms.Stack;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by hadoop on 24/12/17.
 */
class Exception extends java.lang.Exception {

}
public class Asteriod {
    public static void main(String[] args) {
        int[] array = {-2,-1,1,2};
        Asteriod asteriod = new Asteriod();
        int ans [] = asteriod.asteroidCollision(array);
        //reverseArray(ans);
        ConsoleWriter.printIntArray(ans);
    }

    private static void reverseArray(int[] ints) {
        int s = 0;
        int e = ints.length-1;
        while (s<e){
            int temp = ints[s];
            ints[s] = ints[e];
            ints[e] = temp;
            s++;
            e--;
        }
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] res = new int[asteroids.length];
        int index = 0;
        for (int i = asteroids.length - 1; i >= 0; i--) {

            if (stack.isEmpty() && asteroids[i] > 0) {
                res[index++] = asteroids[i];
                continue;
            }
            if (stack.isEmpty()) {
                System.out.println("ee");
                stack.push(asteroids[i]);
                continue;
            }
            if(!stack.isEmpty() && asteroids[i]>0 && stack.peek()>0){
                stack.push(asteroids[i]);
                continue;
            }
            if(!stack.isEmpty() && asteroids[i]<0 && stack.peek()<0){

                stack.push(asteroids[i]);
                continue;
            }
            System.out.println("aea");
                while (!stack.isEmpty() && asteroids[i] > 0 && stack.peek() < 0 && asteroids[i] > stack.peek() * -1) {
                    System.out.println("e");

                    stack.pop();
                }

                while (!stack.isEmpty() && asteroids[i] < 0 && stack.peek() > 0 && Math.abs(asteroids[i]) > stack.peek()) {
                    System.out.println("e");

                    stack.pop();
                }
                if (stack.isEmpty()) {
                    stack.push(asteroids[i]);
                    continue;
                }
            System.out.println(asteroids[i]);
            System.out.println(stack.peek());

                if (!stack.isEmpty() && ((asteroids[i] >0 && stack.peek()<0) || (asteroids[i]<0 && stack.peek()>0)) && Math.abs(asteroids[i]) == Math.abs(stack.peek())) {
                stack.pop();
                    System.out.println("e");
                }

        }
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        int write=0;

        for(int i=0;i<res.length;i++){
            if(res[i]!=0){
                res[write++] = res[i];
            }
        }
        int []result = new int[write];
        for(int i=0;i<write;i++){
            result[i] = res[i];
        }
        return result;
    }
    public int[] asteroidCollisionAgain(int[] a) {
        LinkedList<Integer> s = new LinkedList<>();
        for (int i : a) {
            if (i > 0)
                s.add(i);
            else {
                // if negative is more than polled positive values
                while (!s.isEmpty() && s.getLast() > 0 && s.getLast() < -i)
                    s.pollLast();
                // if equal then also poll but dont put
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
}