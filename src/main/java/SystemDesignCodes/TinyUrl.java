package SystemDesignCodes;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 7/10/17.
 */
public class TinyUrl {
    public static int count = 0;
    private static Map<String,String> s2l = new HashMap<>();
    private static Map<String,String> l2s = new HashMap<>();
    private static final String prefix = "http://tiny.url/";

    public String longToShort(String url){
        if(l2s.containsKey(url)){
            return l2s.get(url);
        }

        String shortUrl = prefix + hashLong(url);
        return shortUrl;

    }

    private String hashLong(String url) {
        String ret = "";
        int hashcode = url.hashCode();
        while (hashcode>0){
            int indexvalue = hashcode%62;
            hashcode = hashcode/62;
            if(indexvalue>=0 && indexvalue<=9){
                ret = ""+indexvalue+ret;
            }
            else if(indexvalue>=10 && indexvalue<=35){
                ret = ""+(indexvalue-10 +'a') +ret;
            }
            else {
                ret = ""+(indexvalue-36 + 'A') +ret;
            }
        }
        return ret;
    }
}
