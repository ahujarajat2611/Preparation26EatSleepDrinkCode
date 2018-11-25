package DSA.Arrays2;

class KadaneResult {
    int max;
	int maxStart;
	int maxEnd;

	public KadaneResult(int max, int maxStart, int maxEnd) {
		super();
		this.max = max;
		this.maxStart = maxStart;
		this.maxEnd = maxEnd;
	}

	@Override
	public String toString() {
		return "KadaneResult [max=" + max + ", maxStart=" + maxStart + ", maxEnd=" + maxEnd + "]";
	}

}