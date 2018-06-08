package com.iredko.wowcraft.service;

import com.iredko.wowcraft.DAO.reagent.ReagentDAO;
import com.iredko.wowcraft.service.AbstractManager;
import com.iredko.wowcraft.DAO.reagent.Reagent;
import com.iredko.wowcraft.service.GenericManager;
import org.springframework.stereotype.Component;

@Component
public class ReagentManager extends AbstractManager<Reagent, ReagentDAO> implements GenericManager<Reagent> {
    public ReagentManager(ReagentDAO tDAO) {
        super(tDAO);
    }

    public void addReagent(String name,Integer itemLvl, Integer maxStack,Integer sellPrice) {
        Reagent reagent = new Reagent(name, itemLvl, maxStack, sellPrice);
        insert(reagent);
    }
}