package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 21/9/17.
 */
public class KsumDP {
    int ksumtotal(int []num,int k ,int target){
        if(k<1 || k >num.length){
            return 0;
        }
        int count [][][] = new int[k+1][num.length][target+1];
        int newarray [][][] = new int[k+1][num.length][target+1];


        for(int i=0;i<num.length;i++){
            for(int j=0;j<=i;j++){
                if(num[j]<=target){
                    count[1][i][num[j]]++;
                }
            }
        }
        for (int i=0;i<num.length;i++){
            for(int j=0;j<=target;j++){
                System.out.print(count[1][i][j]);
            }
            System.out.println();
        }
        System.out.println("END");

        for (int i = 1; i <= num.length; i++) {
            if (num[i - 1] <= target) {
                for (int j = i-1; j <= num.length-1; j++) {
                    newarray[1][j][num[i - 1]]++;
                }
            }
        }
        for (int i=0;i<num.length;i++){
            for(int j=0;j<=target;j++){
                System.out.print(newarray[1][i][j]);
            }
            System.out.println();
        }

        for(int i=2;i<=k;i++){
            for(int j=i-1;j<num.length;j++){
                for(int l=1;l<=target;l++){
                    count[i][j][l] +=count[i][j-1][l];
                    if(num[j]<=l){
                        count[i][j][l] +=count[i-1][j-1][l-num[j]];

                    }
                }
            }
        }
        return count[k][num.length-1][target];
    }

    public static void main(String[] args) {
        KsumDP ksumDP = new KsumDP();
        int []num = {1,2,3,4};
        int target = 5;
        int k =2;
        System.out.println(ksumDP.ksumtotal(num,2,5));
    }
}
