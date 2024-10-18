package design.factory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    public Payment(Long id) {
        this.id = id;
    }

    Long id;
    BigDecimal amount;
    String currency;
    LocalDateTime trxTime;
    PaymentStatus status;
}
