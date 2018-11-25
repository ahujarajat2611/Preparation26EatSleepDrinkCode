package BasicAlgorithms.Heap;

import java.util.*;

/**
 * Created by hadoop on 24/1/18.
 */
public class SmallestRange {
    class Element {

        int row;
        int col;
        int val;

        Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Element> pq= new PriorityQueue<Element>(new Comparator<Element>(){

            @Override
            public int compare(Element e1, Element e2) {
                return e1.val - e2.val;
            }
        });

        int max = Integer.MIN_VALUE;

        for(int i =0;i<nums.size();i++){
            pq.offer(new Element(i,0,nums.get(i).get(0)));
            max = Math.max(max,nums.get(i).get(0));

        }

        int left = -1;
        int right = -1;

        int range = Integer.MAX_VALUE;


        while(pq.size() == nums.size()) {

            Element curr = pq.poll();


            // Step 1 : Update Range if smaller
            if((max - curr.val) < range) {
                range = max - curr.val;
                left = curr.val;
                right = max;

            }

            // Step 2 : Move the pointer of the target list with smallest element by one if in bounds

            if(curr.col < nums.get(curr.row).size()-1)
            {
                curr.col++;
                curr.val = nums.get(curr.row).get(curr.col);
                pq.offer(curr);
            }

            // Step 3 : Update max if necessary
            max = Math.max(max,nums.get(curr.row).get(curr.col));

        }

        return new int[]{left,right};

    }
}
/*
public int[] smallestRange(List<List<Integer>> nums) {
        if (nums.size() == 1)
            return new int[]{nums.get(0).get(0), nums.get(0).get(0)};

        int[] res = {-111111, 111111};
        TreeSet<int[]> tree = new TreeSet<>(Comparator
                .<int[], Integer>comparing(u -> nums.get(u[0]).get(u[1]))
                .thenComparing(u -> u[0]));
        for (int i = 0; i < nums.size(); i++)
            tree.add(new int[]{i, 0});
        while (tree.size() == nums.size()) {
            // Since the size of nums is >= 2, min != max
            int[] min = tree.pollFirst();
            int[] max = tree.last();

            int begin = nums.get(min[0]).get(min[1]);
            int end = nums.get(max[0]).get(max[1]);
            if (end - begin < res[1] - res[0]) {
                res[0] = begin;
                res[1] = end;
            }

            if (min[1] < nums.get(min[0]).size() - 1) {
                min[1]++;
                tree.add(min);
            }
        }
        return res;
    }
 */