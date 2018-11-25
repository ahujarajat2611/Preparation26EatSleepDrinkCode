package BasicAlgorithms.Array;// Java Effective  program to shuffle an array of size 2n
 
import java.util.Arrays;
 
public class GFG 
{
    // method to shuffle an array of size 2n
    static void shufleArray(int a[], int f, int l)
    {
        // If only 2 element, return
        if (l - f == 1)
            return;
      
        // finding mid to divide the array
        int mid = (f + l) / 2;
      
        // using temp for swapping first half of second array
        int temp = mid + 1;
      
        // mmid is use for swapping second half for first array
        int mmid = (f + mid) / 2;
      
        // Swapping the element
        for (int i = mmid + 1; i <= mid; i++)
        {
            // swap a[i], a[temp++]
            int temp1 = a[i];
            a[i] = a[temp];
            a[temp++] = temp1;
        }
      
        // Recursively doing for first half and second half
        shufleArray(a, f, mid);
        shufleArray(a, mid + 1, l);
    }
     
    // Driver Method
    public static void main(String[] args)
    {
        int a[] = { 1, 3, 5, 7, 2, 4, 6, 8 };
      
        shufleArray(a, 0, a.length - 1);
         
        System.out.println(Arrays.toString(a));
    }
}