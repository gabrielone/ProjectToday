package com.infosys.barniv1.client.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andrei on 24.02.18.
 */
public class Status {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("errorType")
    @Expose
    private String errorType;
    @SerializedName("errorDetails")
    @Expose
    private String errorDetails;
    @SerializedName("webhookTimedOut")
    @Expose
    private Boolean webhookTimedOut;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public Boolean getWebhookTimedOut() {
        return webhookTimedOut;
    }

    public void setWebhookTimedOut(Boolean webhookTimedOut) {
        this.webhookTimedOut = webhookTimedOut;
    }

}