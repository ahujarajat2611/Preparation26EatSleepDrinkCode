package BasicAlgorithms.DivideAndConquer;

/**
 * Created by hadoop on 22/10/17.
 */
	//Given a string that contains only
// digits 0-9 and a target value,
// return all possibilities to add binary
// operators (not unary) +, -, or * between the digits so they evaluate to the target value.

import java.util.*;
public class DifferentStringsOutput {
    public List<String> addOperators(String num, int target) {
        List<String> path = new LinkedList<>();
        List<List<String>> result = new LinkedList<>();
        List<String> ans = new LinkedList<>();
        if (num.length() == 1) {
            if (Integer.parseInt(num) == target) {
                ans.add(num);
                return ans;
            } else {
                return ans;
            }
        }

        String previousChar = "";
        addOperatorsHelper(num, 0, path, result, target, 0, 0, 0, previousChar);
        for(List<String> list :result){
            String start="";
            for(String x:list){
                start = start+x;
            }
            ans.add(start);
        }
        return ans;
    }

    private void addOperatorsHelper(String num, int start, List<String> path, List<List<String>> result, long target, long calculatedTillNow, long calculatedTillPrevious, long previousNumber, String previousChar) {
       // System.out.println("publish "+publish);
        if (start == num.length()) {
          //  System.out.println("entry here "+calculatedTillNow);
            if (calculatedTillNow == target) {
            //    System.out.println("target"+target);
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int index = start; index < num.length(); index++) {

            String currentString = num.substring(start, index + 1);
            Long number = Long.parseLong(currentString);
            if(currentString.startsWith("0") && currentString.length()>1){
                continue;
            }
            if (start == 0) {
                path.add(currentString);
                addOperatorsHelper(num, index+1, path, result, target, number, 0, number, previousChar);
                path.remove(path.size() - 1);
            } else {
                path.add("+" + currentString);
                addOperatorsHelper(num, index + 1, path, result, target, calculatedTillNow+number, calculatedTillNow, number, "+");
                path.remove(path.size() - 1);
                path.add("-" + currentString);
                addOperatorsHelper(num, index + 1, path, result, target, calculatedTillNow-number, calculatedTillNow, number, "-");
                path.remove(path.size() - 1);

                path.add("*" + currentString);

                if (previousChar == "+") {
                    addOperatorsHelper(num, index + 1, path, result, target, calculatedTillPrevious +previousNumber*number, calculatedTillPrevious, previousNumber*number, "+");
                }
                else if (previousChar == "-") {
                    addOperatorsHelper(num, index + 1, path, result, target, calculatedTillPrevious -previousNumber*number, calculatedTillPrevious, previousNumber*number, "-");
                }
                else if (previousChar == "*") {
                    addOperatorsHelper(num, index + 1, path, result, target, calculatedTillPrevious +previousNumber*number, calculatedTillPrevious, previousNumber*number, "*");
                }
                else {
                    addOperatorsHelper(num, index + 1, path, result, target, calculatedTillPrevious +previousNumber*number, calculatedTillPrevious, previousNumber*number, "*");
                }
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        DifferentStringsOutput differentStringsOutput = new DifferentStringsOutput();
        System.out.println(differentStringsOutput.addOperators("105",5));
    }
}