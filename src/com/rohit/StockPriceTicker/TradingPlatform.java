package com.rohit.StockPriceTicker;

/**
 * Created by rbansal on 16/05/15.
 */
public class TradingPlatform {
    public static void main (String[] args) {
        // start a session in the stock exchange
        StockTicker ticker = StockExchange.MUMBAI.startSession();

        // create a stock broker
        StockBroker sherKhaan = new StockBroker("Sher Khaan", StockExchange.MUMBAI);

        // register to receive updates
        ticker.registerMe(sherKhaan, Stock.HUL);
        ticker.registerMe(sherKhaan, Stock.DABUR);

        // create another broker
        StockBroker wizKid = new StockBroker("Rohit Bansal", StockExchange.MUMBAI);

        // register to receive updates
        ticker.registerMe(wizKid, Stock.REDBUS);
        ticker.registerMe(wizKid, Stock.ONGC);
        ticker.registerMe(wizKid, Stock.DABUR);

        // simulate the update event
        ticker.publish();

//        ticker.unRegisterMe(wizKid);
//        System.out.println("=============");
//        ticker.publish();

        // end the session
        StockExchange.MUMBAI.endSession();

        //System.out.println(StockExchange.MUMBAI.toString());
    }
}
