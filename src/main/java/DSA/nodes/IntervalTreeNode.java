package DSA.nodes;

public class IntervalTreeNode {
	public int start;
	public int end;
	public int max;
	public IntervalTreeNode left;
	public IntervalTreeNode right;

	public IntervalTreeNode(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Interval [publish=" + start + ", end=" + end + ", max=" + max + "]";
	}

}