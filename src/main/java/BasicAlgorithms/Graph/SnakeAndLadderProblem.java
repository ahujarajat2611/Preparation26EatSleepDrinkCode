package BasicAlgorithms.Graph;
import java.util.*;
import java.util.Queue;

public class SnakeAndLadderProblem {

    // clearly it is bfs
    int getMinDiceThrows(int move[], int N) {
        Queue<Vertex> queue = new LinkedList<Vertex>();
        Vertex starter = new Vertex(0, 0);
        queue.add(starter);
        boolean[] visited = new boolean[N];
        Vertex res = null;
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            if (v.id == N - 1) {
                res = v;
                break;
            }
            for (int i = v.id + 1; i <= v.id + 6 && i < N; i++) {
                if (visited[i]) {
                    continue;
                }
                Vertex neighbour = new Vertex();
                if (move[i] != -1) {
                    neighbour.id = move[i];
                } else {
                    neighbour.id = i;
                }
                neighbour.dist = v.dist + 1;
                queue.add(neighbour);
                visited[i] = true;
            }
        }

        if (res == null) {
            throw new RuntimeException("No solution!");
        }

        return res.dist;
    }

    class Vertex {
        int id;
        int dist;

        public Vertex() {
        }

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "id=" + id +
                    ", dist=" + dist +
                    '}';
        }
    }
}