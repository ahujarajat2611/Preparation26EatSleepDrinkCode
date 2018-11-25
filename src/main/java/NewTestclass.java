import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class NewTestClass {
    static HashMap<String,Integer[]> hashMap = new HashMap<>();

    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        String []sortedarray = new String[N];
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0;i<N;i++){
            String str = s.next();
            sortedarray[i] = str;
            Integer count []= new Integer[26];
            count = getCountArray(count,str.toCharArray());
            hashMap.put(str,count);
        }
        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(comparestring(sortedarray[i],sortedarray[j])){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
    private static boolean comparestring(String one, String two) {
        Integer count1[] = hashMap.get(one);
        Integer count2[] = hashMap.get(two);



        HashSet<Character> hashSet = new HashSet<>();
        int i=0;
        while (i<one.length() ){
            hashSet.add(one.charAt(i));
            if(hashSet.size()>9){
                break;
            }
            i++;
        }
        int j=0;
        while (j<two.length()){
            if(hashSet.contains(two.charAt(j))){
                return false;
            }
            j++;
        }

        return true;
    }
    private static int gethashcode(int[] count) {
        int hash = 0;
        int a = 31;
        for(int ch:count){
            hash = hash*a + ch;
        }
        return hash;
    }

    private static Integer[] getCountArray(Integer[] count, char[] chars) {
        for(int i=0;i<chars.length;i++){
            count[chars[i]-'a']++;
        }
        return count;
    }
}