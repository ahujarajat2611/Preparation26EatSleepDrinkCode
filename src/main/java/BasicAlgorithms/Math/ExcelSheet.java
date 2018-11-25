package BasicAlgorithms.Math;

/**
 * Created by hadoop on 25/1/18.
 */
/*
int len = s.length();
int res = 0;
for (int i = 0; i < len; i++)
    res = res * 26 + (s.charAt(i) - 'A') + 1;
return res;
 */
public class ExcelSheet {
    int excelSheetCOlumnNumber(String s){
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++)
            res = res * 26 + (s.charAt(i) - 'A') + 1;
        return res;
    }

    // to manage index // we need to keep reducing by 1 here for sure
    String excelSheetColumnTitle(int n){
        StringBuilder result = new StringBuilder();
        while(n > 0) {
            n--;  //
            //here is very important, or need to deal with the case of
            // less than 26, here to do test cases to consider three cases 1)
            // less than 1,2) [1,26], 3) greater than 26
            result.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }
}
