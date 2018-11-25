/**
 * 
 */
package DSA.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author Raj
 *
 *         A 2d grid map of m rows and n columns is initially filled with water.
 *         We may perform an addLand operation which turns the water at position
 *         (row, col) into a land. Given a list of positions to operate, count
 *         the number of islands after each addLand operation. An island is
 *         surrounded by water and is formed by connecting adjacent lands
 *         horizontally or vertically. You may assume all four edges of the grid
 *         are all surrounded by water.
 * 
 *         Example:
 * 
 *         Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 *         Initially, the 2d grid grid is filled with water. (Assume 0
 *         represents water and 1 represents land).
 * 
 * 
 *         0 0 0 0 0 0 0 0 0
 * 
 *         Operation #1: addLand(0, 0) turns the water at grid[0][0] into a
 *         land.
 * 
 *         1 0 0 0 0 0 Number of islands = 1 0 0 0
 * 
 *         Operation #2: addLand(0, 1) turns the water at grid[0][1] into a
 *         land.
 * 
 *         1 1 0 0 0 0 Number of islands = 1 0 0 0
 * 
 *         Operation #3: addLand(1, 2) turns the water at grid[1][2] into a
 *         land.
 * 
 *         1 1 0 0 0 1 Number of islands = 2 0 0 0
 * 
 *         Operation #4: addLand(2, 1) turns the water at grid[2][1] into a
 *         land.
 * 
 *         1 1 0 0 0 1 Number of islands = 3 0 1 0
 * 
 *         We return the result as an array: [1, 1, 2, 3]
 * 
 *         Challenge:
 * 
 *         Can you do it in time complexity O(k log mn), where k is the length
 *         of the positions?
 */
public class NumberOfIslands2 {

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> result = new ArrayList<>();
		DisjointSet ds = new DisjointSet();
		int moves[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int count = 0;
		for (int p[] : positions) {
			int v1 = n * p[0] + p[1];
			ds.makeSet(v1);
			//count++;
			for (int[] move : moves) {
				int _x = p[0] + move[0];
				int _y = p[1] + move[1];
				int v2 = n * _x + _y;
				if (!isSafe(m, n, _x, _y) || !ds.contains(v2) || ds.findSet(v1)==ds.findSet(v2)) {
					continue;
				}
				ds.union(v1, v2);
				System.out.println(ds.parentMap);
				//count--;
			}

			result.add(ds.count);
		}
		for(int i=0;i<9;i++){
			ds.findSet(i);
		}
		System.out.println(ds.parentMap);
		return result;
	}

	private boolean isSafe(int m, int n, int x, int y)
	{return x >= 0 && x < m && y >= 0 && y < n;
	}

//	public List<Integer> numIslands22(int m, int n, int[][] positions) {
//
//		DisjointSet ds = new DisjointSet();
//		ArrayList<Integer> result = new ArrayList<Integer>();
//		int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
//		int count = 0;
//
//		for (int k = 0; k < positions.length; k++) {
//			count++;
//
//			int[] p = positions[k];
//
//			long curRoot = p[0] * n + p[1];
//			ds.makeSet(curRoot);
//			for (int r = 0; r < directions.length; r++) {
//				int i = p[0] + directions[r][0];
//				int j = p[1] + directions[r][1];
//
//				// get neighbor
//				int nR = i * n + j;
//
//				// if safe and already have entry in DisjoingSet
//				if (i >= 0 && j >= 0 && i < m && j < n && ds.contains(nR)) {
//					// get neighbor's root
//					long neighbourRout = ds.findSet(nR);
//					// if root is not same union
//					if (neighbourRout != curRoot) {
//						ds.union(curRoot, neighbourRout);
//						// after union curRoot's root may have changed
//						curRoot = ds.findSet(curRoot);
//						count--;
//					}
//				}
//			}
//			result.add(count);
//		}
//
//		return result;
//	}

	public static void main(String[] args) {
		NumberOfIslands2 obj = new NumberOfIslands2();
		List<Integer> result = null;
		// int positions[][] = { { 0, 0 }, { 0, 1 }, { 1, 2 }, { 2, 1 } };
		int positions[][] = { { 0, 1 }, { 1, 2 }, { 2, 1 }, { 1, 0 }, { 0, 2 }, { 0, 0 }, { 1, 1 } };
		result = obj.numIslands2(3, 3, positions);
		System.out.println(result);
	}
}
class DisjointSet{
	HashMap<Integer,Integer> parentMap;
	int count;

	DisjointSet(){
		parentMap = new HashMap<>();
	}

	void makeSet(int a){

		if(!parentMap.containsKey(a)){
			count++;
			parentMap.put(a,a);
		}
	}
	boolean contains(int x){
		return parentMap.containsKey(x);
	}
	int findSet(int parent) {
		if(parentMap.containsKey(parent)){
			if (parent != parentMap.get(parent)) {
				 int newParent = findSet(parentMap.get(parent));
				 parentMap.put(parent, newParent);
				 return newParent;
			} else if(parent == parentMap.get(parent)){
				return parent;
			}
		}
		return -1;
	}

	void union(int set1,int set2){
		if(parentMap.containsKey(set1) && parentMap.containsKey(set2)) {
			int parent1 = findSet(set1);
			int parent2 = findSet(set2);
			System.out.println("parent1"+parent1);
			System.out.println("parent2"+parent2);
			System.out.println(parentMap);
			if (parent1 != parent2) {
				parentMap.put(parent1, parent2);
				System.out.println("count before sub"+count);
				count--;
			}
		}
	}
}
/*
[1, 2, 3, 4, 3, 2, -1]
 */