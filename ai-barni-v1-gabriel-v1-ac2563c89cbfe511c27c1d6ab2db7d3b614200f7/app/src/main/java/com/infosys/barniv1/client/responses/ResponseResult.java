package com.infosys.barniv1.client.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andrei on 24.02.18.
 */

public class ResponseResult {

    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("resolvedQuery")
    @Expose
    private String resolvedQuery;
    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("actionIncomplete")
    @Expose
    private Boolean actionIncomplete;
    @SerializedName("parameters")
    @Expose
    private ResponseParameters parameters;
    @SerializedName("contexts")
    @Expose
    private List<Context> contexts = null;

    /*
     @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("fulfillment")
    @Expose
    private Fulfillment fulfillment;
    add them urself the rest.
     */
    @SerializedName("score")
    @Expose
    private Double score;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getResolvedQuery() {
        return resolvedQuery;
    }

    public void setResolvedQuery(String resolvedQuery) {
        this.resolvedQuery = resolvedQuery;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Boolean getActionIncomplete() {
        return actionIncomplete;
    }

    public void setActionIncomplete(Boolean actionIncomplete) {
        this.actionIncomplete = actionIncomplete;
    }

    public ResponseParameters getParameters() {
        return parameters;
    }

    public void setParameters(ResponseParameters parameters) {
        this.parameters = parameters;
    }

    public List<Context> getContexts() {
        return contexts;
    }

    public void setContexts(List<Context> contexts) {
        this.contexts = contexts;
    }

    /*
      public Metadata getMetadata() {
          return metadata;
      }

      public void setMetadata(Metadata metadata) {
          this.metadata = metadata;
      }

      public Fulfillment getFulfillment() {
          return fulfillment;
      }

      public void setFulfillment(Fulfillment fulfillment) {
          this.fulfillment = fulfillment;
      }

     */
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

}