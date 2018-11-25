package AwangDevLintCode;

import java.util.*;
public class _305_NumberOfIslandsII {
    int[] parent;
	Set<Integer> set = new HashSet<>();
	int rows;
	int cols;

	public void union(int i, int j) {
		int parentI = find(i);
		int parentJ = find(j);
		if (parentI != parentJ) {
			parent[parentJ] = parentI;
			set.remove(parentJ);
		}
	}

	public int find(int i) {
		if (i == parent[i]) {
			return i;
		}
		parent[i] = find(i);
		return parent[i];
	}

	public void add(int x, int y) {
		parent[x * cols + y] = x * cols + y;
		set.add(x * cols + y);
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int[] dir : dirs) {
			int x1 = x + dir[0];
			int y1 = y + dir[1];
			if (x1 >= 0 && x1 < rows && y1 >= 0 && y1 < cols && parent[x1 * cols + y1] != -1) {
				union(x1 * cols + y1, x * cols + y);
			}
		}
	}

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		parent = new int[m * n];
		rows = m;
		cols = n;
		for (int i = 0; i < m * n; i++) {
			parent[i] = -1;
		}
		List<Integer> res = new ArrayList<>();
		for (int[] position : positions) {
			add(position[0], position[1]);
			res.add(set.size());
		}
		return res;
	}
}
class Islands2 {
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> result = new ArrayList<>();
		DisjointSetNew ds = new DisjointSetNew();
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
				//count--;
			}
			result.add(ds.count);
		}
		return result;
	}

	private boolean isSafe(int m, int n, int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}
}
class DisjointSetNew{
	// hava parent map keeps it simple !!!
	HashMap<Integer,Integer> parentMap;
	int count;

	DisjointSetNew(){
		parentMap = new HashMap<>();
	}

	// making set of integer
	void makeSet(int a){

		// before you make just make sure things are not there in the parent map
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
				// absolutely make sense here // just too pefect here regarding parentMap
				parentMap.put(parent, newParent);
				// very imp once you get newparent update the current node parent to newly get parent
				return newParent;

			} else if(parent == parentMap.get(parent)){   /*else{ return parent} also would work */
				return parent;
			}
		}
		return -1;
	}

	void union(int set1,int set2){
		int parent1 = findSet(set1);
		int parent2 = findSet(set2);
		if(parent1!=parent2){
			// assign parent1 to parent2 /// very imp !!!!!!!! after that you can run findsetOperation on set1 so that
			// all gets uupdated to parent2
			parentMap.put(parent1,parent2);
			count--;
		}
	}
	public static void main(String args[]){
		Islands2 islands2 = new Islands2();
		//islands2.numIslands2()
		DisjointSetNew disjointSet = new DisjointSetNew();
		disjointSet.makeSet(1);
		disjointSet.makeSet(2);
		disjointSet.makeSet(3);
		disjointSet.union(1,2);

		for(Integer parent:disjointSet.parentMap.values()){
			System.out.println(parent);
			// we can gather all nodes with same parent always !!!
		}
	}
}
