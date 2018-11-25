package BasicAlgorithms.MyGraph;
import java.util.*;
//https://codereview.stackexchange.com/questions/67704/optimizing-dijkstra-implementation-using-priorityqueue-in-java
class DijBest {
    public static int shortestPathDijkstra(Node source, Node target) {
        Map<Node, MyDijkstraNode> result = new HashMap<>(); // can be an array if vertices are integer-indexed.
        PriorityQueue<MyDijkstraNode> pq = new PriorityQueue<>(Comparator.comparingInt(MyDijkstraNode::getMinCost));

        MyDijkstraNode resultSource = new MyDijkstraNode(source);
        resultSource.setPre(null);
        resultSource.setMinCost(0);
        pq.add(resultSource);
        result.put(source, resultSource);

        Set<Node> btdt = new HashSet<>(); // can be a boolean array if vertices are integer-indexed.
        while (!pq.isEmpty()) {
            MyDijkstraNode uNode = pq.poll();
            Node u = uNode.getU();
            if (btdt.contains(u)) {
                continue;
            }
            btdt.add(u);
            Map<Node, Integer> edges = u.getNeighbours();
            for (Map.Entry<Node, Integer> e : edges.entrySet()) {
                Node v = e.getKey();
                int w = e.getValue();
                if (btdt.contains(v)) {
                    continue;
                }
                MyDijkstraNode existingNode = result.get(v);
                if (existingNode == null || existingNode.getMinCost() > uNode.getMinCost() + w) {
                    MyDijkstraNode newNode = new MyDijkstraNode(v);
                    newNode.setMinCost(uNode.getMinCost() + w);
                    newNode.setPre(uNode);
                    pq.add(newNode);
                    result.put(v, existingNode);
                }
            }
        }
        MyDijkstraNode targetDijkstraNode = result.get(target);
        if (targetDijkstraNode == null) {
            throw new RuntimeException("no path found");
        }
        return targetDijkstraNode.getMinCost();
        // or return targetDijkstraNode to get full path.
        // or return result to get all shortest paths to all other vertices from single source.
    }
}
class Node {
    private final char label;
    private final Map<Node, Integer> neighbours;

    public Node(char label) {
        this.label = label;
        neighbours = new HashMap<>();
    }

    public void addNeighbour(Node node, int distance) {
        neighbours.put(node, distance);
    }

    public char getLabel() {
        return label;
    }

    public Map<Node, Integer> getNeighbours() {
        return neighbours;
    }
}

class MyDijkstraNode {
    private Node u;
    private int minCost;
    private MyDijkstraNode pre;

    public MyDijkstraNode(Node u) {
        this.u = u;
    }

    public Node getU() {
        return u;
    }

    public int getMinCost() {
        return minCost;
    }

    public MyDijkstraNode getPre() {
        return pre;
    }

    public void setPre(MyDijkstraNode pre) {
        this.pre = pre;
    }

    public void setMinCost(int minCost) {
        this.minCost = minCost;
    }
}