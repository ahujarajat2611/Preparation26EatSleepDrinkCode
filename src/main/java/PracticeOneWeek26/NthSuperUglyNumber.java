package PracticeOneWeek26;

import java.util.*;

public class NthSuperUglyNumber {

	public static int nthSuperUglyNumber(int n, int a[]) {
        int t[] = new int[n];
		t[0] = 1;
		class Node {
			int uglyIndex;
			int primeNumber;
			int factorOfPrime;

			public Node(int uglyIndex, int primeNumber, int factorOfPrime) {
				this.uglyIndex = uglyIndex;
				this.primeNumber = primeNumber;
				this.factorOfPrime = factorOfPrime;
			}

			@Override
			public String toString() {
				return "Node{" +
						"uglyIndex=" + uglyIndex +
						", primeNumber=" + primeNumber +
						", factorOfPrime=" + factorOfPrime +
						'}';
			}
		}
		PriorityQueue<Node> pq = new PriorityQueue<>(a.length, new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				return n1.factorOfPrime - n2.factorOfPrime;
			}
		});

		for (int i : a) {
			pq.offer(new Node(0, i, t[0] * i));
		}

		for (int i = 1; i < n; i++) {
			Node min = pq.peek();
			System.out.println("min node is "+min);
			System.out.println();
			t[i] = min.factorOfPrime;
			//System.out.println("t i is "+t[i]);
			//FIRST YOU PEEK THE CURRENT ONE AND THEN POLL ALL WITH VLAUE EQUAL TO MIN VALUE
			//Or you can poll() the min value and then peek the other elements whole value is equal to min vlue
			while (pq.peek().factorOfPrime == t[i]) {
				Node temp = pq.poll();
				System.out.println("feteched node is "+temp);
				temp.uglyIndex++;
				System.out.println("initial vale "+t[temp.uglyIndex]);
				temp.factorOfPrime = t[temp.uglyIndex] * temp.primeNumber;
				System.out.println("updated node is "+temp);
				pq.offer(temp);
			}
		}
		//CommonUtil.printArray(t);
		return t[n - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int res = -1;
		int primes[] = { 2, 3};
		res = nthSuperUglyNumber(11, primes);
		System.out.println(res);
		res = nthSuperUglyNumber(11, primes);
		System.out.println(res);
	}

}