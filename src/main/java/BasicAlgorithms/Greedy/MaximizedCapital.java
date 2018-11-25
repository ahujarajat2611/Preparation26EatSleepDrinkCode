package BasicAlgorithms.Greedy;

import java.util.*;

/**
 * Created by hadoop on 25/12/17.
 */

// pure greedly algo
    // to begin with we
// have W add all possible capital whose price is less than w
    // and then pick the max profile one
    // investment andd profit
    //  keep getting profit and keep investing as simple as that
public class MaximizedCapital {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node []arrays = new Node[Profits.length];

        for(int i=0;i<Profits.length;i++){
            arrays[i] = new Node(Capital[i],Profits[i]);
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.profit-o1.profit;
            }
        });

        Arrays.sort(arrays,new Comparator<Node>(){
            public int compare(Node a, Node b){
                return a.capital-b.capital;
            }
        });
        int i=0;
        while (i<arrays.length ){
            if(arrays[i].capital<=W){
                priorityQueue.add(arrays[i]);
                i++;
            }
            else {
                break;
            }
        }
        int counter=0;
        while (!priorityQueue.isEmpty() && counter<k){
            Node polled = priorityQueue.poll();
            W+=polled.profit;
           // System.out.println(W);
            //System.out.println(priorityQueue.size());
            counter++;
            while (i<arrays.length){
                if(arrays[i].capital<=W){
                    //System.out.println("entry");
                    priorityQueue.add(arrays[i]);
                    i++;
                }
                else {
                    break;
                }

            }
        }
        return W;
    }
    private class Node{
        int capital;
        int profit;

        public Node(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (capital != node.capital) return false;
            return profit == node.profit;
        }

        @Override
        public int hashCode() {
            int result = capital;
            result = 31 * result + profit;
            return result;
        }
    }

    public static void main(String[] args) {
        MaximizedCapital maximizedCapital = new MaximizedCapital();
        maximizedCapital.findMaximizedCapital(2,0,new int[]{1,2,3},new int[]{0,1,1});
//        2
//        0
//                [1,2,3]
//[0,1,1]
    }
}