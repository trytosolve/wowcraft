package com.iredko.wowcraft2.components.stock;

import java.util.Objects;

/**
 * Остатки предмета в ящике.
 */
public class BucketLeftover {
    private final Bucket bucket;
    private int itemCount;

    public BucketLeftover(Bucket bucket, int itemCount) {
        this.bucket = bucket;
        this.itemCount = itemCount;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void addItems(int count) {
        itemCount += count;
    }

    public void withdraw(int count) { itemCount -= count; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BucketLeftover bucketLeftover = (BucketLeftover) o;
        return itemCount == bucketLeftover.itemCount &&
                Objects.equals(bucket, bucketLeftover.bucket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bucket, itemCount);
    }
}
