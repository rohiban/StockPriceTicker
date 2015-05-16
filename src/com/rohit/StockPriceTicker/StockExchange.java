package com.rohit.StockPriceTicker;

/**
 * Created by rbansal on 14/05/15.
 */

import java.util.List;
import java.util.ArrayList;

public class StockExchange {

    public static StockExchange MUMBAI = new StockExchange("Mumbai");

    private String name;
    private StockTicker ticker;
    private List<Stock> stockList;

    public StockExchange(String name) {
        this.name = name;

        // populate the master-list of stocks
        this.stockList = new ArrayList<Stock>();
        stockList.add(Stock.DABUR);
        stockList.add(Stock.HUL);
        stockList.add(Stock.REDBUS);
        stockList.add(Stock.ONGC);
    }

    public String getName() {
        return this.name;
    }

    public StockTicker startSession() {
        this.ticker = new StockTicker(this);
        return this.ticker;
    }

    public void endSession() {
        this.ticker = null;
    }

    public boolean isStockListed(Stock stock) {
        return this.stockList.contains(stock);
    }

    @Override
    public String toString() {
        String s = this.name + " Stock Exchange deals with following stocks :\n";

        for (Stock stock : this.stockList) {
            s += stock.toString() + "\n";
        }

        return s;
    }
}
