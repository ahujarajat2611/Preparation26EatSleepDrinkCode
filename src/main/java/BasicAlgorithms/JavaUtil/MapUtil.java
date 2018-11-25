package BasicAlgorithms.JavaUtil;

import java.util.*;
// this c, d has no relevance on funciton since funcitgon is static not bind to object memorty 1!!
public class MapUtil<C,D> {
    C a ;
    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list =
                new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put into list sort by value
        // created LInkedhashmap and return to the user !!!!! simple
        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
//    public static void function(Map<T,P> map){
//
//    }
    // FUNCITON GENERICS AND CLASS GENRICS
    // FUNCTION GENERICS STRAUIGHT FORWARD !!! AND CLASS GENERICS TOO
    // FUNCITON GENERICS APPLICABLW WUTH STATIC METHODS !!!

//    public  <T,R>  Map<C, D> sortByValue(Map<C, D> map) {
//
//
//    }

    // We can define generics at ffunciton level but then it should be static
    // else define generics at class level !!!
}
