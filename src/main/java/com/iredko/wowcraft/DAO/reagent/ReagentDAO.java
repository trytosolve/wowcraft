package com.iredko.wowcraft.DAO.reagent;

import com.iredko.wowcraft.DAO.AbstractDAO;
import com.iredko.wowcraft.DAO.GenericDAO;
import org.springframework.stereotype.Component;

@Component
public class ReagentDAO extends AbstractDAO<Reagent> implements GenericDAO<Reagent> {

    public ReagentDAO() {
        super(Reagent.class);
    }
}
