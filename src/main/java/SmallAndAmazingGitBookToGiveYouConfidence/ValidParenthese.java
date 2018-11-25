package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.*;

/**
 * Created by hadoop on 21/9/17.
 */
public class ValidParenthese {
    private static final Map<Character, Character> leftToRightBraces = new HashMap<>();
    private static final Set<Character> leftBracesSet = new HashSet<>();
    private static final Set<Character> rightBracesSet = new HashSet<>();

    static {
        leftToRightBraces.put('(',')');
        leftToRightBraces.put('{','}');
        leftToRightBraces.put('[',']');
        for (char c : new char[] {'(', '[', '{'}) {
            leftBracesSet.add(c);
        }
        for (char c : new char[] {')', ']', '}'}) {
            rightBracesSet.add(c);
        }
    }
    public boolean isValidPranet(String s){
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(leftParen(c)){
                stack.push(c);
            }
            else if(rightPran(c)){
                if(stack.isEmpty() || !isMatch(stack.pop(),c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(Character pop, char c) {
        if(leftToRightBraces.containsKey(pop)) {
            return leftToRightBraces.get(pop) == c;
        }
        return false;
    }

    private boolean rightPran(char c) {
        return leftBracesSet.contains(c);
    }

    private boolean leftParen(char c) {
        return rightBracesSet.contains(c);
    }

}
