package BasicAlgorithms.MyGraph;
import java.util.*;

/**
 * Created by hadoop on 21/10/17.
 */
public class ReconstructIterniary {
    public List<List<String>> findItinerary(String[][] tickets) {
        HashMap<String,HashSet<String>> graph = new HashMap<>();
        for(int i=0;i<tickets.length;i++){
            graph.put(tickets[i][0],new HashSet<>());
        }
        for(int i=0;i<tickets.length;i++){
            graph.get(tickets[i][0]).add(tickets[i][1]);
        }

        List<String> path = new ArrayList<>();
        List<List<String>> result  = new ArrayList<>();
        Set<Edge> visited = new HashSet<>();
        path.add("JFK");
        //visited.add("JFK");
        int numberOfNodes = tickets.length;
        dfsHelper(path,result,"JFK",graph,visited,numberOfNodes);
//        if(result.size()!=0){
//            return result.get(0);
//        }
        System.out.println(result);
        return result;
    }

    private void dfsHelper(List<String> path, List<List<String>> result, String u, HashMap<String, HashSet<String>> graph, Set<Edge> visited, int numberOfNodes) {
        if(path.size() == numberOfNodes+1){
            result.add(new ArrayList<>(path));
            return;
        }
        for(String v:graph.get(u)){
            if(!visited.contains(new Edge(u,v))){
                visited.add(new Edge(u,v));
                path.add(v);
                dfsHelper(path,result,v,graph,visited,numberOfNodes);
                visited.remove(new Edge(u,v));
                path.remove(path.size()-1);
            }
        }

    }
    private class Edge{
        String src;
        String dst;

        public Edge(String src, String dst) {
            this.src = src;
            this.dst = dst;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if (src != null ? !src.equals(edge.src) : edge.src != null) return false;
            return dst != null ? dst.equals(edge.dst) : edge.dst == null;
        }

        @Override
        public int hashCode() {
            int result = src != null ? src.hashCode() : 0;
            result = 31 * result + (dst != null ? dst.hashCode() : 0);
            return result;
        }
    }
    public static void main(String args[]){
        ReconstructIterniary reconstructIterniary = new ReconstructIterniary();
       // String [][]tickets={{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        String [][]tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        System.out.println(reconstructIterniary.findItinerary(tickets));
    }

}
/*
// Author: Zhonghua Xi (huahua)
// Running time: 13 ms
class Solution {
public:
    vector<string> findItinerary(vector<pair<string, string>> tickets) {
        route_.clear();
        trips_.clear();

        for(const auto& pair : tickets)
            trips_[pair.first].push_back(pair.second);

        for(auto& pair : trips_) {
            auto& dests = pair.second;
            std::sort(dests.begin(), dests.end());
        }

        const string kStart = "JFK";

        visit(kStart);

        return vector<string>(route_.crbegin(), route_.crend());
    }
private:
    // src -> {dst1, dest2, ..., destn}
    unordered_map<string, deque<string>> trips_;
    // ans (reversed)
    vector<string> route_;

    void visit(const string& src) {
        auto& dests = trips_[src];
        while (!dests.empty()) {
            // Get the smallest dest
            const string dest = dests.front();
            // Remove the ticket
            dests.pop_front();
            // Visit dest
            visit(dest);
        }
        // Add current node to the route
        route_.push_back(src);
    }
};

http://zxi.mytechroad.com/blog/graph/leetcode-332-reconstruct-itinerary/
 */
/*
public class Solution {
    // implements Comparable<E>, do not forget the generic type
    class DirectedGraphNode implements Comparable<DirectedGraphNode>{
        String label;
        PriorityQueue<DirectedGraphNode> neighbors;
        DirectedGraphNode(String label){
            this.label = label;
            neighbors = new PriorityQueue<DirectedGraphNode>();
        }
        @Override // compareTo method must be public
        public int compareTo(DirectedGraphNode that){
            return this.label.compareTo(that.label);
        }
    }
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, DirectedGraphNode> map = init(tickets);
        DirectedGraphNode publish = map.get("JFK");
        List<String> result = new ArrayList<String>();
        dfs(publish, result);
        Collections.reverse(result); // do not forget reverse
        return result;
    }
    public void dfs(DirectedGraphNode cur, List<String> result){
        while(!cur.neighbors.isEmpty()){
            dfs(cur.neighbors.poll(), result);
        }
        result.add(cur.label);
    }
    public HashMap<String, DirectedGraphNode> init(String[][] tickets){
        HashMap<String, DirectedGraphNode> map = new HashMap<>();
        for (String[] ticket: tickets){
            String from = ticket[0];
            String to = ticket[1];
            DirectedGraphNode fromNode = map.get(from);
            DirectedGraphNode toNode = map.get(to);
            if (fromNode == null){
                fromNode = new DirectedGraphNode(from);
                map.put(from, fromNode);
            }
            if (toNode == null){
                toNode = new DirectedGraphNode(to);
                map.put(to, toNode);
            }
            fromNode.neighbors.offer(toNode);
        }
        return map;
    }
}

 */