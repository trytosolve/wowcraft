package com.iredko.wowcraft.impl;

import com.iredko.wowcraft.abstr.AbstractGenericManager;
import com.iredko.wowcraft.entities.Reagent;
import com.iredko.wowcraft.intr.ReagentManagerInterface;
import org.springframework.stereotype.Component;

@Component
public class ReagentManager extends AbstractGenericManager<Reagent, ReagentDao> implements ReagentManagerInterface{
    public ReagentManager(ReagentDao tDAO) {
        super(tDAO);
    }
}
