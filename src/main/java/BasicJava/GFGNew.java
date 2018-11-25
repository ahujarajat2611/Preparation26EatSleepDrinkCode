package BasicJava;// Java program to sort a mixed string
 
import java.util.Arrays;
import java.util.Comparator;
 
public class GFGNew
{
    // Method to sort a mixed string
    public static String sortString(String inputString)
    {
        // convert input string to Character array
        Character tempArray[] = new Character[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
            tempArray[i] = inputString.charAt(i);
        }
         
         
        // Sort, ignoring case during sorting
        Arrays.sort(tempArray, new Comparator<Character>(){
 
            @Override
            public int compare(Character c1, Character c2)
            {
                // ignoring case
                return Character.compare(Character.toLowerCase(c1),
                                        Character.toLowerCase(c2));
            }
        });
         
        // using StringBuilder to convert Character array to String
        StringBuilder sb = new StringBuilder(tempArray.length);
        for (Character c : tempArray)
            sb.append(c.charValue());
 
        return sb.toString();
    }

    public static String sortStringMine(String input){
        Character []arra = new Character[input.length()];
        for(int i=0;i<input.length();i++){
            arra[i] = input.charAt(i);
        }

        Arrays.sort(arra,new Comparator<Character>(){
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1)-Character.toLowerCase(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Character c:arra){
            sb.append(c);
        }
        return sb.toString();
        //return String.valueOf(arra);
    }
    // Driver method
    public static void main(String[] args)
    {
        String inputString = "GeeksforGeeks";
        String outputString = sortString(inputString);
        String outmine = sortStringMine(inputString);
         
        System.out.println("Input String : " + inputString);
        System.out.println("Output String : " + outputString);
        System.out.println("mine out "+outmine);
    }
 
}