package com.iredko.wowcraft2.controllers.lot;

import java.util.List;

public class AuctionInfo {

    List<LotInfoModel> lots;

    public AuctionInfo() {
    }

    public AuctionInfo(List<LotInfoModel> lots) {
        this.lots = lots;
    }

    public Integer averagePriceByName(String name) {
        Integer sumAllLots = new Integer(0);
        Integer countLots = new Integer(0);
        for (LotInfoModel lot: lots) {
            if (lot.getName().equals(name)) {
                countLots++;
                sumAllLots = sumAllLots + lot.getPrice();
            }
        }
        if (countLots == 0) {
            return null;
        }
        return sumAllLots/countLots;
    }
}
