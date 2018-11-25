package BasicAlgorithms.Math;

/**
 * Created by hadoop on 1/3/18.
 */
import java.util.*;
public class NextClosestTimeMine {
    public String nextClosestTime(String time) {
        String args[] = time.split(":");
        int currenttime = gettime(args);
        List<Integer> digits = getdigits(args);
        for(Integer x:digits){
            System.out.println(x);
        }
        System.out.println(currenttime);

        String fianlans = new String ();
        Integer ansint;
        Integer diff = Integer.MAX_VALUE;

        for(Integer h1:digits){
            for(Integer h2:digits){
                int hour = h1* 10 + h2;
                if(hour>=24 ){
                    continue;
                }
                for(Integer m1: digits){
                    for(Integer m2:digits){
                        int min = 10 *m1 + m2;
                        if(min>=60){
                            continue;
                        }
                        int t = hour * 60 + min;
                        if(t == currenttime){
                            continue;
                        }
                        if(Math.abs(t-currenttime)<diff || Math.abs(t + 24 *60 -currenttime ) <diff){
                            diff = Math.abs(t-currenttime);
                            String ans = new String();
                            ans = ans + h1;
                            ans = ans + h2;
                            ans = ans + ":";
                            ans = ans + m1;
                            ans = ans + m2;
                            fianlans = ans;
                        }
                    }
                }
            }
        }

        return fianlans;
    }

    int gettime(String args[]){
        return Integer.parseInt(args[0])*60 + Integer.parseInt(args[1]);
    }
    List<Integer> getdigits(String args[]){
        List<Integer> list = new ArrayList<Integer>();
        for(String a:args){
            char []x = a.toCharArray();
            for(char i:x){
                list.add(i-'0');
            }
        }
        return list;
    }
}
