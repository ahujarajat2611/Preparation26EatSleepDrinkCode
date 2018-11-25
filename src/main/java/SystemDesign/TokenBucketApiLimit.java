package SystemDesign;

/**
 * Created by hadoop on 8/10/17.
 */
public class TokenBucketApiLimit {
    long capacity;
    double refillTokensPerMilliSeconds;
    long availableTokens;
    long lastRefillTimeStamp;
    // max capacity
    TokenBucketApiLimit(long capacity,long refillTokens,long refillPeriodTimeInMills){
        this.capacity = capacity;
        this.availableTokens =capacity;
        lastRefillTimeStamp = System.currentTimeMillis();
        this.refillTokensPerMilliSeconds = (double)refillTokens/(double)refillPeriodTimeInMills;
    }
    synchronized public  boolean tryConsume(int numberOfTokens){
        refill();
        if(availableTokens>=numberOfTokens){
            availableTokens-=numberOfTokens;
            return true;
        }
        else {
            return false;
        }
    }

    private void refill() {
        long currentTimeStamp = System.currentTimeMillis();
        if(currentTimeStamp > lastRefillTimeStamp){
            long missedTimeStamp = currentTimeStamp-lastRefillTimeStamp;
            long totaltokenstobeadded = (long)(missedTimeStamp*this.refillTokensPerMilliSeconds);
            availableTokens = Math.min(capacity,availableTokens+totaltokenstobeadded);
            this.lastRefillTimeStamp = currentTimeStamp;
        }
    }
}
