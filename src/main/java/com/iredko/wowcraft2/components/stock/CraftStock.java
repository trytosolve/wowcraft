package com.iredko.wowcraft2.components.stock;

import java.math.BigDecimal;
import java.util.Set;

public class CraftStock implements Stock {

    private Set<ItemLeftover> itemLeftovers;

    public CraftStock(Set<ItemLeftover> itemLeftovers) {
        this.itemLeftovers = itemLeftovers;
    }

    @Override
    public void deposit(Bucket bucket, int itemCount) {
        BucketLeftover bucketLeftover = getBucketLeftover(bucket);
        if (itemCount <= 0) {
            throw new RuntimeException("incorrect value itemCount");
        }
        bucketLeftover.addItems(itemCount);
    }

    @Override
    public void withdraw(Bucket bucket, int itemCount) {
        BucketLeftover bucketLeftover = getBucketLeftover(bucket);
        if (itemCount <= 0) {
            throw new RuntimeException("incorrect value itemCount");
        }
        if (bucketLeftover.getItemCount() < itemCount) {
            throw new RuntimeException("not enough items");
        } else {
            bucketLeftover.withdraw(itemCount);
        }
    }

    @Override
    public ItemLeftover getLeftovers(int itemId) {
        for (ItemLeftover itemLeftover : itemLeftovers) {
            if (itemLeftover.getItemId() == itemId) {
                return itemLeftover;
            }
        }
        ItemLeftover empty = new ItemLeftover(itemId);
        itemLeftovers.add(empty);
        return empty;
    }

    @Override
    public int getLeftOverByPrice(int itemId, BigDecimal price) {
        BucketLeftover bucketLeftover = getBucketLeftover(new Bucket(itemId, price));
        if (bucketLeftover != null) {
            return bucketLeftover.getItemCount();
        } else {
            return 0;
        }
    }

    private BucketLeftover getBucketLeftover(Bucket bucket) {
        for (BucketLeftover bucketLeftover : getLeftovers(bucket.getItemId()).getBuckets()) {
            if (bucketLeftover.getBucket().equals(bucket)) {
                return bucketLeftover;
            }
        }
        BucketLeftover empty = new BucketLeftover(bucket);
        getLeftovers(bucket.getItemId()).getBuckets().add(empty);
        return empty;
    }


    public Set<ItemLeftover> getItemLeftovers() {
        return itemLeftovers;
    }
}