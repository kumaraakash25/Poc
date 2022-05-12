package systemdesign.ratelimiter;

public interface RateLimiter {
    boolean grantAccess();
}
