package BasicAlgorithms.Graph;

/**
 * Created by hadoop on 23/2/18.
 */
import BasicAlgorithms.utils.ConsoleWriter;
/// LESSON LEARNT
// KEEP TRACK OF PREVIOUS STATES .. IF UPDATED TO MIN .. PLEASE KEEP THAT MIN THING IN YOUR SOLUTION
// IT CAN SCREW YOU BADLY LIKE REALLY BADLY !!!!!


import java.util.*;
public class ModifiedFloyd {
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//        int[] dis = new int[n];
//        int[] pre = new int[n];
//        Arrays.fill(dis, Integer.MAX_VALUE / 2);
//        Arrays.fill(pre, Integer.MAX_VALUE / 2);
//        dis[src] = pre[src] = 0;
//
//        for (int i = 0; i <= K; ++i) {
//            for (int[] edge: flights)
//                dis[edge[1]] = Math.min(dis[edge[1]], pre[edge[0]] + edge[2]);
//
//            pre = dis;
//        }
//
//        return dis[dst] < Integer.MAX_VALUE / 2 ? dis[dst] : -1;
//    }


//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//
//        long [][]array = new long[n][n];
//        for(int i=0;i<n;i++){
//            Arrays.fill(array[i],Integer.MAX_VALUE/2);
//        }
//        for(int i=0;i<n;i++){
//            array[i][i] = 0;
//        }
//        for(int []edge:flights){
//            array[edge[0]] [ edge[1]] = edge[2];
//        }
//
//        for (int i = 1; i <= K; ++i) {
//            for (int[] edge: flights){
//                array[src][dst] = Math.min(array [src][dst],array[src][edge[0]] + edge[2] +array[edge[1]][dst]);
//            }
//        }
//        if(array[src][dst]==Integer.MAX_VALUE/2){
//            return -1;
//        }
//        return (int)array[src][dst];
//    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        long [][]array = new long[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(array[i],Integer.MAX_VALUE/2);
        }
        for(int i=0;i<n;i++){
            array[i][i] = 0;
        }
        for(int []edge:flights){
            array[edge[0]] [ edge[1]] = edge[2];
        }

        for (int i = 1; i <= K; ++i) {
            // only 1 iterator being used here that is destination
            // since publish is fixed !!!!!!!
            for(int p=0;p<n;p++){
                int d=p;
                for (int[] edge: flights){
                    array[src][d] = Math.min(array [src][d],array[src][edge[0]] + edge[2] +array[edge[1]][d]);
                }
            }
        }
        if(array[src][dst]==Integer.MAX_VALUE/2){
            return -1;
        }
        return (int)array[src][dst];
    }


    public int findCheapestPriceNew(int n, int[][] flights, int src, int dst, int K) {

        long [][]array = new long[K+1][n];
        for(int i=0;i<=K;i++){
            Arrays.fill(array[i],Integer.MAX_VALUE/2);
        }
        for(int []flight:flights){
            if(flight[0] == src ) {
                // VERY NICELY DONE ALL PEN PAPER REQUIRTEDD FOR ALL SOLUTOINS
                array[0][flight[1]] = flight[2];
            }
        }
        array[0][src] = 0;
        ConsoleWriter.printArray(array[0]);
        for(int k=1;k<=K;k++){
            for(int []flight:flights){
                ConsoleWriter.printArray(flight);
                // TOP LEVEL MIN IS VERY VERY VYER IMP !!!!!
                // DONE !!!!
                array[k][flight[1]] = Math.min(array[k][flight[1]],Math.min(array[k-1][flight[1]], flight[2] + array[k-1][flight[0]]));
            }
        }
        if(array[K][dst] == Integer.MAX_VALUE/2){
            return -1;
        }
        return (int)array[K][dst];
    }

    public static void main(String[] args) {
        int edge[][]=
                {{0,1,100},{1,2,100},{0,2,500}};
       // int edge1[][]=
        //        {{0,1,100},{1,2,100}};
        ModifiedFloyd modifiedFloyd = new ModifiedFloyd();
        System.out.println(modifiedFloyd.findCheapestPriceNew(3,edge,0,2,2));
    }


    public int findCheapestPriceStandardDijkstraWithKStepsaddition(int n, int[][] flights, int src, int dst, int K) {
        int[][] adjacencyMatrix = new int[n][n];

        for (int i = 0; i < flights.length; i++) {
            adjacencyMatrix[flights[i][0]][flights[i][1]] = flights[i][2];
        }

        PriorityQueue<City> minHeap = new PriorityQueue();
        Map<Integer, Integer> bestCostSoFar = new HashMap<>();

        minHeap.offer(new City(src, 0, 0));
        bestCostSoFar.put(src, 0);

        while (!minHeap.isEmpty()) {
            City currentCity = minHeap.poll();

            if (currentCity.stopsFromOrigin - 1 >= K) {
                continue;
                // we will not consider if steps is more than k ... there will be other nodes whose distance
                // may be more than this but meet the condition to be Less than k+1 distance far away
                // only this condidiotn ..... thats it had it been BFS then we could have returned INT_MAX not reachable
                // since there every step has 1 extra distance // here distance can be more but steps can be less !!!
            }

            int[] nextDirectlyConnectedCities = adjacencyMatrix[currentCity.id];

            for (int i = 0; i < n; i++) {
                if (nextDirectlyConnectedCities[i] != 0) {
                    int newCost = currentCity.costFromOrigin + nextDirectlyConnectedCities[i];
                    if (!bestCostSoFar.containsKey(i)) {
                        minHeap.offer(new City(i, newCost, currentCity.stopsFromOrigin + 1));
                        bestCostSoFar.put(i, newCost);
                    } else {
                        if (newCost < bestCostSoFar.get(i)) {
                            minHeap.remove(new City(i));
                            minHeap.offer(new City(i, newCost, currentCity.stopsFromOrigin + 1));
                            bestCostSoFar.put(i, newCost);
                        }
                    }
                }
            }
        }

        return bestCostSoFar.getOrDefault(dst, -1);
    }

    private class City implements Comparable<City> {
        int id;
        int costFromOrigin;
        int stopsFromOrigin;

        public City(int id) {
            this.id = id;
        }

        public City(int id, int costFromOrigin, int stopsFromOrigin) {
            this(id);
            this.costFromOrigin = costFromOrigin;
            this.stopsFromOrigin = stopsFromOrigin;
        }

        public boolean equals(Object c) {
            if (c instanceof City) {
                return this.id == ((City)c).id;
            }
            return false;
        }

        public int compareTo(City c) {
            return this.costFromOrigin - c.costFromOrigin;
        }
    }
}
