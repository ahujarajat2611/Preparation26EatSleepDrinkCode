package PracticeOneWeek26;

/**
 * Created by hadoop on 7/12/17.
 */
public class AplusB {
    public int aplub(int a,int b){
        while (b>0){
            int carry = a&b;
            int sum = a^b;
            a = sum;
            b = carry<<1;
        }
        return a;
    }

    public static void main(String[] args) {
        AplusB aplusB = new AplusB();
        System.out.println(aplusB.aplub(45,64));
    }
}
