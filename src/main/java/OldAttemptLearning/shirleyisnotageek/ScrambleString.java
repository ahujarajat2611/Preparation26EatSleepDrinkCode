package OldAttemptLearning.shirleyisnotageek;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if ((s1 == null && s2 != null) || (s1 != null && s2 == null))
            return false;
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        int length = s1.length();
        int chars1 = 0;
        int chars2 = 0;
         
        // check if two strings are consisted by same characters
        for (int i = 0; i < length; i++)
        {
            chars1 += Character.getNumericValue(s1.charAt(i));
            chars2 += Character.getNumericValue(s2.charAt(i));
        }
        if (chars1 != chars2)
            return false;
             
        if (s1.length() == 1)
            return true;
        //the string must be swapped at certain position assume s2 is a scramble string
        //iterate through all positions and recursively check 
        for (int i = 1; i < length; i++)
        {
            if (isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i)))
                return true;
            // if the string is reversed, the reversed one is also a scramble string
            if (isScramble(s1.substring(0,i), s2.substring(length - i)) && isScramble(s1.substring(i), s2.substring(0, length - i)))
                return true;
        }
        return false;
    }
}