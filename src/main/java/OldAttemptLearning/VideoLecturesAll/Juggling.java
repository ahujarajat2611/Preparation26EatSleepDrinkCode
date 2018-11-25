package OldAttemptLearning.VideoLecturesAll;

/**
 * Created by hadoop on 31/8/17.
 */
public class Juggling {
    public static void main(String args[]){
        int []array = {1,2,3,4,5,6,7,8,9};
        int n = 9;
        int k = 3;
        for( int i=0;i<gcd(n,k);i++){
            int temp = array[i];
            int j = i;
            while(true){
                int pos = (j+k)%n;
                if(pos == i)
                    break;
                array[j] = array[pos];
                j = pos;
            }
            array[j] = temp;
        }
        for(int i=0;i<array.length;i++){
            System.out.println("ans is "+array[i]);
        }
    }
    static int gcd(int a, int b ){
        if(a>b){
            return gcd(b,a);
        }
        else{
            if(b%a==0){
                return a;
            }
            else return gcd(a,b%a);
        }
    }

    public void rotateStringMine(char[] str, int offset) {
        int length = str.length;
        int gc = gcd(offset,length);
        for(int i=0;i<gc;i++) {

            char temp = str[i];
            int tempindex = i;

            while (true) {

                int newindex = (tempindex - offset + str.length) % str.length;
                //int saved = str[tempindex];
                if (newindex == i) {
                    break;
                }
                str[tempindex] = str[newindex];
                tempindex = newindex;
            }
            str[tempindex] = temp;
        }
    }

}
