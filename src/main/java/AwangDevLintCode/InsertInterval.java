package AwangDevLintCode;

import java.util.*;
public class InsertInterval {
    private class Point{
        int pos;
        int flag;
        Point(int pos,int flag){
            this.flag = flag;
            this.pos = pos;
        }
    }
    
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
            ArrayList<Interval> ans = new ArrayList<>();
            if(intervals == null || intervals.size() == 0){
                if(newInterval!=null){
                    ans.add(newInterval);
                }
                return ans;
            }
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            // soortinng based on positions !!!
            public int compare(Point o1, Point o2) {
                return o1.pos-o2.pos;
            }
        });
            for(Interval interval:intervals){
                priorityQueue.add(new Point(interval.start,1));
                priorityQueue.add(new Point(interval.end,-1));
            }
            if(newInterval!=null) {
                priorityQueue.add(new Point(newInterval.start, 1));
                priorityQueue.add(new Point(newInterval.end, -1));
            }
            int start = 0;
            int end = 0;
            int count=0;
            while (!priorityQueue.isEmpty()){
                Point point = priorityQueue.poll();
                if(count == 0 ){
                    start = point.pos;
                }
                count = count+point.flag;
                while (!priorityQueue.isEmpty() && point.pos == priorityQueue.peek().pos){
                    point = priorityQueue.poll();
                    count = count + point.flag;
                }
                if(count == 0){
                    end = point.pos;
                    ans.add(new Interval(start,end));
                }
            }
            return ans;
    }

    // find its insert position
    // once you have that kind of apply merge operation
    public ArrayList<Interval> insertNew(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans = new ArrayList<>();
        if(intervals == null || intervals.size() == 0){
            if(newInterval!=null){
                intervals.add(newInterval);
            }
            return intervals;
        }
        int positiontoinsert =-1;
        for(int i=0;i<intervals.size();i++){
            
            if(newInterval.start<=intervals.get(i).start) {
                positiontoinsert = i;
                break;
            }
        }
        
        if(positiontoinsert == 0){
            intervals.add(0,newInterval);
        }

        else if(positiontoinsert == -1){
            intervals.add(intervals.size()-1,newInterval);
        }
        else {
            intervals.add(positiontoinsert-1,newInterval);
        }

        Interval prev = intervals.get(0);


        // check merge status , if thats the case remove current and merge with pervious thing
        //
        for(int i=1;i<intervals.size();i++){
            Interval current = intervals.get(i);

            if(prev.end>=current.start){
                // max end point
                // overlap hai delete karo currrne tko
                // prev kp update karo
                prev.end = Math.max(current.end,prev.end);
                intervals.remove(i);
                i--;
            }
            else {
                prev = current;
            }
        }
        return intervals;
    }
}