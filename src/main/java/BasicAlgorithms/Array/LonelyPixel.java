package BasicAlgorithms.Array;

/**
 * Created by hadoop on 25/12/17.
 */
public class LonelyPixel {
    public int findLonelyPixel(char[][] picture) {
        int []row = new int[picture.length];
        int []col = new int[picture[0].length];
        // keeping track of rows columns where found b
        for(int i=0;i<picture.length;i++){
            for(int j=0;j<picture[0].length;j++){
                if(picture[i][j] == 'B'){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int count =0;
        // if that row and column has only one b ..

        //if we dont use space we had to use 4 loops  to check B in all possible
        ///directions really nice apprach
        for(int i=0;i<picture.length;i++){
            for(int j=0;j<picture[0].length;j++){
                if(picture[i][j] == 'B' && row[i] == 1 && col[j] ==1){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LonelyPixel lp = new LonelyPixel();

    }
}