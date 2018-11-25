package SystemDesignCodes;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by hadoop on 7/10/17.
 */
public class MyConsistentHash {
    private int maxreplica = 3;
    private SortedMap<BigInteger,String> keynodemap = new TreeMap<>();
    public void put(String node) throws Exception{
        BigInteger key = hash(node);
        keynodemap.put(key,node);
        for(int i=0;i<maxreplica;i++){
            key = hash(node+":"+i);
            keynodemap.put(key,node);
        }
    }

    private BigInteger hash(String node) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytearray = messageDigest.digest(node.getBytes());
        BigInteger bigInteger = new BigInteger(bytearray);
        return bigInteger;
    }

    public String get(String entry) throws Exception{
        BigInteger key = hash(entry);
        if(!keynodemap.containsKey(key)){
            SortedMap<BigInteger,String> map = keynodemap.tailMap(key);
            if(map.isEmpty()){
                return keynodemap.get(keynodemap.firstKey());
            }
            return keynodemap.get(map.firstKey());
        }
        return keynodemap.get(key);
    }

    public static void main(String[] args) throws Exception {
        MyConsistentHash consistentHash = new MyConsistentHash();
        consistentHash.put("1.2.3.4");
        consistentHash.put("1.2.3.5");
        consistentHash.put("1.2.3.10");

        System.out.println(consistentHash.get("user1"));
        System.out.println(consistentHash.get("user3"));
        System.out.println(consistentHash.get("user2"));

    }
}
