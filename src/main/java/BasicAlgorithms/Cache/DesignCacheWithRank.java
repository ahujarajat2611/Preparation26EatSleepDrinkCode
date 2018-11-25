package BasicAlgorithms.Cache;

import java.util.*;
//Design a cache, each object has a rank. If the cache is full, evict the one with the minimum rank.
public class DesignCacheWithRank {
    // 
	HashSet<CacheObj> set;
	PriorityQueue<CacheObj> minHeap;
	int size;
	int capacity;
	
	public DesignCacheWithRank(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		set = new HashSet<CacheObj>();
		minHeap = new PriorityQueue<CacheObj>(size, new Comparator<CacheObj>(){
			public int compare(CacheObj obj1, CacheObj obj2) {
				return obj1.rank - obj2.rank;
			}
		});
	}
	
	public boolean exits(CacheObj o) {
		return set.contains(o);
	}
	
	public void insert(CacheObj o) {
		if (this.size < capacity) {
			set.add(o);
			minHeap.add(o);
		} else {
			if (o.rank > minHeap.peek().rank) {
				// once arre remoning from minheap .. we need to remove from set as well !!!
				minHeap.poll();
				minHeap.add(o);
				set.add(o);
			}
		}
	}
}
// i think idea from this question is pretty clear that how you can implement priority based cache !!!
// cache based on ranking strategy !!!
class CacheObj {
	int rank;
	int key;
	
	public CacheObj(int rank, int key) {
		this.key = key;
		this.rank = rank;
	}
}
