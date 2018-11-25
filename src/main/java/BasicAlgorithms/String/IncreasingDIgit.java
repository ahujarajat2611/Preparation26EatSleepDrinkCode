package BasicAlgorithms.String;

/**
 * Created by hadoop on 24/12/17.
 */
public class IncreasingDIgit {
    public int monotoneIncreasingDigits(int N) {

        char []array = String.valueOf(N).toCharArray();
        int index = -1;
        for(int i=array.length-2;i>=0;i--){
            if(array[i] >array[i+1]){
                index =i;
            }
        }
        while (index>=1 && array[index] == array[index-1]){
            index--;
        }
        if(index>=0) {
            array[index]--;
            for (int k = index + 1; k < array.length; k++) {
                array[k] = '9';
            }
        }
        return Integer.valueOf(String.valueOf(array));
    }

    public static void main(String[] args) {
        IncreasingDIgit increasingDIgit = new IncreasingDIgit();
        System.out.println(increasingDIgit.monotoneIncreasingDigits(1444267));
    }
}
/*
The idea is to go from the LSB to MSB and find the last digit, where an inversion happens.
There are 2 cases to consider:

case 1:
In 14267 , we see that inversion happens at 4. In this case, then answer is obtained by reducing 4 to 3, and changing all the following digits to 9.
=> 13999

case 2:
1444267, here eventhough the last inversion happens at the last 4 in 1444, if we reduce it to 3, then that itself breaks the rule. So once we find the last digit where inversion happens, if that digit is repeated, then we have to find the last position of that digit. After that it is same as case1, where we reduce it by 1 and set the remaining digits to 9.
=> 1399999

The steps are:

Convert n into num array in reverse order
Find the leftmost position that is inverted and if the inverted character repeats itself, find the leftmost repeated digit.
Fill the digits after inversion as 9
Reduce the digit that caused the inversion by -1
Reverse back the num array and convert to int
def monotoneIncreasingDigits(self, N):
        if N < 10: return N
        n, inv_index = N, -1
        num = [int(d) for d in str(n)[::-1]]

        for i in range(1, len(num)):
            if num[i] > num[i - 1] or (inv_index != -1 and num[inv_index] == num[i]):
                inv_index = i

        if inv_index == -1: return N

        for i in range(inv_index): num[i] = 9
        num[inv_index] -= 1

        return int(''.join([ str(i) for i in num[::-1]]))
 */