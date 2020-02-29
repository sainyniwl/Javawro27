package pl.sda.rafal.zientara.tdd.expenses;

import java.time.LocalDate;
import java.util.Objects;

public class Cost {

    final String shopName;
    final LocalDate date;
    final double price;

    public Cost(String shopName, double price, LocalDate date) {
        this.shopName = shopName;
        this.date = date;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cost cost = (Cost) o;
        return Double.compare(cost.price, price) == 0 &&
                Objects.equals(shopName, cost.shopName) &&
                Objects.equals(date, cost.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopName, date, price);
    }

    @Override
    public String toString() {
        return "shop = '" + shopName + '\'' +
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}
