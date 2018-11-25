package BasicAlgorithms.String;

/**
 * Created by hadoop on 14/10/17.
 */
public class RotateArray {
    public void rotateString(char[] str, int offset) {
        int length = str.length;
        offset = offset%length;
        int cycles = gcd(length,offset);
        int loops = length/offset +1;
        for(int i=0;i<cycles;i++){
            int tempindex = i;
            char tempvalue = str[i];
            while (true){
                int pos = (tempindex-offset+str.length)%str.length;
                if(pos == i){
                    break;
                }
                str[tempindex] = str[pos];
                tempindex = pos;
            }
            str[tempindex] = tempvalue;
        }
        }

    private int gcd(int length, int offset) {
        if(offset>length){
            return gcd(offset,length);
        }
        if(length%offset == 0){
            return offset;
        }
        return gcd(offset,length%offset);
    }

    public static void main(String[] args) {
        char a[]={'a','b','c','d','e','f'};
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotateStringMine(a,2);

        System.out.println(String.valueOf(a));
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