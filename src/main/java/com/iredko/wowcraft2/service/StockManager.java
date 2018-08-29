package com.iredko.wowcraft2.service;

import com.iredko.wowcraft2.components.stock.Bucket;
import com.iredko.wowcraft2.components.stock.BucketLeftover;
import com.iredko.wowcraft2.components.stock.CraftStock;

import java.math.BigDecimal;
import java.util.*;

public class StockManager {

    private CraftStock craftStock;

    public StockManager(CraftStock craftStock) {
        this.craftStock = craftStock;
    }

    public BigDecimal calculateCraftPrice(Map<Integer, Integer> mapForCraft, CraftStock craftStock) {
        BigDecimal sum = new BigDecimal(0.00);
        for (Map.Entry<Integer, Integer> item : mapForCraft.entrySet()) {
            Integer itemNeeds = item.getValue();
            Set<BucketLeftover> bucketLeftovers = craftStock.getLeftovers(item.getKey()).getBuckets();
            List<BucketLeftover> sortedList = new ArrayList(bucketLeftovers);
            Collections.sort(sortedList, new SortBucketLeftoverByPrice());
            for (BucketLeftover bucketLeftover : sortedList) {
                if (itemNeeds == 0) {
                    break;
                }
                if (itemNeeds < bucketLeftover.getItemCount()) {
                    BigDecimal cost = bucketLeftover.getBucket().getPrice().multiply(
                            new BigDecimal(itemNeeds));
                    sum = sum.add(cost);
                    itemNeeds = 0;
                } else {
                    itemNeeds = itemNeeds - bucketLeftover.getItemCount();
                    BigDecimal cost = bucketLeftover.getBucket().getPrice().multiply(
                            new BigDecimal(bucketLeftover.getItemCount()));
                    sum = sum.add(cost);
                }
            }
            if (itemNeeds != 0) {
                throw new RuntimeException("not enough items in inventory");
            }
        }
        return sum;
    }

    public void withdraw(Map<Integer, Integer> mapForCraft, CraftStock craftStock) {
        for (Map.Entry<Integer, Integer> item : mapForCraft.entrySet()) {
            Integer itemNeeds = item.getValue();
            Set<BucketLeftover> bucketLeftovers = craftStock.getLeftovers(item.getKey()).getBuckets();
            List<BucketLeftover> sortedList = new ArrayList(bucketLeftovers);
            Collections.sort(sortedList, new SortBucketLeftoverByPrice());
            for (BucketLeftover bucketLeftover : sortedList) {
                if (itemNeeds == 0) {
                    break;
                }
                if (itemNeeds < bucketLeftover.getItemCount()) {
                    craftStock.withdraw(bucketLeftover.getBucket(), itemNeeds);
                    itemNeeds = 0;
                } else {
                    if (bucketLeftover.getItemCount() != 0) {
                        itemNeeds = itemNeeds - bucketLeftover.getItemCount();
                        craftStock.withdraw(bucketLeftover.getBucket(),bucketLeftover.getItemCount());
                    }
                }
            }
            if (itemNeeds != 0) {
                throw new RuntimeException("not enough items in inventory");
            }
        }
    }

    public void deposit(Integer id, BigDecimal craftPrice, CraftStock craftStock) {
        Bucket bucket = new Bucket(id, craftPrice);
        craftStock.deposit(bucket,1);
    }
}
