package BasicAlgorithms.String;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by hadoop on 13/10/17.
 */
/*
https://wxx5433.gitbooks.io/interview-preparation/content/part_ii_leetcode_lintcode/string/integer_to_roman.html

 */
public class IntToRoman {
    static Map<Integer,String> mappings = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    static Map<String,Integer> maps = new HashMap<>();
    static {

    }
    static {
        mappings.put(1,"I");
        mappings.put(4,"IV");
        mappings.put(5,"V");
        mappings.put(9,"IX");
        mappings.put(10,"X");
        mappings.put(40,"XL");
        mappings.put(50,"L");
        mappings.put(90,"XC");
        mappings.put(100,"C");
        mappings.put(400,"CD");
        mappings.put(500,"D");
        mappings.put(900,"CM");
        mappings.put(1000,"M");
    }
    String inttostring(int num){
        String result="";
        for(Map.Entry<Integer,String> entry:mappings.entrySet()){
            int times = num/entry.getKey();
            for(int k=0;k<times;k++){
                result= result+entry.getValue();
            }
            int remainder = num%entry.getKey();
            num = remainder;
            if(remainder == 0){
                break;
            }
        }
        return result;
    }
    private static final String M[] = {"", "M", "MM", "MMM"};
    private static final String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int n) {
        assert n >= 1 && n <= 3999;
        return M[n / 1000] + C[(n % 1000) / 100] + X[(n % 100) / 10] + I[n % 10];
    }
    Integer stringtoint(String a){
        for(Map.Entry<Integer,String> entry:mappings.entrySet()){
            maps.put(entry.getValue(),entry.getKey());
        }
        int intvalue= 0;
        int i=0;
        for(;i<a.length()-1;i++){
            int prevvlaue=  maps.get(String.valueOf(a.charAt(i)));
            int nextvalue = maps.get(String.valueOf(a.charAt(i+1)));
            // it has to be in decreasing order ..
            // if increasing order then there is problem ...
            if(nextvalue>prevvlaue){
                intvalue = intvalue+maps.get(String.valueOf(a.charAt(i+1)))-maps.get(String.valueOf(a.charAt(i)));
                i++;
            }
            else {
                intvalue = intvalue+ maps.get(String.valueOf(a.charAt(i)));
            }
        }
        if(i == a.length()-1){
            intvalue = intvalue+ maps.get(String.valueOf(a.charAt(i)));
        }
        return intvalue;
    }
//    String stringtoint(String s){
//        String result="";
//        for(Map.Entry<Integer,String> entry:mappings.entrySet()){
//            int times = i/entry.getKey();
//            for(int k=0;k<times;k++){
//                result= result+entry.getValue();
//            }
//            int remainder = i%entry.getKey();
//            if(remainder == 0){
//                break;
//            }
//        }
//        return result;
//    }
public static void main(String[] args) {
    IntToRoman roman = new IntToRoman();
    System.out.println(roman.inttostring(13));
    System.out.println(roman.stringtoint("IX"));
}


    private static final Map<Character, Integer> ROMAN_TO_INTEGER_MAP = new HashMap<>();
    static {
        ROMAN_TO_INTEGER_MAP.put('I', 1);
        ROMAN_TO_INTEGER_MAP.put('V', 5);
        ROMAN_TO_INTEGER_MAP.put('X', 10);
        ROMAN_TO_INTEGER_MAP.put('L', 50);
        ROMAN_TO_INTEGER_MAP.put('C', 100);
        ROMAN_TO_INTEGER_MAP.put('D', 500);
        ROMAN_TO_INTEGER_MAP.put('M', 1000);
    }

    public int romanToInt(String s) {
        int decimal = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && ROMAN_TO_INTEGER_MAP.get(s.charAt(i)) > ROMAN_TO_INTEGER_MAP.get(s.charAt(i - 1))) {
                decimal += ROMAN_TO_INTEGER_MAP.get(s.charAt(i)) - 2 * ROMAN_TO_INTEGER_MAP.get(s.charAt(i - 1));
            } else {
                decimal += ROMAN_TO_INTEGER_MAP.get(s.charAt(i));
            }
        }
        return decimal;
    }
}
