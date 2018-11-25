package BasicAlgorithms.Sort.tournament;

import java.util.Scanner;

public class Tournament {
 static int min;

 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int arr[] = new int[2 * n + 1];
  for (int i = n; i <= 2 * n - 1; i++) {
   arr[i] = sc.nextInt();
  }
  min = arr[n];
  for (int i = 2 * n - 2; i >= 1; i -= 2)
   arr[i / 2] = max(arr[i], arr[i + 1]);

  for (int a : arr)
   System.out.print(a + " ");
  // System.out.println("\nmax:" + arr[1]);
  // System.out.println("\nmin:" + min);
  System.out.println("\n Sorted array");
  for (int i = 1; i <= n; i++) {
   {
    System.out.println(arr[1]);
    getNext(arr, n, min - 1);
   }
  }

 }

 static void getNext(int arr[], int n, int min) {
  // finding min. in arr
  int i = 2;
  for (i = 2; i <= 2 * n - 1;) {
   if (arr[i] < arr[i + 1]) {
    arr[i + 1] = min;
    i = (2*i + 2);

   } else {
    arr[i] = min;
    i = i * 2;
   }

  }

  for (i = i / 2; i >= 1; i = i / 2) {
   if (i % 2 == 0)
    arr[i / 2] = max(arr[i], arr[i + 1]);
   else
    arr[i / 2] = max(arr[i], arr[i - 1]);
  }

 }

 static int max(int a, int b) {
  if (a > b) {
   if (min > b)
    min = b;
   return a;
  } else {
   if (min > a)
    min = a;
   return b;
  }

 }

}