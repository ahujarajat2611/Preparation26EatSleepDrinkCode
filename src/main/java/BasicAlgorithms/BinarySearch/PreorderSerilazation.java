package BasicAlgorithms.BinarySearch;

import java.util.StringTokenizer;

/**
 * Created by hadoop on 18/10/17.
 */
public class PreorderSerilazation {
    public boolean isValidSerialization(String preorder) {
        int indegree = -1;
        int outdegree = 0;
        String[] array = preorder.split(",");
        int hashcount = 0;
        int nodecount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("#")) {
                hashcount++;
            } else {
                nodecount++;
            }
        }
        return nodecount + 1 == hashcount;
    }

        public boolean isValidSerializationagain (String preorder){
            int indegree = 0;
            int outdegree = 2;
            String[] array = preorder.split(",");
            if (array.length == 1) {
                return array[0].equals("#");
            }
            if (array == null || array.length == 0) {
                return true;
            }
            if (array[0].equals("#")) {
                return false;
            }



            // for root indegree has to zero
            // if indegree== outdegree in between means there is problem
            // always outdegree will be more than indegree until it finishssss
            //for each node 2 outdegree and 1 indhhgree
            // for null nodes indegree =1 outdegree =0;
            // in the end indegree === outdegreee
            for (int i = 1; i < array.length; i++) {

                // throughtout the traveeral indegreee has to be lesss than out degree if indegree becomes equals to outdegree means theere
                // is no edge that we can form
                if (indegree >= outdegree) {
                    return false;
                }
                if (array[i].equals("#")) {
                    indegree++;
                } else {
                    indegree++;
                    outdegree = outdegree + 2;
                }
                System.out.println("inde " + indegree);
                System.out.println("out " + outdegree);
            }
            System.out.println("inde " + indegree);
            System.out.println("out " + outdegree);
            return indegree == outdegree;
        }

    public boolean isValidSerializationEasy(String preorder) {
        StringTokenizer tokens = new StringTokenizer(preorder, ",");
        return dfs(tokens) && !tokens.hasMoreTokens();
    }

    private boolean dfs(StringTokenizer tokens) {
        if(!tokens.hasMoreTokens())
            return false;

        String token = tokens.nextToken();
        if (token.equals("#"))
            return true;

        return dfs(tokens) && dfs(tokens);
    }
    }


