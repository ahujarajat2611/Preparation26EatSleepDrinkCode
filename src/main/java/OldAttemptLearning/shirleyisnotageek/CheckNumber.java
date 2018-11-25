package OldAttemptLearning.shirleyisnotageek;

public class CheckNumber {
 public boolean isNumber(String s)
 {
  if (s == null || s.length() == 0)
   return false;
  int dot = 0;
   
  for (int i = 0; i < s.length(); i++)
  {


   if (s.charAt(i) == '-')
   {
    if (i != 0)
    //System.out.println("-");
     return false;
   }


   else if (s.charAt(i) == '.')
   {
    if (dot > 0 || i == 0 || i == s.length() - 1)
    {
     //System.out.println("*");
     return false;
    }
    dot++;
   }

   else if(!Character.isDigit(s.charAt(i)))
   {
    //System.out.println(i + "isDigit");
    return false;
   }
  }
  return true;
 }
}