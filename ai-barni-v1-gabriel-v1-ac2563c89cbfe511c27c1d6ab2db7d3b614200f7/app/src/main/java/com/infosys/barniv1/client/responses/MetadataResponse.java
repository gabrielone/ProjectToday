package com.infosys.barniv1.client.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andrei on 25.02.18.
 */

public class MetadataResponse {
    @SerializedName("intentId")
    @Expose
    private String intentId;
    @SerializedName("webhookUsed")
    @Expose
    private String webhookUsed;
    @SerializedName("webhookForSlotFillingUsed")
    @Expose
    private String webhookForSlotFillingUsed;
    @SerializedName("webhookResponseTime")
    @Expose
    private Integer webhookResponseTime;
    @SerializedName("intentName")
    @Expose
    private String intentName;

    public String getIntentId() {
        return intentId;
    }

    public void setIntentId(String intentId) {
        this.intentId = intentId;
    }

    public String getWebhookUsed() {
        return webhookUsed;
    }

    public void setWebhookUsed(String webhookUsed) {
        this.webhookUsed = webhookUsed;
    }

    public String getWebhookForSlotFillingUsed() {
        return webhookForSlotFillingUsed;
    }

    public void setWebhookForSlotFillingUsed(String webhookForSlotFillingUsed) {
        this.webhookForSlotFillingUsed = webhookForSlotFillingUsed;
    }

    public Integer getWebhookResponseTime() {
        return webhookResponseTime;
    }

    public void setWebhookResponseTime(Integer webhookResponseTime) {
        this.webhookResponseTime = webhookResponseTime;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }

}
