package BasicAlgorithms.Sort;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created by hadoop on 11/11/17.
 */

// points to rememver
    //

    /*
    1) Index starts from 1
    2) Buildin first copy last layer same as it is array
   3)  int []tour = new int[2*nums.length]
        int []
   for(int i=0;i<nums.length;i++){
        tour[i+nums.length] = array[i];
   }
   for(int i = 2*nums.length-2;i>1;i--){
        tour[i/2] = Math.max(tour[i].tour[i+1);
    }

    int getnext(1,int []tour{
        int index = 1;
        int maxvalue = tour[index];
           while(index <tour.lenght){
                int left = 2* i;
                int right = 2 * i+1;
                if(rigth >tour.length-1){
                       break;

                if(tour[left] == maxvalue ){
                        nexmaxvalue = Math.max(nextmaxavalue,tour[right]);
                        tour[left] = Integer.MINVALUE;
                        index = left;
                }

                if(tour[right] == maxvalue ){
                        nexmaxvalue = Math.max(nextmaxavalue,tour[left]);
                        tour[right] = Integer.MINVALUE;
                        index = right;
                }

    }

    n n-1
     */
public class MyTournamentTree {
    public static void main(String[] args) {
        MyTournamentTree myTournamentTree = new MyTournamentTree();
        int []array = {8 ,7 ,5 ,15 ,1, 6, 10 ,9};
        myTournamentTree.buildTree(array);
        System.exit(1);
         int []tour = myTournamentTree.build(array);
        ConsoleWriter.printArray(tour);
        System.out.println(tour[1]);
       // System.out.println(myTournamentTree.nextMax(tour));
        int nextBestValue = myTournamentTree.update(tour,1);
        System.out.println(nextBestValue);
        for(int i=2*array.length-2;i>1;i= i-1){
            tour[i/2] = Math.max(tour[i],tour[i+1]);
        }
     //   tour[1] = nextBestValue;
        int nextBestValueAgain = myTournamentTree.update(tour,1);
        System.out.println(nextBestValueAgain);
       // tour[1] = nextBestValueAgain;
        for(int i=2*array.length-2;i>1;i= i-1){
            tour[i/2] = Math.max(tour[i],tour[i+1]);
        }
        int nextBestValueAgainAgain = myTournamentTree.update(tour,1);
        System.out.println(nextBestValueAgainAgain);
       // tour[1] = nextBestValueAgainAgain;
        for(int i=2*array.length-2;i>1;i= i-1){
            tour[i/2] = Math.max(tour[i],tour[i+1]);
        }
        int nextBestValueAgainAgainAgain = myTournamentTree.update(tour,1);
        System.out.println(nextBestValueAgainAgainAgain);



//        System.out.println("enter"+array.length);
//        System.out.println(tour[1]);

//        for(int i=1;i<array.length;i++){
//            System.out.println("enter");
//            int nextBestValue = myTournamentTree.update(tour,1);
//            System.out.println(nextBestValue);
//            tour[1] = nextBestValue;
//            //System.out.println(tour[1]);
//        }
        //int val = myTournamentTree.nextMax(tour);
       // tour[1] = val;
       // System.out.println(val);
        //myTournamentTree.update(tour,1);
        //System.out.println(myTournamentTree.nextMax(tour));
    }
    // we build tounrmane tree from 1 index based so that we can have parent i/2 left 2*i, right r*i+1
    // first fill last level ....
    // for(iint i=0;i<ums.length;i++){

    //  array[i+array.length] =  array[i];
    // for
    //  array[i/2] = array[i],[i+1]
    int [] build(int array[]){
        int []tournament = new int[2*array.length];
        for(int i=0;i<array.length;i++){
            tournament[i+array.length] = array[i];
        }
        for(int i=2*array.length-2;i>1;i= i-1){
            tournament[i/2] = Math.max(tournament[i],tournament[i+1]);
        }
        for(int i=0;i<2*array.length;i++){
            //System.out.println(tournament[i]);
        }
        return tournament;
    }
    int update(int []tour,int index){
        int nextBestValue = Integer.MIN_VALUE ;
        int i= index;
        int val = tour[i];
        tour[i] = Integer.MIN_VALUE;
        while (i<=tour.length-1){
            int leftindex = 2*i;
            int rightindex = 2*i+1;
            if(rightindex>=tour.length){
                break;
            }
            if(leftindex <=tour.length-1 && tour[leftindex] == val ){
                i = leftindex;
                tour[leftindex] = Integer.MIN_VALUE;
                nextBestValue = Math.max(nextBestValue,tour[rightindex]);
            }
            if(rightindex<=tour.length-1 && tour[rightindex] == val){
                i = rightindex;
                tour[rightindex] = Integer.MIN_VALUE;
                nextBestValue = Math.max(nextBestValue,tour[leftindex]);
            }

//            if(leftindex>=tour.length || rightindex>=tour.length){
//                break;
//            }
        }
        return nextBestValue;
    }
//    int nextMax(int []tournament){
//        int index = 1;
//        int next=Integer.MIN_VALUE;
//        int counter = 0;
//        //System.out.println("in tree");
//        while (index<=tournament.length-1){
//           // System.out.println(index);
//            int leftindex = 2*index;
//            int rightindex = 2*index+1;
//            if(leftindex<= tournament.length-1){
//                next = Math.max(next,tournament[leftindex]);
//                index = leftindex;
//            }
//            if(rightindex<=tournament.length-1){
//                if(next<tournament[rightindex]){
//                    index = rightindex;
//                    next = tournament[rightindex];
//                }
//            }
//            if(leftindex >tournament.length-1){
//                break;
//            }
//            counter++;
//            if(counter>10){
//                break;
//            }
//        }
//        return next;
//    }


    void populate(int []tour){
        for(int i=tour.length-2;i>1;i--){
            tour[i/2] = Math.max(tour[i+1],tour[i]);
        }
    }

    void buildTree(int []array){
        int []tour = new int[array.length*2];
        for(int i=0;i<array.length;i++){
            tour[i+array.length] = array[i];
        }
        populate(tour);
        System.out.println("Max vale" +tour[1]);
        System.out.println("===========");
        for(int i =0;i<array.length-1;i++){
//            int maxValue = tour[1];
//            System.out.println("maxvalue"+maxValue);
            int nextMaxValue = update(tour,1);
            System.out.println("Next Max Value"+nextMaxValue);
            System.out.println("===========");
            populate(tour);
        }
    }
}
