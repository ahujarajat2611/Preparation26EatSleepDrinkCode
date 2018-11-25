package BasicAlgorithms.IntervalProblems;

import java.util.*;
/**
 * Created by hadoop on 15/1/18.
 */
public class MaximumCourseSelection {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        return schedule(courses, 0, 0);
    }
    public int schedule(int[][] courses, int i, int time) {
        if (i == courses.length)
            return 0;
        int taken = 0;
        if (time + courses[i][0] <= courses[i][1])
            taken = 1 + schedule(courses, i + 1, time + courses[i][0]);
        int not_taken = schedule(courses, i + 1, time);
        return Math.max(taken, not_taken);
    }
    // There is strict ordering and your code will not take care of orders ... so above solution make sense in this case !!!!

    public int scheduleNewToFindTotalWays(int[][] courses, int i, int time) {
        if (i == courses.length)
            return 1;
        int totalways = 0;
        for(int index = i;index<courses.length;index++){
            if(time+courses[i][0]<=courses[i][1]) {
                totalways += scheduleNewToFindTotalWays(courses, i + 1, time + courses[i][0]);
            }
        }
        return totalways;
    }


    public int scheduleNewToFindMaxCourse(int[][] courses, int start, int time,List<Course> list) {
        if (start == courses.length) {
            System.out.println(list);
            System.out.println("time"+time);
            return 0;

        }
            int maxways = 0;
        for(int i = start;i<courses.length;i++){
            if(time+courses[i][0]<=courses[i][1]) {
             //   System.out.println("before push"+(time+ courses[i][0]));
                list.add(new Course(courses[i][0],courses[i][1]));
                maxways = Math.max(maxways,1+ scheduleNewToFindMaxCourse(courses, i + 1, time + courses[i][0],list));
                list.remove(list.size()-1);
                //System.out.println("maxways "+maxways);
            }
        }
        return maxways;
    }
    // WORKING BUT TLE SOLUTION
    private class Solution {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, new Comparator<int[]>(){
                @Override
                public int compare(int []a,int []b){
                    return a[1]-b[1];
                }
            });
            int []cache = new int[courses.length];
            Arrays.fill(cache,-1);
            return scheduleNew(courses,0,0,cache);
        }

        public int scheduleNew(int[][] courses, int i, int time, int []cache) {
            if (i == courses.length)
                return 0;
            if(cache[i]!=-1){
                return cache[i];
            }
            int maxways = 0;
            for(int index = i;index<courses.length;index++){
                if(time+courses[index][0]<=courses[index][1]) {
                    maxways = Math.max(maxways,1+ scheduleNew(courses, index + 1, time + courses[index][0],cache));
                }
            }
            cache[i] = maxways;
            return maxways;
        }
    }


    public static void main(String[] args) {
        MaximumCourseSelection maximumCourseSelection = new MaximumCourseSelection();
        int [][]course ={{2,5},{2,19},{1,8}};
        List<Course> list = new ArrayList<Course>();

        System.out.println(maximumCourseSelection.scheduleNewToFindMaxCourse(course,0,0,list));
    }
    private static class Course{
        int timetaken;
        int deadline;

        public Course(int timetaken, int deadline) {
            this.timetaken = timetaken;
            this.deadline = deadline;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "timetaken=" + timetaken +
                    ", deadline=" + deadline +
                    '}';
        }
    }

    public int scheduleCourseOptimize(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        // take elemets which are ending first
        //
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for (int course[] : courses) {
            int d = course[0], e = course[1];
            pq.add(d);
            sum += d;
            while (sum > e) {
                sum -= pq.poll();
            // i would like to remove that course whosoever has taken the max amount off time !!!!
            }
        }
        return pq.size();
    }
    public int scheduleCourseBestGreedySOlution(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]); //Sort the courses by their deadlines (Greedy! We have to deal with courses with early deadlines first)
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int time=0;
        for (int[] c:courses)
        {
            // Here publish time is not given thats why are takiing pq to remove those cases whosoever has taken the most amout
            // of time !!!
            time+=c[0]; // add current course to a priority queue
            pq.add(c[0]);
            if (time>c[1]) time-=pq.poll(); //If time exceeds, drop the previous course which costs the most time. (That must be the best choice!)
        }
        return pq.size();
    }

}

/*

With greedy ideas, first of all, based on experience, the earlier you finish a course, the sooner you can choose and
 finish the course the better, as you will have more time
  to take other courses. So first we sorted all the lessons
  by their closing time, each time we greedily chose
  the earliest closed course.
If now + duration <= closed, that is, the current time plus the duration
of the lesson does not exceed the closing time of the lesson,
 greedy electives the course and inserts
  the duration of the lesson into a priority queue (maximum heap).
If you can not take the course and
the stack time in the priority queue
 is longer than the current one, you can delete
 the top course and replace it with that one,
  so that the course can definitely be taken and completed and the new now is smaller than the previous one, more conducive to elective more courses.
For example, suppose you have sorted [3,8],
 [7,10], [5,14], [8,17], now = 0 by the close time.
Elective courses, now = 3 <8,
priority queue pile top 3
Elective second course, now = 3 + 7 = 10 <= 10, priority queue heap of 7
Elective course of the third course, now = 10 + 5 = 15> 14, failed; found that the duration of the top course is 7, greater than the current course duration of 5 , so you can put the top course into the course, then the new Now = 10-7 + 5 = 8, the top of the pile is 5. Because the duration of the course is shorter than the top of the stack, and the closing time is sorted, it is greater than the close time of the top of the stack, so replacing the top course with the top course will definitely be completed. And the new now = 8 is smaller than the previous now = 10, making it possible to complete the fourth course.
Elective fourth course, now = 8 + 8 = 16 <17, the priority queue is 8.
 */