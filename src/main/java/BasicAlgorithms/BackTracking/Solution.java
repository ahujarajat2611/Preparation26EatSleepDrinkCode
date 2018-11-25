package BasicAlgorithms.BackTracking;
import java.util.*;

 class Sol {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<String>();
        if (digits == null || digits.length() == 0){
            return results;
        }

        StringBuffer result = new StringBuffer();
        backtrack(digits, 0, results, result);
        return results;
    }
    
    public void backtrack(String digits, int index, List<String> results, StringBuffer result){
        if (index == digits.length()){
            results.add(result.toString());
            return;
        }
        List<String> currentLetters = mapToLetters(digits.charAt(index));
        for (String letter: currentLetters){
            result.append(letter);
            backtrack(digits, index + 1, results, result);
            result.deleteCharAt(result.length() - 1);
        }
    }
    
    public List<String> mapToLetters(char digit){
        List<String> letters = new ArrayList<String>();
        switch(digit){
            case '1':
                break;
            case '2':
                letters.add("a");
                letters.add("b");
                letters.add("c");
                break;
            case '3':
                letters.add("d");
                letters.add("e");
                letters.add("f");
                break;
            case '4':
                letters.add("g");
                letters.add("h");
                letters.add("i");
                break;
            case '5':
                letters.add("j");
                letters.add("k");
                letters.add("l");
                break;
            case '6':
                letters.add("m");
                letters.add("n");
                letters.add("o");
                break;
            case '7':
                letters.add("p");
                letters.add("q");
                letters.add("r");
                letters.add("s");
                break;
            case '8':
                letters.add("t");
                letters.add("u");
                letters.add("v");
                break;
            case '9':
                letters.add("w");
                letters.add("x");
                letters.add("y");
                letters.add("z");
                break;
            case '0':
                break;
            default:
                break;
        }
        return letters;
    }
}