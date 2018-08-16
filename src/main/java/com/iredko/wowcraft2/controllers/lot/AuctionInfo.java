package com.iredko.wowcraft2.controllers.lot;

import java.math.BigDecimal;
import java.util.List;

public class AuctionInfo {

    List<LotInfoModel> lots;

    public AuctionInfo() {
    }

    public AuctionInfo(List<LotInfoModel> lots) {
        this.lots = lots;
    }

    public BigDecimal averagePriceById(int id) {
        BigDecimal sumAllLots = new BigDecimal(0.00);
        int countLots = 0;
        for (LotInfoModel lot: lots) {
            if (lot.getItemId()==id) {
                countLots++;
                BigDecimal decimal = lot.getPrice();
                sumAllLots = sumAllLots.add(decimal);
            }
        }
        if (countLots == 0) {
            return null;
        }
        return sumAllLots.divide(new BigDecimal(countLots),BigDecimal.ROUND_HALF_UP);
    }
}
