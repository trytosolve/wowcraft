package com.iredko.wowcraft2.service;

import com.iredko.wowcraft2.DAO.reagent.Reagent;
import com.iredko.wowcraft2.DAO.reagent.ReagentDAO;
import com.iredko.wowcraft2.controllers.reagent.ReagentInfoModel;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReagentManager {

    ReagentDAO reagentDAO;

    public ReagentManager(ReagentDAO reagentDAO) {
        this.reagentDAO = reagentDAO;
    }

    @Transactional
    public List<ReagentInfoModel> findAll() {
        List<ReagentInfoModel> reagentInfoModels = new ArrayList<>();
        for (Reagent reagent : reagentDAO.findAll()) {
            reagentInfoModels.add(ReagentInfoModel.fromEntity(reagent));
        }
        return reagentInfoModels;
    }

    @Transactional
    public void merge(ReagentInfoModel reagentInfoModel) {
        reagentDAO.merge(Reagent.fromModel(reagentInfoModel));
    }

    @Transactional
    public ReagentInfoModel findById(Integer id) {
        return ReagentInfoModel.fromEntity(reagentDAO.findById(id));
    }

    @Transactional
    public void delete(ReagentInfoModel reagentInfoModel) {
        reagentDAO.delete(Reagent.fromModel(reagentInfoModel));
    }

    @Transactional
    public void insert(ReagentInfoModel reagentInfoModel) {
        reagentDAO.insert(Reagent.fromModel(reagentInfoModel));
    }

    @Transactional
    public boolean exist(Integer id) {
        return reagentDAO.exist(id);
    }
}
