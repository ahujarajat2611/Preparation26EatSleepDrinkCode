package BasicAlgorithms.Design;
import java.time.LocalDateTime;
 
public final class CacheValueHolder<V> {
 
    private final V value;
    private LocalDateTime lastAccessTimestamp;
 
    public CacheValueHolder(V value) {
        this.value = value;
        this.lastAccessTimestamp = LocalDateTime.now();
    }
    
    public LocalDateTime getLastAccessTimestamp() {
        return lastAccessTimestamp;
    }
 
    public void setLastAccessTimestamp(LocalDateTime lastAccessTimestamp) {
        this.lastAccessTimestamp = lastAccessTimestamp;
    }
 
    public V getValue() {
        return this.value;
    }
 
    @Override
    public String toString() {
        return "CacheValueHolder [value=" + value + ", lastAccessTimestamp="
                + lastAccessTimestamp + "]";
    }
}
 