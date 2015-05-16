package com.rohit.StockPriceTicker;

/**
 * Created by rbansal on 14/05/15.
 */
public class StockBroker implements Subscriber {
    private String name;
    private StockExchange belongsTo;

    public StockBroker(String name, StockExchange exchange) {
        this.name = name;
        this.belongsTo = exchange;
    }

    @Override
    public void notifyMe(Stock stock) {
        System.out.println(this.name + " " + stock.toString());
    }

    @Override
    public boolean equals(Object o) {
        StockBroker sb = (StockBroker)o;

        return sb.name.equals(this.name);
    }

    @Override
    public String toString() {
        return "Stock-broker " + this.name + " operates in " + this.belongsTo.getName() + " stock-exchange";
    }
}