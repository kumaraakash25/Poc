package systemdesign.ratelimiter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket implements RateLimiter {

    private int bucketCapacity;
    private int refreshRate;
    private AtomicInteger capacity;
    private AtomicLong lastUpdatedTimestamp;

    public TokenBucket(int bucketCapacity, int refreshRate) {
        this.bucketCapacity = bucketCapacity;
        this.refreshRate = refreshRate;
        capacity = new AtomicInteger(bucketCapacity);
        lastUpdatedTimestamp = new AtomicLong(System.currentTimeMillis());
    }

    @Override
    public boolean grantAccess() {
        // For every request first update the bucket and then provide the token value
        refreshBucket();
        if (capacity.get() > 0) {
            capacity.decrementAndGet();
            return true;
        }
        return false;
    }

    private void refreshBucket() {
        long currentTimestamp = System.currentTimeMillis();
        // Tokens are added after every refresh rate interval
        // Request came after let's say 2 sec and refresh rate is 10
        // every second the bucket will be added with 10 token, so 2 seconds after it will be 20 tokens
        int additionalTokens = (int) (((currentTimestamp - lastUpdatedTimestamp.get()) / 1000) * refreshRate);
        // Update the token capacity
        int currentCapacity = Math.min(bucketCapacity, additionalTokens);
        capacity.addAndGet(currentCapacity);
        lastUpdatedTimestamp.addAndGet(currentTimestamp);
    }
}
