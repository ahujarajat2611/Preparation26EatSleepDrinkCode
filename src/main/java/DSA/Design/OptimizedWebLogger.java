package DSA.Design;

class OptimizedWebLogger{
    int count;
    int []hitmap;
    int lasthit; // so that you can update counter with everyhit

    OptimizedWebLogger(){
        count = 0;
        lasthit = -1;
        hitmap = new int[300];
    }

    public void hit(Integer timestamp){
        timeFly(timestamp);
        // count also keep track of total counts
        // it deletes thinsg in time fly function
        // as in deletes count of those timestamps where
        // i did not recieve hits ///
        // lets say if  second has been passed then i will
        // 501 -> 502 ( now i need to delete entries for 202 since
        // i need to vacate 202 -> 501 makes 300 seconds( 501 -202 + 1)
        // so timefly funciton will remove 202 entry
        // what is 501 -> 803
        // in this case as well lastimestamp = 501
        // 502 to 803 with mode 300 will entually revmove all values
        // in the array

        count++;
        hitmap[timestamp%300]+=1;
        lasthit = timestamp;
    }

    private int getHitsInLast5min(Integer timestamp) {
        timeFly(timestamp);
        return count;
    }

    public void timeFly(Integer timestamp) {
        if (lasthit > 0) {
            if (timestamp - lasthit >= 300) {
                count = 0;
                for (int i = 0; i < 300; i++) {
                    hitmap[i] = 0;
                }
            } else {
                // last hit tak to hits aaye hai uske baad nhi aaye hai
                // udpate them to zero since there are no hits in that time
                // alsso keep taking mode to keep things in tange
                for (int i = lasthit + 1; i <= timestamp; i++) {
                    count = count - hitmap[i % 300];
                    hitmap[i % 300] = 0;
                }
            }
        }
    }
}
