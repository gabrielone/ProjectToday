package com.infosys.barniv1.client.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andrei on 25.02.18.
 */

public class ResponseParameters {

    @SerializedName("List_item")
    @Expose
    private List<String> listItem = null;

    public List<String> getListItem() {
        return listItem;
    }

    public void setListItem(List<String> listItem) {
        this.listItem = listItem;
    }
}
