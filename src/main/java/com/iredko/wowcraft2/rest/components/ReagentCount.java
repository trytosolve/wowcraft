package com.iredko.wowcraft2.rest.components;

import com.iredko.wowcraft2.controllers.reagent.ReagentInfoModel;

public class ReagentCount {

    private ReagentInfoModel reagent;
    private Integer count;

    public ReagentCount() {
    }

    public ReagentCount(ReagentInfoModel reagent, Integer count) {
        this.reagent = reagent;
        this.count = count;
    }

    public ReagentInfoModel getReagent() {
        return reagent;
    }

    public void setReagent(ReagentInfoModel reagent) {
        this.reagent = reagent;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
