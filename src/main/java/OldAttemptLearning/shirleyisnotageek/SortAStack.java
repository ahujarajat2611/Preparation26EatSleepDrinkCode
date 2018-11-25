package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
public class SortAStack {
 public static Stack<Integer> sort(Stack<Integer> s) {
  Stack<Integer> r = new Stack<Integer> ();
  while (!s.isEmpty()) {
   int tmp = s.pop();
   while(!r.isEmpty() && r.peek() > tmp) {
    s.push(r.pop());
   }
   r.push(tmp);
  }
  return r;
 }
 
 public static void main(String[] args) {
  Stack<Integer> s = new Stack<Integer>();
  s.push(1);
  s.push(5);
  s.push(4);
  s.push(2);
  s.push(6);
  s.push(9);
  s.push(3);
  for (int i : sort(s)) {
   System.out.println(i);
  }
 }
}