package com.iredko.wowcraft.impl;

import com.iredko.wowcraft.abstr.AbstractGenericDao;
import com.iredko.wowcraft.entities.Reagent;
import com.iredko.wowcraft.intr.ReagentDAOInterface;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ReagentDao extends AbstractGenericDao<Reagent> implements ReagentDAOInterface {
    private EntityManager entityManager;
    public ReagentDao(EntityManager entityManager) {
        super(Reagent.class, entityManager);
    }
}
