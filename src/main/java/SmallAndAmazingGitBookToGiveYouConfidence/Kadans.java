package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 21/9/17.
 */
public class Kadans {

    public static void main(String []args){
        Kadans kadans = new Kadans();
        int []temp = new int[]{-1,-3,-4,5,6};
        kadans.kadanemin(temp);
    }

    public static void kadanemin(int []temp){
            int currentMin =0;
            int globalMin = Integer.MAX_VALUE;
            int globalLeft = 0;
            int globalRight = 0;
            int localleft = 0;
            for(int i=0;i<temp.length;i++){
                currentMin = currentMin + temp[i];
                if(currentMin>0){
                    currentMin = 0;
                    localleft = i+1;
                }
                if(currentMin<globalMin){
                    globalMin = currentMin;
                    globalLeft = localleft;
                    globalRight = i;
                }
            }
        System.out.println("Globalmin"+globalMin);
        System.out.println("Globalleft"+globalLeft);
        System.out.println("GlobalRight"+globalRight);
    }
    public static void kadanonedim( int [] temp){
        int max = Integer.MIN_VALUE;
        int startcolumn = -1;
        int startcolumntemp = 0;
        int endcolumn = -1;
        int maxsofar=0;

        for( int i=0;i<temp.length;i++){
            maxsofar = maxsofar +temp[i];
            if(maxsofar<0){
                maxsofar=0;
                startcolumntemp = i+1;
            }
            if(maxsofar>max){
                max = maxsofar;
                endcolumn = i;
                startcolumn = startcolumntemp;
            }
        }
//        return new kadane(startcolumn,endcolumn,max);
    }
}


