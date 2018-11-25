package BasicAlgorithms.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 11/10/17.
 */
public class PascalTriangle {
        public List<List<Integer>> generate(int rows) {
            List<Integer> list = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();

            if(rows == 0){
                return result;
            }
            int array[][] = new int[rows+1][rows+1];
            for(int i=0;i<=rows;i++){
                //// very very impppppppp
                // initializatioon here keep an eye
                array[i][1] = 1;
                array[i][i] = 1;
            }
            List<Integer> listAdd = new ArrayList<>();

            for(int i=1;i<=rows;i++){
                listAdd.clear();
                for(int j=1;j<=i;j++){
                    if(i == j){
                        array[i][j] = 1;
                    }
                    else{
                        array[i][j] = array[i-1][j-1]+array[i-1][j];
                    }
                    System.out.print(array[i][j]+",");
                    listAdd.add(array[i][j]);
                }
                System.out.println();
                result.add(new ArrayList<>(listAdd));
            }
            return result;
        }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        pascalTriangle.generate(2);
    }
}

/*
List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        if(rows == 0){
            return result;
        }
        int array[][] = new int[rows+1][rows+1];
        List<Integer> listAdd = new ArrayList<>();
        for(int i=0;i<rows;i++){
            listAdd.clear();
            for(int j=0;j<=i;j++){
                if(i == j || j ==0 ){
                    array[i][j] = 1;
                }
                else{
                    array[i][j] = array[i-1][j-1]+array[i-1][j];
                }
                listAdd.add(array[i][j]);
            }
            result.add(new ArrayList<>(listAdd));
        }
        return result;
 */