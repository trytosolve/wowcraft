package com.iredko.wowcraft2.dao.external_stock;

import com.iredko.wowcraft2.components.stock.Bucket;
import com.iredko.wowcraft2.components.stock.BucketLeftover;
import com.iredko.wowcraft2.components.stock.CraftStock;
import com.iredko.wowcraft2.components.stock.ItemLeftover;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class BucketDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<DBBucket> findAll() {
        List<DBBucket> buckets = this.entityManager.createQuery(
                "SELECT b from DBBucket b").getResultList();
        return buckets;
    }

    @Transactional
    public void merge(DBBucket bucket) {
        this.entityManager.merge(bucket);
    }

    @Transactional
    public void saveStock(CraftStock craftStock) {
        for (ItemLeftover itemLeftover : craftStock.getItemLeftovers()) {
            for (BucketLeftover bucketLeftover : itemLeftover.getBuckets()) {
                Query query = this.entityManager.createQuery("SELECT bucket FROM DBBucket bucket" +
                        " WHERE bucket.itemId=?1 AND bucket.price=?2",DBBucket.class);
                query.setParameter(1, bucketLeftover.getBucket().getItemId());
                query.setParameter(2, bucketLeftover.getBucket().getPrice());
                List<DBBucket> buckets = query.getResultList();
                if (query.getResultList().size() == 0) {
                    DBBucket bucket = new DBBucket(null, bucketLeftover.getBucket().getItemId(),
                            bucketLeftover.getBucket().getPrice(), bucketLeftover.getItemCount());
                    merge(bucket);
                }
                if (query.getResultList().size() == 1) {
                    DBBucket bucket = (DBBucket) query.getSingleResult();
                    bucket.setItemCount(bucketLeftover.getItemCount());
                } else {
                    throw new RuntimeException("Bucket has more than one result");
                }
            }
        }
    }

    @Transactional
    public CraftStock getStock() {
        List<DBBucket> dbBuckets = findAll();
        Set<ItemLeftover> leftovers = new HashSet<>();
        for (DBBucket dbBucket : dbBuckets) {
            ItemLeftover itemLeftover = new ItemLeftover(dbBucket.getItemId());
            leftovers.add(itemLeftover);
        }
        for (DBBucket dbBucket : dbBuckets) {
            Bucket bucket = new Bucket(dbBucket.getItemId(), dbBucket.getPrice());
            BucketLeftover bucketLeftover = new BucketLeftover(bucket, dbBucket.getItemCount());
            for (ItemLeftover itemLeftover : leftovers) {
                if (itemLeftover.getItemId() == dbBucket.getItemId()) {
                    itemLeftover.addBucket(bucketLeftover);
                }
            }
        }

        return new CraftStock(leftovers);
    }
}
