package com.infosys.barniv1.client.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Request class.
 */

public class ClientRequest {

    @SerializedName("lang")
    protected String language; // required

    @SerializedName("query")
    protected String query;

    @SerializedName("timezone")
    protected String timeZone;

    @SerializedName("sessionId")
    protected String sessionId;

    @SerializedName("contexts")
    protected List<String> contexts;

    private ClientRequest(RequestBuilder builder) {
        this.language = builder.language;
        this.query = builder.query;
        this.timeZone = builder.timezone;
        this.sessionId = builder.sessionId;
        this.contexts = builder.contexts;
    }

    public static class RequestBuilder {
        private String language;
        private String query;
        private String timezone;
        private String sessionId;
        private List<String> contexts;

        public RequestBuilder language(String language) {
            this.language = language;
            return this;
        }

        public RequestBuilder query(String query) {
            this.query = query;
            return this;
        }

        public RequestBuilder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public RequestBuilder sessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public RequestBuilder contexts(List<String> contexts) {
            this.contexts = contexts;
            return this;
        }

        public ClientRequest build() {
            return new ClientRequest(this);
        }

    }

    public String getLanguage() {
        return language;
    }

    public String getQuery() {
        return query;
    }

}
