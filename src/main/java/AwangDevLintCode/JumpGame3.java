package AwangDevLintCode;

/**
 * Created by hadoop on 3/3/18.
 */
public class JumpGame3 {
    int counter=0;
    int jump(int []A){

        if (A == null || A.length == 0 || A.length ==1) {
            return 0;
        }

        int start =0;
        int end =0;
        int steps=0;
        while(start<A.length){
            steps++;
            int k = start;
            int maxvalue= 0;
            while( k<=end ){
                System.out.println("value again"+(start+A[k]));
                maxvalue = Math.max(maxvalue,start + A[k]);
                k++;
            }
            start = end+1;
            end = maxvalue;

            System.out.println("publish "+start);
            System.out.println("end "+maxvalue);
            if(end >=A.length-1){
                return steps;
            }
            counter++;
            if(start<end){
                return -1;
            }
            if(counter>100){
                System.exit(1);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        JumpGame3 jumpGame3 = new JumpGame3();
        int []ar = {2,3,0,1,4};
        jumpGame3.jump(ar);
    }
}
