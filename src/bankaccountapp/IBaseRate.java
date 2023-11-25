package bankaccountapp;

public interface IBaseRate {
    // Method returns base rate
    default double getBaseRate () {
        return 2.5;
    }
}
