//package companywidetests.walmartlabs;
//
///**
// * Created by hadoop on 28/10/17.
// */
//import java.io.*;
//import java.math.Bi   gInteger;
//import java.util.*;
//
//public class TestWalmart28oct {
//    public static void main(String[] args) {
//        InputStream inputStream = System.in;
//        OutputStream outputStream = System.out;
//        InputReader in = new InputReader(inputStream);
//        OutputWriter out = new OutputWriter(outputStream);
//        Task solver = new Task();
//        solver.solve(1, in, out);
//        out.close();
//    }
//}
//
//class Task {
//    public void solve(int testNumber, InputReader in, OutputWriter out) {
//        int testcase = in.readInt();
//        while (testcase-->0) {
//            String toBepalinString = in.readString();
//            String ans = getMaxPalndrome(toBepalinString);
//            System.out.println(ans);
//        }
//    }
//
//    private String getMaxPalndrome(String toBepalinString) {
//        int count [] = new int[256];
//        for(char x:toBepalinString.toCharArray()){
//            count[x-'a']++;
//        }
//        String returnedAns = new String();
//        List<Character> charOddCount = new ArrayList<>();
//
//        for(int i=0;i<256;i++){
//            if (count[i]%2 == 1){
//                charOddCount.add((char)(i+'a'));
//                count[i]--;
//                i--;
//            }
//            else if(count[i] !=0 && count[i]%2 ==0) {
//                while (count[i]>0){
//                    returnedAns = returnedAns+(char)(i+'a');
//                    count[i] = count[i]-2;
//                }
//            }
//        }
//        StringBuilder sb =  new StringBuilder(returnedAns);
//        if(charOddCount.size()>0) {
//            returnedAns = sb.toString() + charOddCount.get(0) + sb.reverse().toString();
//        }
//        else {
//            returnedAns = sb.toString() + sb.reverse().toString();
//        }
//        return returnedAns;
//    }
//}
//
//class Graph {
//    public static final int REMOVED_BIT = 0;
//
//    protected int vertexCount;
//    protected int edgeCount;
//
//    private int[] firstOutbound;
//    private int[] firstInbound;
//
//    private Edge[] edges;
//    private int[] nextInbound;
//    private int[] nextOutbound;
//    private int[] from;
//    private int[] to;
//    private long[] weight;
//    public long[] capacity;
//    private int[] reverseEdge;
//    private int[] flags;
//
//    public Graph(int vertexCount) {
//        this(vertexCount, vertexCount);
//    }
//
//    public Graph(int vertexCount, int edgeCapacity) {
//        this.vertexCount = vertexCount;
//        firstOutbound = new int[vertexCount];
//        Arrays.fill(firstOutbound, -1);
//
//        from = new int[edgeCapacity];
//        to = new int[edgeCapacity];
//        nextOutbound = new int[edgeCapacity];
//        flags = new int[edgeCapacity];
//    }
//
//    public static Graph createGraph(int vertexCount, int[] from, int[] to) {
//        Graph graph = new Graph(vertexCount, from.length);
//        for (int i = 0; i < from.length; i++)
//            graph.addSimpleEdge(from[i], to[i]);
//        return graph;
//    }
//
//    public static Graph createWeightedGraph(int vertexCount, int[] from,
//                                            int[] to, long[] weight) {
//        Graph graph = new Graph(vertexCount, from.length);
//        for (int i = 0; i < from.length; i++)
//            graph.addWeightedEdge(from[i], to[i], weight[i]);
//        return graph;
//    }
//
//    public static Graph createFlowGraph(int vertexCount, int[] from, int[] to,
//                                        long[] capacity) {
//        Graph graph = new Graph(vertexCount, from.length * 2);
//        for (int i = 0; i < from.length; i++)
//            graph.addFlowEdge(from[i], to[i], capacity[i]);
//        return graph;
//    }
//
//    public static Graph createFlowWeightedGraph(int vertexCount, int[] from,
//                                                int[] to, long[] weight, long[] capacity) {
//        Graph graph = new Graph(vertexCount, from.length * 2);
//        for (int i = 0; i < from.length; i++)
//            graph.addFlowWeightedEdge(from[i], to[i], weight[i], capacity[i]);
//        return graph;
//    }
//
//    public static Graph createTree(int[] parent) {
//        Graph graph = new Graph(parent.length + 1, parent.length);
//        for (int i = 0; i < parent.length; i++)
//            graph.addSimpleEdge(parent[i], i + 1);
//        return graph;
//    }
//
//    public int addEdge(int fromID, int toID, long weight, long capacity,
//                       int reverseEdge) {
//        ensureEdgeCapacity(edgeCount + 1);
//        if (firstOutbound[fromID] != -1)
//            nextOutbound[edgeCount] = firstOutbound[fromID];
//        else
//            nextOutbound[edgeCount] = -1;
//        firstOutbound[fromID] = edgeCount;
//        if (firstInbound != null) {
//            if (firstInbound[toID] != -1)
//                nextInbound[edgeCount] = firstInbound[toID];
//            else
//                nextInbound[edgeCount] = -1;
//            firstInbound[toID] = edgeCount;
//        }
//        this.from[edgeCount] = fromID;
//        this.to[edgeCount] = toID;
//        if (capacity != 0) {
//            if (this.capacity == null)
//                this.capacity = new long[from.length];
//            this.capacity[edgeCount] = capacity;
//        }
//        if (weight != 0) {
//            if (this.weight == null)
//                this.weight = new long[from.length];
//            this.weight[edgeCount] = weight;
//        }
//        if (reverseEdge != -1) {
//            if (this.reverseEdge == null) {
//                this.reverseEdge = new int[from.length];
//                Arrays.fill(this.reverseEdge, 0, edgeCount, -1);
//            }
//            this.reverseEdge[edgeCount] = reverseEdge;
//        }
//        if (edges != null)
//            edges[edgeCount] = createEdge(edgeCount);
//        return edgeCount++;
//    }
//
//    protected final GraphEdge createEdge(int id) {
//        return new GraphEdge(id);
//    }
//
//    public final int addFlowWeightedEdge(int from, int to, long weight,
//                                         long capacity) {
//        if (capacity == 0) {
//            return addEdge(from, to, weight, 0, -1);
//        } else {
//            int lastEdgeCount = edgeCount;
//            addEdge(to, from, -weight, 0, lastEdgeCount + entriesPerEdge());
//            return addEdge(from, to, weight, capacity, lastEdgeCount);
//        }
//    }
//
//    protected int entriesPerEdge() {
//        return 1;
//    }
//
//    public final int addFlowEdge(int from, int to, long capacity) {
//        return addFlowWeightedEdge(from, to, 0, capacity);
//    }
//
//    public final int addWeightedEdge(int from, int to, long weight) {
//        return addFlowWeightedEdge(from, to, weight, 0);
//    }
//
//    public final int addSimpleEdge(int from, int to) {
//        return addWeightedEdge(from, to, 0);
//    }
//
//    public final int vertexCount() {
//        return vertexCount;
//    }
//
//    public final int edgeCount() {
//        return edgeCount;
//    }
//
//    protected final int edgeCapacity() {
//        return from.length;
//    }
//
//    public final Edge edge(int id) {
//        initEdges();
//        return edges[id];
//    }
//
//    public final int firstOutbound(int vertex) {
//        int id = firstOutbound[vertex];
//        while (id != -1 && isRemoved(id))
//            id = nextOutbound[id];
//        return id;
//    }
//
//    public final int nextOutbound(int id) {
//        id = nextOutbound[id];
//        while (id != -1 && isRemoved(id))
//            id = nextOutbound[id];
//        return id;
//    }
//
//    public final int firstInbound(int vertex) {
//        initInbound();
//        int id = firstInbound[vertex];
//        while (id != -1 && isRemoved(id))
//            id = nextInbound[id];
//        return id;
//    }
//
//    public final int nextInbound(int id) {
//        initInbound();
//        id = nextInbound[id];
//        while (id != -1 && isRemoved(id))
//            id = nextInbound[id];
//        return id;
//    }
//
//    public final int source(int id) {
//        return from[id];
//    }
//
//    public final int destination(int id) {
//        return to[id];
//    }
//
//    public final long weight(int id) {
//        if (weight == null)
//            return 0;
//        return weight[id];
//    }
//
//    public final long capacity(int id) {
//        if (capacity == null)
//            return 0;
//        return capacity[id];
//    }
//
//    public final long flow(int id) {
//        if (reverseEdge == null)
//            return 0;
//        return capacity[reverseEdge[id]];
//    }
//
//    public final void pushFlow(int id, long flow) {
//        if (flow == 0)
//            return;
//        if (flow > 0) {
//            if (capacity(id) < flow)
//                throw new IllegalArgumentException("Not enough capacity");
//        } else {
//            if (flow(id) < -flow)
//                throw new IllegalArgumentException("Not enough capacity");
//        }
//        capacity[id] -= flow;
//        capacity[reverseEdge[id]] += flow;
//    }
//
//    public int transposed(int id) {
//        return -1;
//    }
//
//    public final int reverse(int id) {
//        if (reverseEdge == null)
//            return -1;
//        return reverseEdge[id];
//    }
//
//    public final void addVertices(int count) {
//        ensureVertexCapacity(vertexCount + count);
//        Arrays.fill(firstOutbound, vertexCount, vertexCount + count, -1);
//        if (firstInbound != null)
//            Arrays.fill(firstInbound, vertexCount, vertexCount + count, -1);
//        vertexCount += count;
//    }
//
//    protected final void initEdges() {
//        if (edges == null) {
//            edges = new Edge[from.length];
//            for (int i = 0; i < edgeCount; i++)
//                edges[i] = createEdge(i);
//        }
//    }
//
//    public final void removeVertex(int vertex) {
//        int id = firstOutbound[vertex];
//        while (id != -1) {
//            removeEdge(id);
//            id = nextOutbound[id];
//        }
//        initInbound();
//        id = firstInbound[vertex];
//        while (id != -1) {
//            removeEdge(id);
//            id = nextInbound[id];
//        }
//    }
//
//    private void initInbound() {
//        if (firstInbound == null) {
//            firstInbound = new int[firstOutbound.length];
//            Arrays.fill(firstInbound, 0, vertexCount, -1);
//            nextInbound = new int[from.length];
//            for (int i = 0; i < edgeCount; i++) {
//                nextInbound[i] = firstInbound[to[i]];
//                firstInbound[to[i]] = i;
//            }
//        }
//    }
//
//    public final boolean flag(int id, int bit) {
//        return (flags[id] >> bit & 1) != 0;
//    }
//
//    public final void setFlag(int id, int bit) {
//        flags[id] |= 1 << bit;
//    }
//
//    public final void removeFlag(int id, int bit) {
//        flags[id] &= -1 - (1 << bit);
//    }
//
//    public final void removeEdge(int id) {
//        setFlag(id, REMOVED_BIT);
//    }
//
//    public final void restoreEdge(int id) {
//        removeFlag(id, REMOVED_BIT);
//    }
//
//    public final boolean isRemoved(int id) {
//        return flag(id, REMOVED_BIT);
//    }
//
//    public final Iterable<Edge> outbound(final int id) {
//        initEdges();
//        return new Iterable<Edge>() {
//            public Iterator<Edge> iterator() {
//                return new EdgeIterator(id, firstOutbound, nextOutbound);
//            }
//        };
//    }
//
//    public final Iterable<Edge> inbound(final int id) {
//        initEdges();
//        initInbound();
//        return new Iterable<Edge>() {
//            public Iterator<Edge> iterator() {
//                return new EdgeIterator(id, firstInbound, nextInbound);
//            }
//        };
//    }
//
//    protected void ensureEdgeCapacity(int size) {
//        if (from.length < size) {
//            int newSize = Math.max(size, 2 * from.length);
//            if (edges != null)
//                edges = resize(edges, newSize);
//            from = resize(from, newSize);
//            to = resize(to, newSize);
//            nextOutbound = resize(nextOutbound, newSize);
//            if (nextInbound != null)
//                nextInbound = resize(nextInbound, newSize);
//            if (weight != null)
//                weight = resize(weight, newSize);
//            if (capacity != null)
//                capacity = resize(capacity, newSize);
//            if (reverseEdge != null)
//                reverseEdge = resize(reverseEdge, newSize);
//            flags = resize(flags, newSize);
//        }
//    }
//
//    private void ensureVertexCapacity(int size) {
//        if (firstOutbound.length < size) {
//            int newSize = Math.max(size, 2 * from.length);
//            firstOutbound = resize(firstOutbound, newSize);
//            if (firstInbound != null)
//                firstInbound = resize(firstInbound, newSize);
//        }
//    }
//
//    protected final int[] resize(int[] array, int size) {
//        int[] newArray = new int[size];
//        System.arraycopy(array, 0, newArray, 0, array.length);
//        return newArray;
//    }
//
//    private long[] resize(long[] array, int size) {
//        long[] newArray = new long[size];
//        System.arraycopy(array, 0, newArray, 0, array.length);
//        return newArray;
//    }
//
//    private Edge[] resize(Edge[] array, int size) {
//        Edge[] newArray = new Edge[size];
//        System.arraycopy(array, 0, newArray, 0, array.length);
//        return newArray;
//    }
//
//    public final boolean isSparse() {
//        return vertexCount == 0 || edgeCount * 20 / vertexCount <= vertexCount;
//    }
//
//    protected class GraphEdge implements Edge {
//        protected int id;
//
//        protected GraphEdge(int id) {
//            this.id = id;
//        }
//
//        public int getSource() {
//            return source(id);
//        }
//
//        public int getDestination() {
//            return destination(id);
//        }
//
//        public long getWeight() {
//            return weight(id);
//        }
//
//        public long getCapacity() {
//            return capacity(id);
//        }
//
//        public long getFlow() {
//            return flow(id);
//        }
//
//        public void pushFlow(long flow) {
//            Graph.this.pushFlow(id, flow);
//        }
//
//        public boolean getFlag(int bit) {
//            return flag(id, bit);
//        }
//
//        public void setFlag(int bit) {
//            Graph.this.setFlag(id, bit);
//        }
//
//        public void removeFlag(int bit) {
//            Graph.this.removeFlag(id, bit);
//        }
//
//        public int getTransposedID() {
//            return transposed(id);
//        }
//
//        public Edge getTransposedEdge() {
//            int reverseID = getTransposedID();
//            if (reverseID == -1)
//                return null;
//            initEdges();
//            return edge(reverseID);
//        }
//
//        public int getReverseID() {
//            return reverse(id);
//        }
//
//        public Edge getReverseEdge() {
//            int reverseID = getReverseID();
//            if (reverseID == -1)
//                return null;
//            initEdges();
//            return edge(reverseID);
//        }
//
//        public int getID() {
//            return id;
//        }
//
//        public void remove() {
//            removeEdge(id);
//        }
//
//        public void restore() {
//            restoreEdge(id);
//        }
//    }
//
//    public class EdgeIterator implements Iterator<Edge> {
//        private int edgeID;
//        private final int[] next;
//        private int lastID = -1;
//
//        public EdgeIterator(int id, int[] first, int[] next) {
//            this.next = next;
//            edgeID = nextEdge(first[id]);
//        }
//
//        private int nextEdge(int id) {
//            while (id != -1 && isRemoved(id))
//                id = next[id];
//            return id;
//        }
//
//        public boolean hasNext() {
//            return edgeID != -1;
//        }
//
//        public Edge next() {
//            if (edgeID == -1)
//                throw new NoSuchElementException();
//            lastID = edgeID;
//            edgeID = nextEdge(next[lastID]);
//            return edges[lastID];
//        }
//
//        public void remove() {
//            if (lastID == -1)
//                throw new IllegalStateException();
//            removeEdge(lastID);
//            lastID = -1;
//        }
//    }
//
//}
//
//interface Edge {
//    public int getSource();
//
//    public int getDestination();
//
//    public long getWeight();
//
//    public long getCapacity();
//
//    public long getFlow();
//
//    public void pushFlow(long flow);
//
//    public boolean getFlag(int bit);
//
//    public void setFlag(int bit);
//
//    public void removeFlag(int bit);
//
//    public int getTransposedID();
//
//    public Edge getTransposedEdge();
//
//    public int getReverseID();
//
//    public Edge getReverseEdge();
//
//    public int getID();
//
//    public void remove();
//
//    public void restore();
//}
//
//class BidirectionalGraph extends Graph {
//    public int[] transposedEdge;
//
//    public BidirectionalGraph(int vertexCount) {
//        this(vertexCount, vertexCount);
//    }
//
//    public BidirectionalGraph(int vertexCount, int edgeCapacity) {
//        super(vertexCount, 2 * edgeCapacity);
//        transposedEdge = new int[2 * edgeCapacity];
//    }
//
//    public static BidirectionalGraph createGraph(int vertexCount, int[] from,
//                                                 int[] to) {
//        BidirectionalGraph graph = new BidirectionalGraph(vertexCount,
//                from.length);
//        for (int i = 0; i < from.length; i++)
//            graph.addSimpleEdge(from[i], to[i]);
//        return graph;
//    }
//
//    public static BidirectionalGraph createWeightedGraph(int vertexCount,
//                                                         int[] from, int[] to, long[] weight) {
//        BidirectionalGraph graph = new BidirectionalGraph(vertexCount,
//                from.length);
//        for (int i = 0; i < from.length; i++)
//            graph.addWeightedEdge(from[i], to[i], weight[i]);
//        return graph;
//    }
//
//    public static BidirectionalGraph createFlowGraph(int vertexCount,
//                                                     int[] from, int[] to, long[] capacity) {
//        BidirectionalGraph graph = new BidirectionalGraph(vertexCount,
//                from.length * 2);
//        for (int i = 0; i < from.length; i++)
//            graph.addFlowEdge(from[i], to[i], capacity[i]);
//        return graph;
//    }
//
//    public static BidirectionalGraph createFlowWeightedGraph(int vertexCount,
//                                                             int[] from, int[] to, long[] weight, long[] capacity) {
//        BidirectionalGraph graph = new BidirectionalGraph(vertexCount,
//                from.length * 2);
//        for (int i = 0; i < from.length; i++)
//            graph.addFlowWeightedEdge(from[i], to[i], weight[i], capacity[i]);
//        return graph;
//    }
//
//    @Override
//    public int addEdge(int fromID, int toID, long weight, long capacity,
//                       int reverseEdge) {
//        int lastEdgeCount = edgeCount;
//        super.addEdge(fromID, toID, weight, capacity, reverseEdge);
//        super.addEdge(toID, fromID, weight, capacity, reverseEdge == -1 ? -1
//                : reverseEdge + 1);
//        this.transposedEdge[lastEdgeCount] = lastEdgeCount + 1;
//        this.transposedEdge[lastEdgeCount + 1] = lastEdgeCount;
//        return lastEdgeCount;
//    }
//
//    @Override
//    protected int entriesPerEdge() {
//        return 2;
//    }
//
//    @Override
//    public final int transposed(int id) {
//        return transposedEdge[id];
//    }
//
//    @Override
//    protected void ensureEdgeCapacity(int size) {
//        if (size > edgeCapacity()) {
//            super.ensureEdgeCapacity(size);
//            transposedEdge = resize(transposedEdge, edgeCapacity());
//        }
//    }
//}
//
//class IOUtils {
//    public static long[] readLongArray(InputReader in, int size) {
//        long[] array = new long[size];
//        for (int i = 0; i < size; i++)
//            array[i] = in.readLong();
//        return array;
//    }
//
//    public static int[] readIntArray(InputReader in, int size) {
//        int[] array = new int[size];
//        for (int i = 0; i < size; i++)
//            array[i] = in.readInt();
//        return array;
//    }
//}
//
//interface Function<A, V> {
//    public abstract V value(A argument);
//}
//
//class IntegerUtils {
//
//    public static List<Pair<Long, Integer>> factorize(long number) {
//        List<Pair<Long, Integer>> result = new ArrayList<Pair<Long, Integer>>();
//        for (long i = 2; i * i <= number; i++) {
//            if (number % i == 0) {
//                int power = 0;
//                do {
//                    power++;
//                    number /= i;
//                } while (number % i == 0);
//                result.add(Pair.makePair(i, power));
//            }
//        }
//        if (number != 1)
//            result.add(Pair.makePair(number, 1));
//        return result;
//    }
//
//    public static List<Long> getDivisors(long number) {
//        List<Pair<Long, Integer>> primeDivisors = factorize(number);
//        return getDivisorsImpl(primeDivisors, 0, 1, new ArrayList<Long>());
//    }
//
//    private static List<Long> getDivisorsImpl(
//            List<Pair<Long, Integer>> primeDivisors, int index, long current,
//            List<Long> result) {
//        if (index == primeDivisors.size()) {
//            result.add(current);
//            return result;
//        }
//        long p = primeDivisors.get(index).first;
//        int power = primeDivisors.get(index).second;
//        for (int i = 0; i <= power; i++) {
//            getDivisorsImpl(primeDivisors, index + 1, current, result);
//            current *= p;
//        }
//        return result;
//    }
//}
//
//class Pair<U, V> implements Comparable<Pair<U, V>> {
//    public final U first;
//    public final V second;
//
//    public static <U, V> Pair<U, V> makePair(U first, V second) {
//        return new Pair<U, V>(first, second);
//    }
//
//    private Pair(U first, V second) {
//        this.first = first;
//        this.second = second;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//
//        Pair pair = (Pair) o;
//
//        return !(first != null ? !first.equals(pair.first) : pair.first != null)
//                && !(second != null ? !second.equals(pair.second)
//                : pair.second != null);
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = first != null ? first.hashCode() : 0;
//        result = 31 * result + (second != null ? second.hashCode() : 0);
//        return result;
//    }
//
//    public Pair<V, U> swap() {
//        return makePair(second, first);
//    }
//
//    @Override
//    public String toString() {
//        return "(" + first + "," + second + ")";
//    }
//
//    @SuppressWarnings({ "unchecked" })
//    public int compareTo(Pair<U, V> o) {
//        int value = ((Comparable<U>) first).compareTo(o.first);
//        if (value != 0)
//            return value;
//        return ((Comparable<V>) second).compareTo(o.second);
//    }
//}
//
//class InputReader {
//    private boolean finished = false;
//
//    private InputStream stream;
//    private byte[] buf = new byte[1024];
//    private int curChar;
//    private int numChars;
//    private SpaceCharFilter filter;
//
//    public InputReader(InputStream stream) {
//        this.stream = stream;
//    }
//
//    public int read() {
//        if (numChars == -1)
//            throw new InputMismatchException();
//        if (curChar >= numChars) {
//            curChar = 0;
//            try {
//                numChars = stream.read(buf);
//            } catch (IOException e) {
//                throw new InputMismatchException();
//            }
//            if (numChars <= 0)
//                return -1;
//        }
//        return buf[curChar++];
//    }
//
//    public int peek() {
//        if (numChars == -1)
//            return -1;
//        if (curChar >= numChars) {
//            curChar = 0;
//            try {
//                numChars = stream.read(buf);
//            } catch (IOException e) {
//                return -1;
//            }
//            if (numChars <= 0)
//                return -1;
//        }
//        return buf[curChar];
//    }
//
//    public int readInt() {
//        int c = read();
//        while (isSpaceChar(c))
//            c = read();
//        int sgn = 1;
//        if (c == '-') {
//            sgn = -1;
//            c = read();
//        }
//        int res = 0;
//        do {
//            if (c < '0' || c > '9')
//                throw new InputMismatchException();
//            res *= 10;
//            res += c - '0';
//            c = read();
//        } while (!isSpaceChar(c));
//        return res * sgn;
//    }
//
//    public long readLong() {
//        int c = read();
//        while (isSpaceChar(c))
//            c = read();
//        int sgn = 1;
//        if (c == '-') {
//            sgn = -1;
//            c = read();
//        }
//        long res = 0;
//        do {
//            if (c < '0' || c > '9')
//                throw new InputMismatchException();
//            res *= 10;
//            res += c - '0';
//            c = read();
//        } while (!isSpaceChar(c));
//        return res * sgn;
//    }
//
//    public String readString() {
//        int c = read();
//        while (isSpaceChar(c))
//            c = read();
//        StringBuilder res = new StringBuilder();
//        do {
//            if (Character.isValidCodePoint(c))
//                res.appendCodePoint(c);
//            c = read();
//        } while (!isSpaceChar(c));
//        return res.toString();
//    }
//
//    public boolean isSpaceChar(int c) {
//        if (filter != null)
//            return filter.isSpaceChar(c);
//        return isWhitespace(c);
//    }
//
//    public static boolean isWhitespace(int c) {
//        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
//    }
//
//    private String readLine0() {
//        StringBuilder buf = new StringBuilder();
//        int c = read();
//        while (c != '\n' && c != -1) {
//            if (c != '\r')
//                buf.appendCodePoint(c);
//            c = read();
//        }
//        return buf.toString();
//    }
//
//    public String readLine() {
//        String s = readLine0();
//        while (s.trim().length() == 0)
//            s = readLine0();
//        return s;
//    }
//
//    public String readLine(boolean ignoreEmptyLines) {
//        if (ignoreEmptyLines)
//            return readLine();
//        else
//            return readLine0();
//    }
//
//    public BigInteger readBigInteger() {
//        try {
//            return new BigInteger(readString());
//        } catch (NumberFormatException e) {
//            throw new InputMismatchException();
//        }
//    }
//
//    public char readCharacter() {
//        int c = read();
//        while (isSpaceChar(c))
//            c = read();
//        return (char) c;
//    }
//
//    public double readDouble() {
//        int c = read();
//        while (isSpaceChar(c))
//            c = read();
//        int sgn = 1;
//        if (c == '-') {
//            sgn = -1;
//            c = read();
//        }
//        double res = 0;
//        while (!isSpaceChar(c) && c != '.') {
//            if (c == 'e' || c == 'E')
//                return res * Math.pow(10, readInt());
//            if (c < '0' || c > '9')
//                throw new InputMismatchException();
//            res *= 10;
//            res += c - '0';
//            c = read();
//        }
//        if (c == '.') {
//            c = read();
//            double m = 1;
//            while (!isSpaceChar(c)) {
//                if (c == 'e' || c == 'E')
//                    return res * Math.pow(10, readInt());
//                if (c < '0' || c > '9')
//                    throw new InputMismatchException();
//                m /= 10;
//                res += (c - '0') * m;
//                c = read();
//            }
//        }
//        return res * sgn;
//    }
//
//    public boolean isExhausted() {
//        int value;
//        while (isSpaceChar(value = peek()) && value != -1)
//            read();
//        return value == -1;
//    }
//
//    public String next() {
//        return readString();
//    }
//
//    public SpaceCharFilter getFilter() {
//        return filter;
//    }
//
//    public void setFilter(SpaceCharFilter filter) {
//        this.filter = filter;
//    }
//
//    public interface SpaceCharFilter {
//        public boolean isSpaceChar(int ch);
//    }
//}
//
//class OutputWriter {
//    private final PrintWriter writer;
//
//    public OutputWriter(OutputStream outputStream) {
//        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
//                outputStream)));
//    }
//
//    public OutputWriter(Writer writer) {
//        this.writer = new PrintWriter(writer);
//    }
//
//    public void print(char[] array) {
//        writer.print(array);
//    }
//
//    public void print(Object... objects) {
//        for (int i = 0; i < objects.length; i++) {
//            if (i != 0)
//                writer.print(' ');
//            writer.print(objects[i]);
//        }
//    }
//
//    public void print(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            if (i != 0)
//                writer.print(' ');
//            writer.print(array[i]);
//        }
//    }
//
//    public void print(long[] array) {
//        for (int i = 0; i < array.length; i++) {
//            if (i != 0)
//                writer.print(' ');
//            writer.print(array[i]);
//        }
//    }
//
//    public void printLine(int[] array) {
//        print(array);
//        writer.println();
//    }
//
//    public void printLine(long[] array) {
//        print(array);
//        writer.println();
//    }
//
//    public void printLine() {
//        writer.println();
//    }
//
//    public void printLine(Object... objects) {
//        print(objects);
//        writer.println();
//    }
//
//    public void print(char i) {
//        writer.print(i);
//    }
//
//    public void printLine(char i) {
//        writer.println(i);
//    }
//
//    public void printLine(char[] array) {
//        writer.println(array);
//    }
//
//    public void printFormat(String format, Object... objects) {
//        writer.printf(format, objects);
//    }
//
//    public void close() {
//        writer.close();
//    }
//
//    public void flush() {
//        writer.flush();
//    }
//
//    public void print(long i) {
//        writer.print(i);
//    }
//
//    public void printLine(long i) {
//        writer.println(i);
//    }
//
//    public void print(int i) {
//        writer.print(i);
//    }
//
//    public void printLine(int i) {
//        writer.println(i);
//    }
//}
//
//class ArrayUtils {
//
//    public static int[] createOrder(int size) {
//        int[] order = new int[size];
//        for (int i = 0; i < size; i++)
//            order[i] = i;
//        return order;
//    }
//
//    public static int maxPosition(int[] array) {
//        return maxPosition(array, 0, array.length);
//    }
//
//    public static int maxPosition(int[] array, int from, int to) {
//        if (from >= to)
//            return -1;
//        int max = array[from];
//        int result = from;
//        for (int i = from + 1; i < to; i++) {
//            if (array[i] > max) {
//                max = array[i];
//                result = i;
//            }
//        }
//        return result;
//    }
//
//}