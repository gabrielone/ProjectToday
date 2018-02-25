package com.infosys.barniv1.client.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andrei on 24.02.18.
 */

public class ContextResponse {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("parameters")
    @Expose
    private ContextResponseParameters parameters;
    @SerializedName("lifespan")
    @Expose
    private Integer lifespan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContextResponseParameters getParameters() {
        return parameters;
    }

    public void setParameters(ContextResponseParameters parameters) {
        this.parameters = parameters;
    }

    public Integer getLifespan() {
        return lifespan;
    }

    public void setLifespan(Integer lifespan) {
        this.lifespan = lifespan;
    }

}