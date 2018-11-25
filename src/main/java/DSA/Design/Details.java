package DSA.Design;

import java.util.*;

public class Details {

   public static void main(String args[]) {

      /* This is how to declare TreeMap */
      Comparator<Integer> comparator = new Comparator<Integer>(){
         @Override
         public int compare(Integer a,Integer b){
            return b-a;
         }
      };
      TreeMap<Integer, String> tmap = 
             new TreeMap<Integer, String>(comparator);



      /*Adding elements to TreeMap*/
      tmap.put(1, "Data1");
      tmap.put(23, "Data2");
      tmap.put(70, "Data3");
      tmap.put(4, "Data4");
      tmap.put(2, "Data5");
      TreeMap<Integer, String> valueMap = sortByValue(tmap);
      System.out.println(valueMap);
      System.out.println(tmap.firstEntry());
      System.out.println(tmap.lastEntry());
      System.out.println(tmap.floorEntry(22));
      System.out.println(tmap.ceilingEntry(24));
      System.out.println(tmap.higherEntry(23));
      // head does not include that value // but tail includes that value
      System.out.println(tmap.headMap(24));
      System.out.println(tmap.tailMap(24));


      System.out.println(valueMap.firstEntry());
      System.out.println(valueMap.lastEntry());
      System.out.println(valueMap.floorEntry(23));
      System.out.println(valueMap.ceilingEntry(23));
      System.out.println(valueMap.higherEntry(23));
      // head does not include that value // but tail includes that value
   //   System.out.println(valueMap.headMap(24));
   //   System.out.println(valueMap.tailMap(24));


      /* Display content using Iterator*/
      Set set = tmap.entrySet();
      Iterator iterator = set.iterator();
      while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
         System.out.println(mentry.getValue());
      }

   }

   private static TreeMap<Integer,String> sortByValue(TreeMap<Integer, String> tmap) {
      Comparator<Integer> comparator = new Comparator<Integer>() {
         @Override
         public int compare(Integer o1, Integer o2) {
           // System.out.println(tmap.get(o1));
            //System.out.println(tmap.get(o2));
            return tmap.get(o1).compareTo(tmap.get(o2));
         }
         } ;
         TreeMap<Integer,String> sortByValueMap = new TreeMap<Integer,String>(comparator);
         sortByValueMap.putAll(tmap);
         System.out.println("sort "+sortByValueMap);
         return sortByValueMap;
   }
}