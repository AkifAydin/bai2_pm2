package model;

import java.util.Objects;

public class PaymentModel {

    private Rate rate;
    private Amount amount;

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Rate getRate() {
        return rate;
    }

    public Amount getAmount() {
        return amount;
    }

    public PaymentModel(Rate rate, Amount amount) {
        this.rate = rate;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentModel that = (PaymentModel) o;
        return rate == that.rate &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, amount);
    }

    @Override
    public String toString() {
        return String.format("%s %s", rate,amount);
    }
}
