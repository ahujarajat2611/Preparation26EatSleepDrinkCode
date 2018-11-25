package OldAttemptLearning.shirleyisnotageek;

import java.util.*;

/*
https://shanzi.gitbooks.io/algorithm-notes/content/problem_solutions/weighted_random_distribution.html

 */
class PreCalculateWeightsRandom{
    int totalWeights = 0;
    ArrayList<Integer> itemList = new ArrayList<Integer>();
    ArrayList<Integer> weightList = new ArrayList<Integer>();

    void addItem(int item, int weight) {
        itemList.add(item);
        totalWeights += weight;
        weightList.add(totalWeights);
    }

    void removeItem(int item) {
        int index = itemList.indexOf(item);
      ////  itemList.remove(item);
        itemList.remove(index);
        int weight = weightList.get(index);
        weightList.remove(index);
        for (int i = index; i < weightList.size(); i++) {
            weightList.set(i,weightList.get(i) - weight);
        }
    }

    int chooseOne() {
        int random = new Random().nextInt(totalWeights - 1);
        int index = binarySearchBoundary(weightList, random);
        return itemList.get(index);
    }

    int binarySearchBoundary(ArrayList<Integer> list, int value) {
        int l = 0;
        int r = list.size() - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < value) l = mid + 1;
            else r = mid;
        }

        return r;
    }
}

class InPlaceWeightRandom {
    HashMap<Integer, Integer> weightMap = new HashMap<Integer, Integer>();
    int totalWeight = 0;

    void putItem(int item, int weight) {
        if (weightMap.containsKey(item)) {
            totalWeight -= weight;
        }
        weightMap.put(item, weight);
        totalWeight += weight;
    }

    void removeItem(int item) {
        if (weightMap.containsKey(item)) {
            totalWeight -= weightMap.get(item);
            weightMap.remove(item);
        }
    }

    int chooseOne() {
        int sum = 0;
        int random = new Random().nextInt(totalWeight - 1);
        for(Map.Entry<Integer, Integer> entry: weightMap.entrySet()) {
            sum += entry.getValue();
            if (sum > random) return entry.getKey();
        }
        return 0;
    }


    public int pickTargetIndexOnly(int []nums,Random rnd,int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)
                result = i;
        }

        return result;
    }
    public int findMax(int[] array) {
        int len = array.length;
        int result = -1;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] == max) {
                count++;
                int num = new Random().nextInt(count);
                if (num == 0) {
                    result = i;
                }
            } else if (max == Integer.MIN_VALUE || array[i] > max) {
                max = array[i];
                result = i;
                count = 1;
            }
        }
        return result;
    }
}