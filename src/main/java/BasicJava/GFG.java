package BasicJava;// Java program to sort a string alphabetically
 
import java.util.Arrays;
 
public class GFG 
{
    // Method to sort a string alphabetically
    public static String sortString(String inputString)
    {
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();
         
        // sort tempArray
        Arrays.sort(tempArray);
         
        // return new sorted string
        return new String(tempArray);
    }
     
    // Driver method
    public static void main(String[] args)
    {
        String inputString = "geeksforgeeks";
        String outputString = sortString(inputString);
         
        System.out.println("Input String : " + inputString);
        System.out.println("Output String : " + outputString);
    }
}