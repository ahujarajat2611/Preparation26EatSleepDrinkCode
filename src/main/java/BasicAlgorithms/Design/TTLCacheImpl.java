package BasicAlgorithms.Design;
 
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
 

public final class TTLCacheImpl<K, V> implements TTLCache<K, V> {
 
    private final long timeToLiveInSeconds;
    private final Map<K, CacheValueHolder<V>> cacheMap;
 
    public TTLCacheImpl(long timeToLiveInSeconds) {
        this.timeToLiveInSeconds = timeToLiveInSeconds;
        this.cacheMap = new ConcurrentHashMap<>(100);
        initCache();
    }
 
    private void initCache() {
        // here i ask another thread to please keep cleaning up this class's map ...
        // i think thats the correct way to spon a thread and let that thread call the functions of this threadd whihc
        /// we want to run parallely // wattaa cool idea !!!
        Thread cleanUpThread = new Thread(new CleanupTask<K, V>(this));
        cleanUpThread.setDaemon(true);
        cleanUpThread.start();
    }
 
    /**
     * put an entry
     */
    @Override
    public void put(K key, V value) {
        cacheMap.put(key, new CacheValueHolder<V>(value));
    }
 
    /**
     * Access an entry
     */
    @Override
    public V get(K key) {
 
        CacheValueHolder<V> cacheValueHolder = cacheMap.get(key);
        if (cacheValueHolder != null) {
            cacheValueHolder.setLastAccessTimestamp(LocalDateTime.now());
            return cacheValueHolder.getValue();
        } else {
            return null;
        }
    }
 
    private void remove(K key) {
        cacheMap.remove(key);
    }
 
    /**
     * Remove the elapsed keys from the map
     */
    
    @Override
    public void cleanUp() {
 
        Set<K> keySet = cacheMap.keySet();
        LocalDateTime now = LocalDateTime.now();
 
        for (K key : keySet) {
            CacheValueHolder<V> cacheValueHolder = cacheMap.get(key);
 
            synchronized (cacheMap) {
                if (cacheValueHolder != null) {
                    LocalDateTime lastAccessTs = cacheValueHolder
                            .getLastAccessTimestamp();
                    long elapsedTime = ChronoUnit.SECONDS.between(lastAccessTs,
                            now);
 
                    if (elapsedTime > this.timeToLiveInSeconds) {
                        this.remove(key);
                        Thread.yield();
                    }
                }
            }
        }
    }
}
 