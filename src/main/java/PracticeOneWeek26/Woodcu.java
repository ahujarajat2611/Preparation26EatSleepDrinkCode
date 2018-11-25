package PracticeOneWeek26;

/**
 * Created by hadoop on 9/12/17.
 */
public class Woodcu {
    public int woodcut(int []length,int k ){
        int maxlen = max(length);
        int left = 0;
        int right = maxlen;
        while (left<right){
            System.out.println("left "+left);
            System.out.println("right "+right);
            int mid = left + (right-left+1)/2;
            System.out.println("mid "+mid);
            int pieces = getpiece(length,mid);
            System.out.println("pieces "+pieces);
            System.out.println(  "     ");
            if(pieces>=k){
                left = mid;
            }
            else {
                right = mid-1;
            }
        }
        return right;
    }

    private int getpiece(int[] length, int mid) {
        int count = 0;
        for(int x:length){
            count = count + x/mid;
        }
        return count;
    }

    int max(int []length){
        int max = Integer.MIN_VALUE;
        for(int x:length){
            max = Math.max(max,x);
        }
        return max;
    }


    public int woodcutnormal(int []length,int k ){
        int maxlen = max(length);
        int left = 0;
        int right = maxlen;
        while (left<=right){
            System.out.println("left "+left);
            System.out.println("right "+right);
            int mid = left + (right-left)/2;
            System.out.println("mid "+mid);
            int pieces = getpiece(length,mid);
            System.out.println("pieces "+pieces);
            System.out.println(  "     ");
            if(pieces<k){
                right = mid;
            }
            else {
                left = mid +1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Woodcu woodcu = new Woodcu();
        System.out.println(woodcu.woodcut(new int[]{124,232,456},7));
        System.out.println(woodcu.woodcutnormal(new int[]{124,232,456},7));
    }
}
