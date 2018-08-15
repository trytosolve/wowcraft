package com.iredko.wowcraft2.components.stock;

import java.math.BigDecimal;
import java.util.Set;

public class CraftStock implements Stock {

    private Set<ItemLeftover> itemLeftovers;

    @Override
    public void deposit(Bucket bucket, int itemCount) {
        ItemLeftover itemLeftover = getLeftovers(bucket.getItemId());
        BucketLeftover bucketLeftover = getBucketLeftover(bucket);
        if (bucketLeftover == null) {
            bucketLeftover = new BucketLeftover(bucket, itemCount);
            if (itemLeftover == null) {
                itemLeftover = new ItemLeftover(bucket.getItemId());
                itemLeftovers.add(itemLeftover);
            }
            itemLeftover.addBucket(bucketLeftover);
        } else {
            bucketLeftover.addItems(itemCount);
        }
    }

    @Override
    public void withdraw(Bucket bucket, int itemCount) {
        BucketLeftover bucketLeftover = getBucketLeftover(bucket);
        if (itemCount <= 0) {
            throw new RuntimeException("incorrect value itemCount");
        }
        if (bucketLeftover == null) {
            throw new RuntimeException("items are not in stock");
        }
        if (bucketLeftover.getItemCount() < itemCount) {
            throw new RuntimeException("not enough items");
        }
        else {
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
        return null;
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

    BucketLeftover getBucketLeftover(Bucket bucket) {
        for (BucketLeftover bucketLeftover : getLeftovers(bucket.getItemId()).getBuckets()) {
            if (bucketLeftover.getBucket().equals(bucket)) {
                return bucketLeftover;
            }
        }
        return null;
    }
}