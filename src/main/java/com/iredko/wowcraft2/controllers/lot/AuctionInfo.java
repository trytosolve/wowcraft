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

    public BigDecimal averagePriceByName(String name) {
        BigDecimal sumAllLots = new BigDecimal(0);
        int countLots = 0;
        for (LotInfoModel lot: lots) {
            if (lot.getName().equals(name)) {
                countLots++;
                sumAllLots.add(lot.getPrice());
            }
        }
        if (countLots == 0) {
            return null;
        }
        return sumAllLots.divide(new BigDecimal(countLots),BigDecimal.ROUND_HALF_UP);
    }
}
