package com.iredko.wowcraft2.service;

import com.iredko.wowcraft2.components.stock.BucketLeftover;

import java.math.BigDecimal;
import java.util.Comparator;

public class SortBucketLeftoverByPrice implements Comparator<BucketLeftover> {

    @Override
    public int compare(BucketLeftover o1, BucketLeftover o2) {
        BigDecimal price1 = o1.getBucket().getPrice();
        BigDecimal price2 = o2.getBucket().getPrice();
        return price1.compareTo(price2);
    }
}
