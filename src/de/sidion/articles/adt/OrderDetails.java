package de.sidion.articles.adt;

public class OrderDetails {

    final String symbol;
    final int shares;
    final TradeType tradeType;
    final OrderType orderType;

    public OrderDetails(String symbol, int shares, TradeType tradeType, OrderType orderType) {
        this.symbol = symbol;
        this.shares = shares;
        this.tradeType = tradeType;
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "symbol='" + symbol + '\'' +
                ", shares=" + shares +
                ", tradeType=" + tradeType +
                ", orderType=" + orderType +
                '}';
    }
}

