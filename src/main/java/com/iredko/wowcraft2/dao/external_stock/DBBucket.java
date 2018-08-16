package com.iredko.wowcraft2.dao.external_stock;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "external_stock")
public class DBBucket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "item_id")
    private int itemId;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "item_count")
    private int itemCount;

    public DBBucket() {
    }

    public DBBucket(int itemId, BigDecimal price, int itemCount) {
        this.itemId = itemId;
        this.price = price;
        this.itemCount = itemCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
}
