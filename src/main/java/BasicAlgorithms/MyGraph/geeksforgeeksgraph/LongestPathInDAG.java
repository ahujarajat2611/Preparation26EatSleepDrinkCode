package BasicAlgorithms.MyGraph.geeksforgeeksgraph;

public class LongestPathInDAG {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);
        int s = 1;
        g.findLongestPath(s);
    }

    public static class Graph {
        private int V;
        private int[][] matrix;
        private int[] vertices;
        private boolean[] visited;
        private int[] distances;
        private int[] predecessor;
        private Stack stack;

        public Graph(int V) {
            this.V = V;
            vertices = new int[V];
            visited = new boolean[V];
            predecessor = new int[V];
            distances = new int[V];
            matrix = new int[V][V];
            stack = new Stack(V);
            for (int i = 0; i < V; i++) {
                addVertex(i);
                distances[i] = Integer.MIN_VALUE;
                predecessor[i] = -1;
            }
        }

        private void addVertex(int name) {
            vertices[name] = name;
        }

        public void addEdge(int source, int destination, int weight) {
            matrix[source][destination] = weight;
        }

        public void findLongestPath(int source) {
            invokeTopologicalSort();
            distances[source] = 0; // Initialize source with 0
            updateMaxDistanceForAllAdjVertices(); // for all nodes connected,
                                                    // directly or indirectly,
                                                    // with source will have
                                                    // their distances
                                                    // calculated
            printDistances(source);
            printPath(source);
        }

        private void printDistances(int source) {
            System.out.println("Distances from source " + source + " are as follows: ");
            for (int to = 0; to < V; to++) {
                int distance = distances[to];
                System.out.print("from " + source + " to " + to + ": ");
                if (distance == Integer.MIN_VALUE) {
                    System.out.println(" -Infinity ");
                } else {
                    System.out.println(distance + " ");
                }
            }
            System.out.println();
        }

        private void printPath(int source) {
            System.out.println("Path from source " + source + " to other nodes are as follows: ");
            for (int i = 0; i < V; i++) {
                if (distances[i] == Integer.MIN_VALUE) {
                    System.out.println("No Path from " + source + " to " + i);
                } else if (i != source) {
                    int from = predecessor[i];
                    System.out.print("Path from " + source + " to " + i + ": ");
                    if (from == source) {
                        System.out.print(from + " ");
                    }
                    while (from != source) {
                        System.out.print(from + " ");
                        from = predecessor[from];
                    }
                    System.out.print(i + " ");
                    System.out.println();
                }
            }
        }

        private void updateMaxDistanceForAllAdjVertices() {
            while (!stack.isEmpty()) {
                int from = stack.pop();
                if (distances[from] != Integer.MIN_VALUE) {
                    for (int adjacent = 0; adjacent < V; adjacent++) {
                        if (matrix[from][adjacent] != 0) {
                            if (distances[adjacent] < distances[from] + matrix[from][adjacent]) {
                                predecessor[adjacent] = from;
                                distances[adjacent] = distances[from] + matrix[from][adjacent];
                            }
                        }
                    }
                }
            }
        }

        private void invokeTopologicalSort() {
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
        }

        private void dfs(int source) {
            visited[source] = true;
            for (int adjacent = 0; adjacent < V; adjacent++) {
                if (matrix[source][adjacent] != 0 && !visited[adjacent]) {
                    dfs(adjacent);
                }
            }
            stack.push(source);
        }

    }

    public static class Stack {
        private int maxSize;
        private int[] stack;
        private int top = -1;
        private int size = 0;

        public Stack(int maxSize) {
            this.maxSize = maxSize;
            stack = new int[maxSize];
        }

        public void push(int item) {
            stack[++top] = item;
            size++;
        }

        public int pop() {
            int item = stack[top--];
            size--;
            return item;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}