package com.iredko.wowcraft2.dao.external_stock;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "external_stock")
public class DBBucket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "item_count")
    private Integer itemCount;

    public DBBucket() {
    }

    public DBBucket(Integer id, Integer itemId, BigDecimal price, Integer itemCount) {
        this.id = id;
        this.itemId = itemId;
        this.price = price;
        this.itemCount = itemCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }
}
