package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 20/9/17.
 */
public class RomanToInt {
    Map<Character,Integer> map = new HashMap<>();
    RomanToInt(){
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
    }
    int romantoint(String x){
        int result = 0;
        for(int i=0;i<x.length();i++){
            if(i>0 && map.get(x.charAt(i))>map.get(x.charAt(i-1))){
                result = result + map.get(x.charAt(i))-2*map.get(x.charAt(i-1));
            }
            else {
                result = result + map.get(x.charAt(i));
            }
        }
        return result;
    }
    String inttoroman(int a){
        int array[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String []roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String output = "";
        while (a!=0){
            for(int i=0;i<array.length;i++){
                int times=a/array[i];
                int remainder = a%array[i];
                for(int k=0;k<times;k++){
                    output = output+roman[i];
                }
                a = remainder;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.inttoroman(3549));
    }
}
