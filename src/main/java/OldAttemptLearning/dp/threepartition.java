package OldAttemptLearning.dp;

/**
 * Created by hadoop on 11/8/17.
 */
public class threepartition {
    public static void main(String[] args) {
        int array []={7,3,2,1,5,4,8};
        boolean ans = paritirion(array);
        System.out.println(ans);
    }

    private static boolean paritirion(int[] array) {
        int sum = 0;
        for( int i=0;i<array.length;i++) {
            sum = sum + array[i];
        }
        if(sum%3!=0){
            return false;
        }
        else {
            return partitionarraysinto3sets(array,sum/3,sum/3,sum/3,array.length-1);
        }
    }

    private static boolean partitionarraysinto3sets(int[] array, int i, int i1, int i2,int index) {
        System.out.println("i "+i);
        System.out.println("i1 "+i1);
        System.out.println("i2 "+i2);
        System.out.println("index "+index);


        if(i1==0 && i==0 && i2 ==0){
            if(index < 0){
                return true;
            }
            else {
                return false;
            }
        }

        if(index<0){
            return false;
        }
        if(i1<0 || i2<0||i<0){
            return false;
        }

        boolean A = partitionarraysinto3sets(array,i-array[index],i1,i2,index-1);

        boolean B = partitionarraysinto3sets(array,i,i1-array[index],i2,index-1);

        boolean C = partitionarraysinto3sets(array,i,i1,i2-array[index],index-1);

        return A || B || C;


    }
    public static boolean subsetsum(int array[],int sum, int index){
        if(sum == 0){
            return true;
        }
        if(index<0 || sum <0)
            return false;

        boolean include = subsetsum(array,sum-array[index],index-1);

        boolean exclude = subsetsum(array,sum,index-1);

        return include|| exclude;
    }

    public static int knapsack(int array[], int value[], int sum, int index){
        if(index<0 || sum <0){
            return 0;
        }
        if(sum == 0){
            return 0;
        }
        int include = value[index]+knapsack(array,value,sum-array[index],index-1);
        int exclude = knapsack(array,value,sum,index-1);

        return Math.max(include,exclude);
    }

}
