package BasicAlgorithms.JavaUtil;

import java.util.HashMap;

/**
 * Created by hadoop on 1/3/18.
 */
public class ReferenceTest<V> {
    HashMap<Integer,CacheHolder<V>> cache = new HashMap<>();
    void referenceTest(){
        CacheHolder<V> cacheHolder = new CacheHolder<>(3);
        cache.put(1,cacheHolder);
        passObject(cacheHolder);
        System.out.println(cache.get(1));
    }

    private void passObject(CacheHolder<V> cacheHolder) {
        cacheHolder.freq = 10;
    }

    public static void main(String[] args) {
        ReferenceTest<Integer> referenceTest = new ReferenceTest();
        referenceTest.referenceTest();

    }
    private class CacheHolder<V>{
        int freq;
        CacheHolder(int freq){
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "CacheHolder{" +
                    "freq=" + freq +
                    '}';
        }
    }
}
