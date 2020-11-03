package de.sidion.articles.adt;

import java.math.BigDecimal;

sealed interface OrderType permits OrderType.Market, OrderType.Limit {

    final class Market implements OrderType {
        private Market() {
        }

        public static final Market INSTANCE = new Market();

        public <T> T visit(Visitor<T> visitor) {
            return visitor.visit(this);
        }

        public String toString() {
            return "OrderType.Market()";
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof Market)) return false;
            final Market other = (Market) o;
            if (!other.canEqual((Object) this)) return false;
            return true;
        }

        protected boolean canEqual(final Object other) {
            return other instanceof Market;
        }

        public int hashCode() {
            return 1;
        }
    }

    final class Limit implements OrderType {

        private final BigDecimal limitPrice;

        public Limit(BigDecimal limitPrice) {
            this.limitPrice = limitPrice;
        }

        public <T> T visit(Visitor<T> visitor) {
            return visitor.visit(this);
        }

        public BigDecimal getLimitPrice() {
            return this.limitPrice;
        }

        public String toString() {
            return "OrderType.Limit(limitPrice=" + this.getLimitPrice() + ")";
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof Limit)) return false;
            final Limit other = (Limit) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$limitPrice = this.getLimitPrice();
            final Object other$limitPrice = other.getLimitPrice();
            if (this$limitPrice == null ? other$limitPrice != null : !this$limitPrice.equals(other$limitPrice))
                return false;
            return true;
        }

        protected boolean canEqual(final Object other) {
            return other instanceof Limit;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $limitPrice = this.getLimitPrice();
            result = result * PRIME + ($limitPrice == null ? 43 : $limitPrice.hashCode());
            return result;
        }
    }

    interface Visitor<T> {
        T visit(Market m);

        T visit(Limit l);
    }

    <T> T visit(Visitor<T> visitor);
}
