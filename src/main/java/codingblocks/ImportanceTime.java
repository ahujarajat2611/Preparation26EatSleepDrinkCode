package codingblocks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by hadoop on 5/10/17.
 */
public class ImportanceTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int numbertem= number;
        Deque<Integer> dequeex = new LinkedList<>();
        Deque<Integer> dequeid = new LinkedList<>();
        while (numbertem-->0){
            dequeex.addLast(sc.nextInt());
        }
        numbertem = number;
        while (numbertem-->0){
            dequeid.addLast(sc.nextInt());
        }
        int totaltime = 0;
        while (!dequeex.isEmpty()){
            if(dequeex.peekFirst() == dequeid.peekFirst()){
                dequeex.removeFirst();
                dequeid.removeFirst();
            }
            else {
                dequeex.addLast(dequeex.pollFirst());
            }
            totaltime = totaltime+1;
        }
        System.out.println(totaltime);
    }
}
