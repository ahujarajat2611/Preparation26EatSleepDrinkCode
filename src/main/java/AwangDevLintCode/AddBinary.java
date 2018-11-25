package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return null;
        }
        char[] shortArr = a.length() < b.length() ? a.toCharArray() : b.toCharArray();
        char[] longArr = a.length() < b.length() ? b.toCharArray() : a.toCharArray();
        int carry = 0;
        int shortVal = 0;
        int nextCarry = 0;
        int diff = longArr.length - shortArr.length;
        for (int i = longArr.length - 1; i >= 0; i--) {
            shortVal = (i - diff) >= 0 ? shortArr[i - diff] - '0': 0;
            nextCarry = (longArr[i] - '0' + shortVal + carry) / 2;
            longArr[i] =(char)((longArr[i] - '0' + shortVal + carry) % 2 + '0');
            carry = nextCarry;
        }
        int i = longArr.length-1;
        int j = shortArr.length-1;

        char ans [] = new char[longArr.length];
        int k = longArr.length-1;
        int car =0;
        while (i>=0 || j>=0){

            int shValue=0;

            if(i>=0){
                shValue = shortArr[i]-'0';
            }
            int lnValue=0;

            if(j>=0){
                lnValue = longArr[j]-'0';
            }

            int sum = (shValue + lnValue + car)/10;
            car = (shValue + lnValue+car)%10;
            ans[k--] = (char)(sum + '0');

        }
        String myans = "";
        if(car!=0){
            myans = "1" + new String(ans);
        }
        System.out.println(myans);

        if (carry != 0) {
            return "1" + new String(longArr);
        }

        return new String(longArr);
    }
    // such a elegant solution
    // better not to confuse and keeps ting simple .. but yeah
    // other part is also easy pick i andd thne pick i-diff
    // carry = carry + first + second /10  ans = carry + first + second %10
    // just too good
    // start from LSB nd moves towards MSB just too perfect !! wta solution
    // if array exisit then consider else put zero to addd ( watta trick)
    public String addBinaryAgain(String a,String b){
        char[] shortArr = a.length() < b.length() ? a.toCharArray() : b.toCharArray();
        char[] longArr = a.length() < b.length() ? b.toCharArray() : a.toCharArray();

        int i = shortArr.length-1;
        int j = longArr.length-1;

        char ans [] = new char[longArr.length];
        int k = longArr.length-1;
        int car =0;
        while (i>=0 || j>=0){

            int shValue=0;

            if(i>=0){
                shValue = shortArr[i]-'0';
            }

            int lnValue=0;

            if(j>=0){
                lnValue = longArr[j]-'0';
            }

            int sum = (shValue + lnValue + car)%2;

            car = (shValue + lnValue+car)/2;

            ans[k] = (char)(sum + '0');
            k--;
            i--;
            j--;
        }
        if(car!=0){
            return  "1" + new String(ans);
        }
        System.out.println(new String(ans));
        return new String(ans);
    }

    public static void main(String[] args) {
        AddBinary addBinary  = new AddBinary();
        System.out.println(addBinary.addBinaryAgain("1011","110"));
        //System.out.println(addBinary.addBinary("1011","110"));
    }
}

