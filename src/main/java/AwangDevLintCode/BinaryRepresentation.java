package AwangDevLintCode;

import java.util.HashSet;

/**
 * Created by hadoop on 3/2/18.
 */
public class BinaryRepresentation {
    public String binaryRepresentation(String n) {
        if (n.length() == 0 || n.equals("0")) {
            return "0";
        }

        // string.indexOf(".");
        // n.indexof("substring ( it can have one char as well ");
        if (n.indexOf(".") == -1) {
            return parseInteger(n);
        }
        String[] strs = n.split("\\.");
        // . ddplut \
        String decimal = parseDecimal(strs[1]);
        if (decimal.equals("ERROR")) {
            return decimal;
        }
        if (decimal.length() == 0 || decimal.equals("0")) {
            return parseInteger(strs[0]);
        } else {
            return parseInteger(strs[0]) + "." + decimal;
        }

    }

    // binart of integer 23.42 // get 23 get binary representation
    // then fetch 42 get decimal representation of that
    // hashset keep it ready to stop recursion
    public String parseInteger(String n) {
        if (n.length() == 0 || n.equals("0")) {
            return n;
        }
        int num = Integer.parseInt(n);
        String rst = "";
        while (num != 0) {
            rst = num % 2 + rst;//mod(2) -> binary representation
            num = num / 2;//小时候转换二进制也是这样。
        }
        return rst;
    }

    public String parseDecimal(String n) {
        if (n.length() == 0 || n.equals("0")) {
            return "";
        }

        // get the actual double number
        // multiply by 2 and see if its crosing 1
        // if yes then reduce by 1
        // else keep multiplying by 2 also
        // keep adding
        double num = Double.parseDouble("0." + n);
        HashSet<Double> set = new HashSet<Double>();
        String res = "";
        while (num>0){
            //if hashset contains alreay processed number means its a problem
            if(res.length()>32 || set.contains(num)){
                return "ERROR";
            }
            set.add(num);
            if(num*2>=1){
                res = res +"1";
                num = 2*num-1;
            }
            else {
                res = res + "0";
                num = 2*num;
            }
            // if number reaches to 0 kindly break it
            // if iterations more than 32 kinndly break it
            // if recursive // using hashset kindly break it and not possible to represent this string into decimal

        }
        return res;
    }
}