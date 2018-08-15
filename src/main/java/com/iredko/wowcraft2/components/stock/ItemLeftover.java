package com.iredko.wowcraft2.components.stock;

import java.util.HashSet;
import java.util.Set;

/**
 * Остаток предмета на складе.
 */
public class ItemLeftover {
    private final int itemId;
    private Set<BucketLeftover> buckets;

    public ItemLeftover(int itemId) {
        this(itemId, new HashSet<>());

    }

    public ItemLeftover(int itemId, Set<BucketLeftover> buckets) {
        this.itemId = itemId;
        this.buckets = buckets;
    }

    public int getItemId() {
        return itemId;
    }

    public Set<BucketLeftover> getBuckets() {
        return buckets;
    }

    public void addBucket (BucketLeftover bucketLeftover) {
        buckets.add(bucketLeftover);
    }
}
