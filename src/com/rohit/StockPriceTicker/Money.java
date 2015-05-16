package com.rohit.StockPriceTicker;

/**
 * Created by rbansal on 14/05/15.
 */
public class Money {
    private String currency;
    private float value;

    public Money(String currency, float price) {
        this.currency = currency;
        this.value = price;
    }

    public Money subtract(Money toBeSubtracted) {
        if (this.currency.equals(toBeSubtracted.currency)) {
            return new Money(this.currency, this.value - toBeSubtracted.value);
        } else {
            // throw an exception
            return new Money(this.currency, 0);
        }
    }

    @Override
    public boolean equals(Object o) {
        Money m = (Money)o;
        if (m.currency.equals(this.currency)) {
            return ((this.value - m.value) < 0.01);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        // TO DO : format for only 2 decimal points
        return this.currency + " " + this.value;
    }
}
