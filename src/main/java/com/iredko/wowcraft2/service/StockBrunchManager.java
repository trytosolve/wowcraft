package com.iredko.wowcraft2.service;

import com.iredko.wowcraft2.dao.stock.StockBrunch;
import com.iredko.wowcraft2.dao.stock.BrunchStockDAO;
import com.iredko.wowcraft2.controllers.stock.StockBrunchInfoModel;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class StockBrunchManager {

    private BrunchStockDAO brunchStockDAO;

    public StockBrunchManager(BrunchStockDAO brunchStockDAO) {
        this.brunchStockDAO = brunchStockDAO;
    }

    @Transactional
    public List<StockBrunchInfoModel> findAll() {
        List<StockBrunchInfoModel> stockBrunchInfoModels = new ArrayList<>();
        List<StockBrunch> stockBrunches = brunchStockDAO.findAll();
        for (StockBrunch stockBrunch : stockBrunches) {
            stockBrunchInfoModels.add(StockBrunchInfoModel.fromEntity(stockBrunch));
        }
        return stockBrunchInfoModels;
    }

    @Transactional
    public void merge(StockBrunchInfoModel stockBrunchInfoModel) {
        brunchStockDAO.merge(StockBrunch.fromModel(stockBrunchInfoModel));
    }

    @Transactional
    public StockBrunchInfoModel findById(Integer id) {
        return StockBrunchInfoModel.fromEntity(brunchStockDAO.findById(id));
    }

    @Transactional
    public void delete(StockBrunchInfoModel stockBrunchInfoModel) {
        brunchStockDAO.delete(StockBrunch.fromModel(stockBrunchInfoModel));
    }

    @Transactional
    public void insert(StockBrunchInfoModel stockBrunchInfoModel) {
        brunchStockDAO.insert(StockBrunch.fromModel(stockBrunchInfoModel));
    }

}
