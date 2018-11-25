package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/*
Fraction to Recurring Decimal
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses.
For example,
Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
I really like this problem. It's not hard, but it is.
It is not hard in the sense that the algorithm is not hard: basic divide algorithm.
It is hard because
1. Dealing with the remainder part. In the case of denominator >> numerator, we may have lots of decimal numbers before we find the repeating part. One possible approach is to use a hash map. Since we need to add parentheses for the repeating part. We can store the position in the result string of the reminder. Thus when a repeating part shows, we can add parentheses at that position.
2. Overflow. In the case of denominator = Integer.MAX_VALUE or Integer.MIN_VALUE, we will face an overflow problem. To deal with that, we may use long in our method.

 */
public class FractiontoDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
  // return 0 condition
  if (denominator == 0)
    return null;
  else if (numerator == 0)
   return "0";
  StringBuilder rst = new StringBuilder();
  if (numerator < 0 && denominator > 0 || (denominator < 0 && numerator > 0))
   rst.append("-");
   
  long numer = Math.abs((long)numerator);
  long denom = Math.abs((long)denominator);
  rst.append (String.valueOf(numer / denom));
  long remainder = numer % denom;
  if (remainder == 0)
   return rst.toString();
  rst.append(".");
  HashMap<Long,Integer> hm = new HashMap<Long,Integer>();
  //ArrayList<long> list = new ArrayList<long>();
  while (remainder != 0)
  {
   if (hm.containsKey(remainder))
   {
    rst.insert(hm.get(remainder),"(");
    rst.append(")");
    break;
   }
     
   hm.put(remainder, rst.length());
   long decimal = remainder * 10 / denom;
   rst.append(decimal);
   remainder = (remainder * 10) % denom;
  }
  return rst.toString();
 }
}