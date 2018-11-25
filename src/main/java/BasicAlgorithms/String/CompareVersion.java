//package BasicAlgorithms.String;
//
///**
// * Created by hadoop on 13/10/17.
// */
//public class CompareVersion {
//    public int compareVersion(String version1, String version2) {
//        String a[] = version1.split("\\.");
//        String b[] = version2.split("\\.");
//        System.out.println(a.length);
//        System.out.println(b.length);
//        if(a.length ==1 && b.length ==1){
//            int x  =Integer.parseInt(version1);
//            int  y = Integer.parseInt(version2);
//            System.out.println("x"+x);
//            System.out.println("y"+y);
//            if(x<y){
//                return -1;
//            }
//            else if(x>y) {
//                return 1;
//            }
//            else {
//                return 0;
//            }
//        }
//        if(a.length ==1){
//            int x = Integer.parseInt(version1);
//            int y = Integer.parseInt(b[0]);
//            if(x<y){
//                return -1;
//            }
//            else if(x>y) {
//                return 1;
//            }
//            else {
//                return -1;
//            }
//        }
//        if(b.length ==1){
//            int x = Integer.parseInt(a[0]);
//            int y = Integer.parseInt(version2);
//            if(x<y){
//                return -1;
//            }
//            else if(x>y) {
//                return 1;
//            }
//            else {
//                return 1;
//            }
//        }
//        int i=0;
//        int j=0;
//        while (i<a.length &&j<b.length){
//            int first = Integer.parseInt(a[i]);
//            int second = Integer.parseInt(b[j]);
//            if(first<second){
//                return -1;
//            }
//            if(first>second){
//                return 1;
//            }
//            i++;
//            j++;
//        }
//        if(i == a.length && b.length ==j){
//            return 0;
//        }
//        if(i == a.length){
//            return -1;
//        }
//        else {
//            return 1;
//        }
//    }
//
//    public static void main(String[] args) {
//        CompareVersion compareVersion = new CompareVersion();
//        System.out.println(compareVersion.compareVersion("01","1"));
//    }
//}