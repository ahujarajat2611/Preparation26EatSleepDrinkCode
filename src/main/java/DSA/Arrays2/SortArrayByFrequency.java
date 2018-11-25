/**
 * 
 */
package DSA.Arrays2;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.*;
import java.util.Map.Entry;


/**
 * @author Raj
 *
 *         If frequency is same, then it must preserve the order
 */
public class SortArrayByFrequency {

	void sortArrayByFrequency(int a[]) {
		class Node {
			int idx;
			int value;
			int count;
		}
		Map<Integer, Node> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			final int idx = i;
			map.compute(a[i], (k, v) -> {
				if (null == v) {
					v = new Node();
					v.idx = idx;
					v.value = a[idx];
				}
				v.count++;
				return v;
			});
		}
		TreeSet<String> hashSet = new TreeSet<>();
		hashSet.add("rajat");
		hashSet.add("phuja");
		hashSet.add("aa");
		List<String> list = new ArrayList<>(hashSet);

		System.out.println(list);

		List<Entry<Integer, Node>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, (e1, e2) -> {
			if (e1.getValue().count == e2.getValue().count)
				return e1.getValue().idx - e2.getValue().idx;
			return e2.getValue().count - e1.getValue().count;
		});
	
		int i = 0;
		for (Entry<Integer, Node> item : entries) {
			for (int k = 0; k < item.getValue().count; k++) {
				a[i++] = item.getValue().value;
			}
		}
	}

	public static void main(String[] args) {
		SortArrayByFrequency obj = new SortArrayByFrequency();
		int a[] = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 };
		int n = a.length;
		obj.sortArrayByFrequency2(a,n);
		ConsoleWriter.printArray(a);
	}

	public Comparator<Element> customSorterByVal = new Comparator<Element>() {
		public int compare(Element o1, Element o2) {
			return o1.val - o2.val;
		}
	};

	public Comparator<Element> customSorterByCountAndIndex = new Comparator<Element>() {
		public int compare(Element o1, Element o2) {
			if (o1.count == o2.count) {
				return o1.index - o2.index;
			}
			return o2.count - o1.count;
		}
	};

	public void sortArrayByFrequency2(int[] a, int n) {
		if (n <= 0)
			return;
		Element[] elements = new Element[n];
		for (int i = 0; i < n; i++) {
			elements[i] = new Element(i, a[i], 1);
		}
		Arrays.sort(elements, customSorterByVal);

		for (int i = 1; i < n; i++) {
			if (elements[i].val == elements[i - 1].val) {
				elements[i].count = elements[i - 1].count + 1;
				elements[i].index = elements[i - 1].index;
				// you just want to keep one count and make the count of previious element to -1 make total sense

				elements[i - 1].count = -1;
			}
		}
		ConsoleWriter.printArray(elements);
		Arrays.sort(elements, customSorterByCountAndIndex);
		ConsoleWriter.printArray(elements);

		int k = 0;
		for (int i = 0; i < n; i++) {
			Element ele = elements[i];
			if (ele.count != -1) {
				for (int j = 0; j < ele.count; j++) {
					a[k++] = ele.val;
				}
			}
		}
	}

}

class Element {
	int index;
	int val;
	int count;

	public Element(int index, int val, int count) {
		super();
		this.index = index;
		this.val = val;
		this.count = count;
	}

	@Override
	public String toString() {
		return "(index=" + index + ", val=" + val + ", count=" + count + ")";
	}

}
