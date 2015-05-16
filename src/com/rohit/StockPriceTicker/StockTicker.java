package com.rohit.StockPriceTicker;

/**
 * Created by rbansal on 14/05/15.
 */

import java.util.*;

public class StockTicker implements Publisher {
    private StockExchange exchange;

    private HashMap<Stock, List<Subscriber>> watchList;

    private int refreshInterval; // in minutes

    public StockTicker(StockExchange exchange) {
        this.exchange = exchange;
        this.refreshInterval = 5;
        this.watchList = new HashMap<Stock, List<Subscriber>>();
    }

    @Override
    public boolean registerMe(Subscriber sub, Stock forStock) {
        if (sub == null || forStock == null) {
            return false;
        } else {
            // check if the stock is available for monitoring
            if (this.exchange.isStockListed(forStock)) {

                if (watchList.containsKey(forStock)) { // see if this stock is already monitored
                    List<Subscriber> subscriberList = watchList.get(forStock);

                    // add the new subscriber to the list
                    if (subscriberList == null) {
                        subscriberList = new ArrayList<Subscriber>();
                    }
                    subscriberList.add(sub);

                } else { // construct the list for this stock
                    List<Subscriber> subscriberList = new ArrayList<Subscriber>();
                    subscriberList.add(sub);
                    watchList.put(forStock, subscriberList);
                }
                return true;
            } else return false;
        }
    }

    @Override
    public boolean unRegisterMe(Subscriber sub) {
        Collection<List<Subscriber>> collection = this.watchList.values();

        for (List<Subscriber> subList : collection) {
            if (subList.contains(sub)) {
                subList.remove(sub);
            }
        }
        return true;
    }

    public void setRefreshTime(int duration) {
        // min=1, max=30 minutes
        if (duration >= 1 && duration <= 30) {
            this.refreshInterval = duration;
        } else {
            // throw exception
        }
    }

    @Override
    public void publish() {
        // for now, call each subscriber for each stock
        Set<Stock> stockSet = this.watchList.keySet();
        for (Stock stock : stockSet) {
            List<Subscriber> subscriberList = this.watchList.get(stock);
            // notify each subscriber
            for (Subscriber sub : subscriberList) {
                sub.notifyMe(stock);
            }
        }
    }

    @Override
    public String toString() {
        return this.exchange.toString();
    }
}