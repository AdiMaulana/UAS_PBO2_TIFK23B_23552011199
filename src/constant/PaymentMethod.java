package constant;

public enum PaymentMethod {
    CASH,
    CREDITCARD,
    ONLINE;
    
    public static final String getCashDescription() {
        return "CASH";
    }
}