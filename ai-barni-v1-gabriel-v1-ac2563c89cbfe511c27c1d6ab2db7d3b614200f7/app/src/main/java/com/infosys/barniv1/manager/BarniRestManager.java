package com.infosys.barniv1.manager;

import com.infosys.barniv1.client.BarniService;
import com.infosys.barniv1.client.BarniRestClient;
import com.infosys.barniv1.client.request.ClientRequest;
import com.infosys.barniv1.client.responses.QueryResponse;

import retrofit2.Call;

/**
 * Manager for specific requests.
 */

public class BarniRestManager {

    private BarniRestClient restClient;

    public BarniRestManager(String token) {
        this.restClient = new BarniRestClient(token);
    }

    public BarniRestManager() {
        this.restClient = new BarniRestClient();
    }

    public Call<QueryResponse> loadResponse(ClientRequest body) {
        return restClient.createService(BarniService.class).loadResponse(body);
    }

    public Call<QueryResponse> loadResponse(String token, ClientRequest body) {
        this.restClient.setToken(token);
        return restClient.createService(BarniService.class).loadResponse(body);
    }

}
