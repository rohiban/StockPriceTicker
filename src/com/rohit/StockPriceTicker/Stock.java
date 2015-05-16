package com.rohit.StockPriceTicker;

/**
 * Created by rbansal on 14/05/15.
 */
public class Stock {
    public static Stock HUL = new Stock("HUL", new Money("Rs", 50));
    public static Stock ONGC = new Stock("ONG", new Money("Rs", 200));
    public static Stock DABUR = new Stock("DBR", new Money("Rs", 110));
    public static Stock REDBUS = new Stock("RBS", new Money("Rs", 30));

    private String symbol;
    private Money price;

    public Stock(String sym, Money p) {
        this.symbol = sym;
        this.price = p;
    }

    public void updatePrice(Money newPrice) {
        this.price = newPrice;
    }

    @Override
    public boolean equals(Object o) {
        Stock s = (Stock)o;

        return this.symbol.equals(s.symbol) && this.price.equals(s.price);
    }

    @Override
    public String toString() {
        return "[" + this.symbol + " : " + this.price.toString() + "]";
    }
}
