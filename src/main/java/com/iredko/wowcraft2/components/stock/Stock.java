package com.iredko.wowcraft2.components.stock;

import java.math.BigDecimal;

public interface Stock {
    /**
     * Кладем предметы на склад
     * @param bucket ящик в который кладем
     * @param itemCount кол-во предметов
     */
    void deposit(Bucket bucket, int itemCount);

    /**
     * Забираем предметы со склада.
     * @param bucket ящик из которого забираем
     * @param itemCount кол-во предметов
     */
    void withdraw(Bucket bucket, int itemCount);

    /**
     * Получить остатки на складе по предмету
     * @param itemId  ИД предмета
     * @return остатки
     */
    ItemLeftover getLeftovers(int itemId);

    /**
     * Получить остатки по предмету и цене (остатки в ящике)
     * @param itemId ИД предмета
     * @param price закупочная цена
     * @return кол-во предметов оставшихся в данном ящике
     */
    int getLeftOverByPrice(int itemId, BigDecimal price);
}
