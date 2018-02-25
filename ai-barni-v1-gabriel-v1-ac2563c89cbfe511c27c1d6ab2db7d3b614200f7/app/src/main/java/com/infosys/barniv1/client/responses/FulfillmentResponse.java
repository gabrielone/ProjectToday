package com.infosys.barniv1.client.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andrei on 25.02.18.
 */

class FulfillmentResponse {

    @SerializedName("speech")
    @Expose
    private String speech;
    @SerializedName("messages")
    @Expose
    private List<MessageResponse> messages = null;

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public List<MessageResponse> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageResponse> messages) {
        this.messages = messages;
    }


}
