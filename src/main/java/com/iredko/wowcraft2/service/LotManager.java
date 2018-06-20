package com.iredko.wowcraft2.service;

import com.iredko.wowcraft2.DAO.lot.Lot;
import com.iredko.wowcraft2.DAO.lot.LotDao;
import com.iredko.wowcraft2.controllers.lot.LotInfoModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class LotManager {

    LotDao lotDAO;

    public LotManager(LotDao lotDAO) {
        this.lotDAO = lotDAO;
    }

    @Transactional
    public List<LotInfoModel> findAll() {
        List<LotInfoModel> lotInfoModels = new ArrayList<>();
        for (Lot reagent : lotDAO.findAll()) {
            lotInfoModels.add(LotInfoModel.fromEntity(reagent));
        }
        return lotInfoModels;
    }

    @Transactional
        public void merge(LotInfoModel lotInfoModel) {
        lotDAO.merge(Lot.fromModel(lotInfoModel));
    }

    @Transactional
    public LotInfoModel findById(Integer id) {
        return LotInfoModel.fromEntity(lotDAO.findById(id));
    }

    @Transactional
    public void delete(LotInfoModel reagentInfoModel) {
        lotDAO.delete(Lot.fromModel(reagentInfoModel));
    }

    @Transactional
    public void insert(LotInfoModel reagentInfoModel) {
        lotDAO.insert(Lot.fromModel(reagentInfoModel));
    }

    @Transactional
    public boolean exist(Integer id) {
        return lotDAO.exist(id);
    }
}
