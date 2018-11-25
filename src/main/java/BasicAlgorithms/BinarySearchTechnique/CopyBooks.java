package BasicAlgorithms.BinarySearchTechnique;

/**
 * Created by hadoop on 6/1/18.
 */
/*
Given n books and the ith book has A[i] pages. You are given k people to copy the n books.
n books list in a row and each person can claim a continous range of the n books. For example one copier can copy the books from ith to jth continously, but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).
They publish copying books at the same time and they all cost 1 minute to copy 1 page of a book. What's the best strategy to assign books so that the slowest copier can finish at earliest time?
Have you met this question in a real interview?  Yes
Example
Given array A = [3,2,4], k = 2.
Return 5( First person spends 5 minutes to copy book 1 and book 2 and second person spends 4 minutes to copy book 3. )

 */
public class CopyBooks {
    /*
    dichotomous answer to the classic question. Note that the solution to the dichotomous
     answer requires that the answer be monotonous,

     here is if 5 minutes can not be completed,
     then 4 minutes certainly can not be completed.
      Understand the problem, ask is the slowest copier can be completed as soon as possible, meaning that all copy tasks done the shortest time spent. The shortest time required is the number of pages in the book with the largest number of pages. The maximum time required is the total number of pages in all the books (letting one copy all). With the scope of such an answer, we can use dichotomy. How to determine whether a certain time to meet the conditions? For example, A = [3,2,4], givenTime = 4, we know the naked eye to allow two people to do this thing can not be completed. In this case at least how many individuals do? Need 3 people. Therefore, we can judge every time we need to complete the task with the minimum number of people, if the number is greater than k, indicating that this time is too short, we must go to the right, if the number is less than or equal to k, Time may be longer, we will go to the left.
     */
    public class Solution {
        public int copyBooks(int[] pages, int k) {
            if (pages == null || pages.length == 0){
                return 0;
            }
            if (k == 0){
                return -1;
            }
            int total = 0;
            int max = 0;
            for (int i = 0; i < pages.length; i++){
                total += pages[i];
                max = Math.max(max, pages[i]);
            }
            int start = max;
            int end = total;
            while(start + 1 < end){
                int mid = start + (end - start) / 2;
                if (countCopiers(pages, mid) > k){
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            if (countCopiers(pages, start) <= k){
                return start;
            } else {
                return end;
            }
        }

        // one copier can claim a continuous range of books
        // 1 minute for 1 page
        public int countCopiers(int[] pages, int givenTime){
            int pagesForOneCopier = pages[0];
            int numCopier = 1;
            for(int i = 1; i < pages.length; i++){
                // if current copier can not handle i th book
                if (pagesForOneCopier + pages[i] > givenTime){
                    numCopier++;
                    pagesForOneCopier = 0;
                }
                // if current copier still can handle i th book
                pagesForOneCopier += pages[i];
            }
            return numCopier;
        }
        private boolean canSplit(int []nums,int maxvalue,int partitions){
            int count = 1;
            int sum = 0;
            for(int a:nums){
                sum = sum +a;
                if(sum>maxvalue){
                    sum = a;
                    count= count+1;
                }
                if(count>partitions){
                    return false;
                }
            }
            return true;
        }
    }
}
