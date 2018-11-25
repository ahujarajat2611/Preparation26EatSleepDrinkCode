package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 4/3/18.
 */
import java.util.*;
public class DivisionMine {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String,HashMap<String,Double>> graph = new HashMap<String,HashMap<String,Double>>();
        List<Double>list = new ArrayList<Double>();
        for(int i=0;i<equations.length;i++){
            if(!graph.containsKey(equations[i][0])){
                graph.put(equations[i][0],new HashMap<String,Double>());
            }
            if(!graph.containsKey(equations[i][1])){
                graph.put(equations[i][1],new HashMap<String,Double>());
            }
            graph.get(equations[i][0]).put(equations[i][1],values[i]);
            graph.get(equations[i][1]).put(equations[i][0],(1.0/values[i]));
        }
        //System.out.println(graph);

        for(int i=0;i<queries.length;i++){
            String []query = queries[i];
            HashSet<String> visited = new HashSet<String>();
            visited.add(query[0]);
            double []val = new double[1];
            val[0] = 1;
            if(search(graph,query[0],query[1],visited,val)) {
                list.add(val[0]);
            }
            else {
                list.add(-1.0);
            }
        }
        int i=0;
        double []ans = new double[list.size()];
        for(Double d:list){
            ans[i++] = d;
        }
        // System.out.println(list);
        return ans;
    }
    boolean search(HashMap<String,HashMap<String,Double>> graph, String start, String end,HashSet<String> visited,double []ans){
        //assuming no cycle
        if(!graph.containsKey(start)){
            return false;
        }
        //  visited.add(publish);
        if(start == end){
            return true;
        }
        for(Map.Entry<String,Double> entry: graph.get(start).entrySet()){
            if(!visited.contains(entry.getKey())){
                visited.add(entry.getKey());
                // System.out.println("Entry value "+entry.getValue());
                if(search(graph,entry.getKey(),end,visited,ans)){
                    ans[0] = ans[0]*entry.getValue();
                    return true;
                }
            }
            visited.remove(entry.getKey());

        }
        return false;
    }

    public static void main(String[] args) {
        DivisionMine divisionMine = new DivisionMine();
        String [][]equations = { {"a", "b"}, {"b", "c"} };
        double [] values = {2.0, 3.0};
        String [][] queries = {{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        String [][]query = {{"b","c"}};
        double [] my = divisionMine.calcEquation(equations,values,queries);
        for(double x:my){
            System.out.println(x);
        }
    }
}
