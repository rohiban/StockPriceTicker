package com.rohit.StockPriceTicker;

/**
 * Created by rbansal on 14/05/15.
 */
public interface Publisher {
    public void publish();
    public boolean registerMe(Subscriber s, Stock stock);
    public boolean unRegisterMe(Subscriber s);
}
