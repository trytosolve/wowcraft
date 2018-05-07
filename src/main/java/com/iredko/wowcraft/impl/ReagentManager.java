package com.iredko.wowcraft.impl;

import com.iredko.wowcraft.abstr.AbstractGenericManager;
import com.iredko.wowcraft.entities.Reagent;
import com.iredko.wowcraft.intr.ReagentManagerInterface;
import org.springframework.stereotype.Service;

@Service
public class ReagentManager extends AbstractGenericManager<Reagent, ReagentDao> implements ReagentManagerInterface{
}
