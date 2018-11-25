package SystemDesignCodes;

import java.util.concurrent.TimeUnit;

/**
 * This is licensed under AGPL 3.0. http://www.gnu.org/licenses/agpl-3.0.html
 * @author Chandra Patni
 */
public class RateLimit {
    int rate;
    String unit;
    TimeUnit limit;
    private long lastCheck;
    private long lastFilled;
    private int allowance;
    boolean conformance;
    String slug;
    String name;

    public RateLimit() {
    }

    public RateLimit(int rate, TimeUnit limit) {
        this.rate = rate;
        this.limit = limit;
        lastFilled = lastCheck = System.currentTimeMillis();
        allowance = rate;
    }


    public int getRate() {
        return rate;
    }

    public TimeUnit getLimit() {
        return limit;
    }

    public long getLastCheck() {
        return lastCheck;
    }

    public int getAllowance() {
        return allowance;
    }

    public boolean record(int messages) {
        long now = System.currentTimeMillis();
        long elapsed = now - lastFilled;

        if(elapsed >= limit.toMillis(1) ) {
            allowance = rate;
            lastFilled = now;
        }
        allowance -= messages;
        lastCheck = now;
        return allowance >= 0;
    }

    @Override
    public String toString() {
        return "RateLimit{" +
                "rate=" + rate +
                ", limit=" + limit +
                '}';
    }
    

    public static void main(String[] args) throws Exception{
        RateLimit rateLimit = new RateLimit(10, TimeUnit.MINUTES);
        System.out.println("RateLimit.main " +rateLimit);
        for (int i = 0; i < 110; i++) {
            System.out.println(i + " " + rateLimit.record(10));
        }

        Thread.sleep(5000L);
        System.out.println("After sleep");
        for (int i = 0; i < 110; i++) {
            System.out.println(i +    " "+ rateLimit.record(1));
        }
    }
}