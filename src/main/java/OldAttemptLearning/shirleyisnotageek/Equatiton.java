package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/*
Evaluate Division
Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].
The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
According to the example above:
equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

Build a map from all the equations. The variables are indices and equations are edges. Map the string variable with certain index using hash map. Then build a matrix to represent all values that can be represented by the given equations. For example, a/b means a and b are neighbors, b/c means b and c are neighbors, thus we know a and c are connected and we can calculate the value of a/c by a/b * b/c, as well as c / a by 1.0 / (a/c).

After that, for each query, if we cannot find the index in the map, we cannot get the result.
 */
/**
 * Created by hadoop on 22/1/18.
 */
public class Equatiton {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        int len = equations.length;

        Map<String,Integer> indices = new HashMap<>();
        int index = 0;
        for (String[] eq : equations) {
            if (!indices.containsKey(eq[0])) {
                indices.put(eq[0], index++);
            }
            if (!indices.containsKey(eq[1])) {
                indices.put(eq[1], index++);
            }
        }

        double[][] relations = new double[index][index];
        for (int i = 0; i < index; i++) {
            Arrays.fill(relations[i], -1.0);
        }
        for (int i = 0; i < len; i++) {
            String[] eq = equations[i];
            double v = values[i];
            int first = indices.get(eq[0]);
            int second = indices.get(eq[1]);
            relations[first][second] = v;
            relations[second][first] = 1.0 / v;
        }

        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                for(int k = 0; k < index; k++) {
                    if (relations[i][j] != -1.0) {
                        continue;
                    }
                    if (relations[i][k] != -1.0 && relations[k][j] != -1.0) {
                        relations[i][j] = relations[i][k] * relations[k][j];
                        if (relations[i][j] != 0.0) {
                            relations[j][i] = 1.0 / relations[i][j];
                        }
                    }
                }
            }
        }

        double[] rst = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (!indices.containsKey(queries[i][0]) || !indices.containsKey(queries[i][1])) {
                rst[i] = -1.0;
            } else {
                int first = indices.get(queries[i][0]);
                int second = indices.get(queries[i][1]);
                rst[i] = relations[first][second];
            }
        }
        return rst;
    }
}
