package CodingNinjas;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by hadoop on 11/10/17.
 */
public class UniqueChars {
    public static void main(String[] args) {
        System.out.println(unique("ababacd"));
    }
    static String unique(String a){
        Set set = new LinkedHashSet();
        for(char var:a.toCharArray()){
            set.add(var);
        }
        Iterator it = set.iterator();
        String returned="";
        while (it.hasNext()){
            returned = returned+it.next();
        }
        return returned;
    }
}
