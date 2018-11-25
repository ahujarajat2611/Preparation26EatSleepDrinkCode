package AwangDevLintCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by hadoop on 13/10/17.
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
        // num  to int
        // we need to have lal mappsings
        // i to 1
        //1 to i
        // 4 to iv
        // 5 v
        // 9 ix
        // 10 x
        // 40 xl
        // 50 l
        // 90 xc
        // 100 c
        // 400 cd
        //
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
    Integer stringtointmine(String a){
        for(Map.Entry<Integer,String> entry:mappings.entrySet()){
            maps.put(entry.getValue(),entry.getKey());
        }
        int intvalue=0;
        int prev=maps.get(String.valueOf(a.charAt(0)));
        for(int i=1;i<a.length();i++){
            int current = maps.get(String.valueOf(a.charAt(i)));
            if(prev>current){
                intvalue = intvalue+prev;
                prev = current;
            }
            else {
                intvalue = intvalue + current-prev;
                prev = 0;
                if(i+1<a.length()){
                    prev = maps.get(String.valueOf(a.charAt(i+1)));
                }
                i++;
            }

        }
        intvalue = intvalue+ prev;
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
    System.out.println(roman.stringtoint("MCMD"));
    System.out.println(roman.stringtointmine("MCMD"));
}
}
