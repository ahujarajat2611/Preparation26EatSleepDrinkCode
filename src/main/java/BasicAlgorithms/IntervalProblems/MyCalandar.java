package BasicAlgorithms.IntervalProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hadoop on 24/12/17.
 */
public class MyCalandar {
}

class MyCalendar {
    private class Point {
        int time;
        int flag;
        Point(int time, int flag){
            this.time = time;
            this.flag = flag;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (time != point.time) return false;
            return flag == point.flag;
        }

        @Override
        public int hashCode() {
            int result = time;
            result = 31 * result + flag;
            return result;
        }
    }
    PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            if(o1.time == o2.time){
                if(o1.flag == 1){
                    return -1;
                }
                else {
                    return 1;
                }
            }
            else {
                return o1.time-o2.time;
            }
        }
    });
    PriorityQueue<Point> backup = new PriorityQueue<>(new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            if(o1.time == o2.time){
                if(o1.flag == 1){
                    return -1;
                }
                else {
                    return 1;
                }
            }
            else {
                return o1.time-o2.time;
            }
        }
    });


    public MyCalendar() {

    }

    public boolean book(int start, int end) {

        PriorityQueue<Point> processingqueue = pq.isEmpty()?backup:pq;
        PriorityQueue<Point> emptyQueue = pq.isEmpty()?pq:backup;
        processingqueue.add(new Point(start, 1));
        processingqueue.add(new Point(end,-1));
        int count =0;
        boolean ans = true;
        while (!processingqueue.isEmpty()){
            Point polled = processingqueue.poll();
            emptyQueue.add(polled);
            count = count + polled.flag;
            //System.out.println("c"+count);
            if(count ==0){
                //publish
            }
            while (!processingqueue.isEmpty() && processingqueue.peek().time == polled.time){
                Point polled1 = processingqueue.poll();
                emptyQueue.add(polled1);
                //System.out.println("cou"+polled1.flag);
                count = count + polled1.flag;
            }

            if(count>1){
               // System.out.println(count);
                ans = false;
            }
        }
        if(!ans){
           // System.out.println("removal");
          emptyQueue.remove(new Point(start, 1));
            emptyQueue.remove(new Point(end, -1));
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20)); // returns true
        System.out.println(calendar.book(15, 25)); // returns false
        System.out.println(calendar.book(20, 30));
    }
}