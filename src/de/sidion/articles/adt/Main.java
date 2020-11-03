package de.sidion.articles.adt;


import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        OrderDetails marketOrder = new OrderDetails("EUNL.DE", 100, TradeType.SELL, OrderType.Market.INSTANCE);
        OrderDetails limitOrder = new OrderDetails("EUNL.DE", 100, TradeType.SELL, new OrderType.Limit(BigDecimal.valueOf(100.00)));

        final BigDecimal price = BigDecimal.valueOf(120.00);

        boolean becomesMarketTrade = marketOrder.orderType.visit(createSellVisior(price));
        boolean becomesLimitTrade = limitOrder.orderType.visit(createSellVisior(price));

        System.out.println(marketOrder + " becomes trade: " + becomesMarketTrade);
        System.out.println(limitOrder + " becomes trade: " + becomesLimitTrade);
    }

    private static OrderType.Visitor<Boolean> createSellVisior(BigDecimal price) {
        return new OrderType.Visitor<>() {

            public Boolean visit(OrderType.Market m) {
                return true;
            }

            public Boolean visit(OrderType.Limit limitOrder) {
                return price.compareTo(limitOrder.getLimitPrice()) <= 0;
            }
        };
    }

}
