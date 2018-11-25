package BasicAlgorithms.MyGraph;

public class C6_18_GraphPainter {
    public static int[] paint(Graph graph){
        int[] color = new int[graph.getV()];

        for(int i = 0; i < graph.getV(); i++){
            if(graph.adj(i) == null) color[i] = 1;
        }

        int i = 0;
        while(i < graph.getV()){
            if(color[i] == 1);
            else if(color[i] == 0){
                color[i] = 1;
                for(Integer t : graph.adj(i)) {
                    color[t] = 2;
                }
            } else {
                for(Integer t: graph.adj(i)){
                    if(color[t] == color[i]) color[t]++;
                }
            }
            i++;
        }
        return color;
    }

}
