package zrzahid;

/**
 * Created by hadoop on 7/9/17.
 */
public class PermutationRank {
    public static void main(String[] args) {
        char array[]="DCBA".toCharArray();

        int rank = perrank(array);
        System.out.println("ans"+rank);
    }

    private static int perrank(char[] array) {
        int countelementsmaller[] = countsmaller(array);
        int rank=1;
        for(int i=0;i<array.length;i++){
            rank = rank+ countelementsmaller[i]*factorial(array.length-1-i);
            // imp to understand duplicate factor
            // we have to calculate duplicae
        }
        return rank;
    }

    private static int factorial(int i) {
        if(i==0 )return 1;
        return factorial(i-1)*i;
    }


    private static int[] countsmaller(char[] array) {
        int []smaller = new int[array.length];
        for(int i=0;i<array.length;i++){
            int count=0;
            for(int j=i+1;j<array.length;j++){
                // calculte duplicate
                // and then devide by that factorial number
                if(array[j]<array[i]){
                    count++;
                }
            }
            smaller[i]=count;
        }
        return smaller;
    }

}
