package com.iredko.wowcraft2.components.stock;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Это условно "ящик" с предметами на складе.
 * Все предметы погруппированы в ящики, в 1 ящике хранятся предметы 1 типа купленные за 1 и ту же цену
 */
public class Bucket {

    private final int itemId;
    private final BigDecimal price;

    public Bucket(int itemId, BigDecimal price) {
        this.itemId = itemId;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bucket bucket = (Bucket) o;

        if (itemId != bucket.itemId) return false;
        return price != null ? price.equals(bucket.price) : bucket.price == null;
    }

    @Override
    public int hashCode() {
        int result = itemId;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
